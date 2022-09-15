package com.example.demomarketplace.service;

import com.example.demomarketplace.dto.UserDto;
import com.example.demomarketplace.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
   User save(UserDto userDto);
   User update(UserDto userDto);
   User findByName(String name);

}
