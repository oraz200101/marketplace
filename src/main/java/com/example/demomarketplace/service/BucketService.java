package com.example.demomarketplace.service;

import com.example.demomarketplace.dto.BucketDto;
import com.example.demomarketplace.entities.Bucket;
import com.example.demomarketplace.entities.User;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);
    Bucket addProductToBucket(Bucket bucket,List<Long> productIds);
}
