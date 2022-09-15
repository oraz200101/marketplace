package com.example.demomarketplace.controllers;

import com.example.demomarketplace.dto.UserDto;
import com.example.demomarketplace.entities.User;
import com.example.demomarketplace.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping(consumes = "application/json",produces ="application/json")
    private User saveUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
    @PutMapping(consumes = "application/json",produces = "application/json")
    private User update(@RequestBody UserDto userDto, Principal principal){
        if(principal==null||!Objects.equals(userDto.getName(),principal.getName())){
            throw new RuntimeException("You are not authorize");
        }
        if(userDto.getPassword()!=null
                &&!userDto.getPassword().isEmpty()
                &&Objects.equals(userDto.getPassword(),userDto.getMatchingPassword())){
           return userService.update(userDto);
        }
       throw new RuntimeException("mistake");
    }

}
