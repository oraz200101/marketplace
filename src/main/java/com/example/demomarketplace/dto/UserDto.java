package com.example.demomarketplace.dto;

import com.example.demomarketplace.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String matchingPassword;
    private String email;
    private String phone;
    private Role role;
}

