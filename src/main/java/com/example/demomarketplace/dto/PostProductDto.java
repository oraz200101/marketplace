package com.example.demomarketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostProductDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private List<Long> categoryDtos;
    private List<ShopDto>shopDtos;

}

