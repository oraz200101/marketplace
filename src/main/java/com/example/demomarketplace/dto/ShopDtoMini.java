package com.example.demomarketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopDtoMini {
    private Long id;
    private String name;
    private String description;
    private String phone;
}
