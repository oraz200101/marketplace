package com.example.demomarketplace.service;

import com.example.demomarketplace.dto.ShopDto;
import com.example.demomarketplace.dto.UserDto;
import com.example.demomarketplace.entities.Shop;

import java.util.List;

public interface ShopService {
    List<ShopDto> getAll();
    ShopDto create(ShopDto shopDto, String username);

}
