package com.example.demomarketplace.service;

import com.example.demomarketplace.dao.UserRepository;
import com.example.demomarketplace.dto.UserDto;
import com.example.demomarketplace.entities.Role;
import com.example.demomarketplace.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User save(UserDto userDto) {
        if(!Objects.equals(userDto.getPassword(),userDto.getMatchingPassword())){
            throw new RuntimeException("Password no equal");
        }
        User user=User.builder()
                .name(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .role(Role.CLIENT)
                .build();
        return userRepository.save(user);
    }
    @Transactional
    public User update(UserDto userDto) {
        User savedUser =userRepository.findByName(userDto.getName());
        if(savedUser==null) {
            throw new RuntimeException("user not found with name" + userDto.getName());
        }
        boolean isChanged=false;
        if (userDto.getPassword()!=null && !userDto.getPassword().isEmpty()){
            savedUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
            isChanged=true;
        }
        if(!Objects.equals(userDto.getPhone(),savedUser.getPhone())){
            savedUser.setPhone(userDto.getPhone());
            isChanged=true;
        }
        if(!Objects.equals(userDto.getEmail(),savedUser.getEmail())){
            savedUser.setEmail(userDto.getEmail());
            isChanged=true;
        }
        if(isChanged){
            return userRepository.save(savedUser);
        }
        throw new RuntimeException("One of argument mistake");

    }


    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByName(username);
        if (user==null){
            throw new UsernameNotFoundException("user not found with name"+username);
        }
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                roles
        );
    }
}
