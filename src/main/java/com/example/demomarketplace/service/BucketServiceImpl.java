package com.example.demomarketplace.service;

import com.example.demomarketplace.dao.BucketRepository;
import com.example.demomarketplace.dao.ProductRepository;
import com.example.demomarketplace.dto.BucketDto;
import com.example.demomarketplace.entities.Bucket;
import com.example.demomarketplace.entities.Product;
import com.example.demomarketplace.entities.User;
import com.example.demomarketplace.mapper.AllMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BucketServiceImpl implements BucketService{
    private final ProductRepository productRepository;
    private final BucketRepository bucketRepository;
    private final AllMapperImpl allMapper;
    @Autowired(required = false)
    public BucketServiceImpl(ProductRepository productRepository, BucketRepository bucketRepository, AllMapperImpl allMapper) {
        this.productRepository = productRepository;
        this.bucketRepository = bucketRepository;
        this.allMapper = allMapper;
    }

    @Override
    public Bucket createBucket(User user, List<Long> productIds) {
        Bucket bucket=new Bucket();
        bucket.setUser(user);
        List<Product>productList=getCollectRefProductsById(productIds);
        bucket.setProducts(productList);
       return bucketRepository.save(bucket);
    }
    private List<Product> getCollectRefProductsById(List<Long>productIds){
        return productIds.stream()
                .map(productRepository::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public Bucket addProductToBucket(Bucket bucket, List<Long> productIds) {
        List<Product> products = bucket.getProducts();
        List<Product> newProductList = products == null ? new ArrayList<>() : new ArrayList<>(products);
        newProductList.addAll(getCollectRefProductsById(productIds));
        bucket.setProducts(newProductList);
        return bucketRepository.save(bucket);
    }
}
