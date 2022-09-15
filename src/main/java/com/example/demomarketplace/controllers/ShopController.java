package com.example.demomarketplace.controllers;

import com.example.demomarketplace.dto.ShopDto;
import com.example.demomarketplace.entities.Shop;
import com.example.demomarketplace.entities.User;
import com.example.demomarketplace.service.ShopServiceImpl;
import com.example.demomarketplace.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {
    private ShopServiceImpl shopService;
    private UserServiceImpl userService;
    @Autowired(required = false)
    public void setShopService(ShopServiceImpl shopService,
                               UserServiceImpl userService) {
        this.shopService = shopService;
        this.userService =userService;
    }
    @PostMapping(consumes = "application/json",produces = "application/json")
    ShopDto create(@RequestBody ShopDto shopDto,Principal principal){
       return shopService.create(shopDto, principal.getName());

    }
}
