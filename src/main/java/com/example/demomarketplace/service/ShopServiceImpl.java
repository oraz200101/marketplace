package com.example.demomarketplace.service;

import com.example.demomarketplace.dao.ShopRepositroy;
import com.example.demomarketplace.dao.UserRepository;
import com.example.demomarketplace.dto.ShopDto;
import com.example.demomarketplace.dto.ShopDtoMini;
import com.example.demomarketplace.dto.UserDto;
import com.example.demomarketplace.entities.Role;
import com.example.demomarketplace.entities.Shop;
import com.example.demomarketplace.entities.User;
import com.example.demomarketplace.mapper.AllMapper;
import com.example.demomarketplace.mapper.AllMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepositroy shopRepositroy;
    private final AllMapperImpl allMapper;
    private final UserRepository userRepository;
    @Autowired(required = false)
    public ShopServiceImpl(ShopRepositroy shopRepositroy, AllMapperImpl allMapper, UserRepository userRepository) {
        this.shopRepositroy = shopRepositroy;
        this.allMapper = allMapper;
        this.userRepository = userRepository;
    }




    @Override
    public List<ShopDto> getAll() {
        return allMapper.fromShopList(shopRepositroy.findAll());
    }

    @Override
    @Transactional
    public ShopDto create(ShopDto shopDto, String username) {
       User savedUser=userRepository.findByName(username);
       if(savedUser==null){
           System.out.println("you are not authorize");
       }

       Shop shop=allMapper.toShop(shopDto);
       shop.setUser(savedUser);
       shopRepositroy.save(shop);
       savedUser.setRole(Role.MANAGER);
       userRepository.save(savedUser);


      return allMapper.fromShop(shop);
    }

}
