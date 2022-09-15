package com.example.demomarketplace.controllers;

import com.example.demomarketplace.dto.BucketDto;
import com.example.demomarketplace.dto.ProductDto;
import com.example.demomarketplace.entities.Product;
import com.example.demomarketplace.mapper.AllMapperImpl;
import com.example.demomarketplace.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private ProductServiceImpl productService;
    private AllMapperImpl allMapper;
    @Autowired(required = false)
    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }
    @Autowired(required = false)
    public void setAllMapper(AllMapperImpl allMapper) {
        this.allMapper = allMapper;
    }

    @PostMapping (path = "/{shopId}/shop/{categoryId}/category/", produces = "application/json")
    ProductDto create(@RequestBody ProductDto productDto,@PathVariable(value = "shopId") Long shopId,@PathVariable(value = "categoryId") Long categoryId,Principal principal){
        return productService.create(productDto,shopId,categoryId,principal.getName());
    }
    @PutMapping(path = "/{productId}/{shopId}/shop/", produces = "application/json")
    ProductDto addProductToShop(@PathVariable(value = "productId") Long productId, @PathVariable(value = "shopId") Long shopId,
                                Principal principal){
        return allMapper.fromProduct(productService.addProductToShop(productId,shopId, principal.getName()));
    }
    @GetMapping(path = "/{id}/bucket/",produces = "application/json")
    public BucketDto addBucket(@PathVariable Long id, Principal principal){
        if(principal==null){
            throw new RuntimeException("Log in");
        }
        return productService.addToUserBucket(id, principal.getName());
    }

}
