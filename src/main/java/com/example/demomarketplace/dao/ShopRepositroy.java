package com.example.demomarketplace.dao;

import com.example.demomarketplace.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepositroy extends JpaRepository<Shop,Long> {
}
