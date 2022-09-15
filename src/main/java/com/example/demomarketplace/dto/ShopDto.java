package com.example.demomarketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShopDto {
    private long id;
    private String name;
    private String description;
    private String phone;
    private List<ProductDto> productDtoList;
    private UserDto userDto;
}
