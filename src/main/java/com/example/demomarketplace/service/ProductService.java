package com.example.demomarketplace.service;

import com.example.demomarketplace.dto.BucketDto;
import com.example.demomarketplace.dto.PostProductDto;
import com.example.demomarketplace.dto.ProductDto;
import com.example.demomarketplace.entities.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto create(ProductDto productDto, Long shopId,Long categoryId, String username);
    Product addProductToCategory(Long productId, Long categoryId);
    Product addProductToShop(Long productId, Long shopId,String username);
    BucketDto addToUserBucket(Long productId, String username);
}
