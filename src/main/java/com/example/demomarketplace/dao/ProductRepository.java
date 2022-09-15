package com.example.demomarketplace.dao;

import com.example.demomarketplace.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
