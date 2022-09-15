package com.example.demomarketplace.dto;


import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private List<CategoryDto> categoryDtos;
    private List<ShopDto>shopDtos;
    private List<ShopDtoMini> shopDtoMinis;
}

