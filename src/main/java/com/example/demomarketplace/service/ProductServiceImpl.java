package com.example.demomarketplace.service;

import com.example.demomarketplace.dao.CategoryRepository;
import com.example.demomarketplace.dao.ProductRepository;
import com.example.demomarketplace.dao.ShopRepositroy;
import com.example.demomarketplace.dao.UserRepository;
import com.example.demomarketplace.dto.BucketDto;
import com.example.demomarketplace.dto.ProductDto;
import com.example.demomarketplace.entities.*;
import com.example.demomarketplace.mapper.AllMapper;
import com.example.demomarketplace.mapper.AllMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private AllMapperImpl allMapper;
    private ShopRepositroy shopRepositroy;
    private BucketServiceImpl bucketService;
    private UserServiceImpl userService;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;


    @Autowired(required = false)
    public void setProductRepository(ProductRepository productRepository, AllMapperImpl allMapper, CategoryRepository categoryRepository,

                                  BucketServiceImpl bucketService   ,ShopRepositroy shopRepositroy,UserServiceImpl userService,UserRepository userRepository) {
        this.productRepository = productRepository;
        this.allMapper= allMapper;
        this.shopRepositroy=shopRepositroy;
        this.userService=userService;
        this.userRepository=userRepository;
        this.bucketService=bucketService;
        this.categoryRepository=categoryRepository;

    }


    @Override
    public List<ProductDto> getAll() {
        return allMapper.fromProductList(productRepository.findAll());
    }

    @Override
    @Transactional
    public ProductDto create(ProductDto productDto, Long shopId,Long categoryId,String username) {
        Product product=allMapper.toProduct(productDto);
        productRepository.save(product);
        addProductToCategory(product.getId(),categoryId);
        return allMapper.fromProduct(addProductToShop(product.getId(),shopId,username));
    }

    @Override
    public Product addProductToCategory(Long productId, Long categoryId) {
        Product product=productRepository.getById(productId);
        Category category=categoryRepository.getById(categoryId);
        List<Category>categories=product.getCategories();
        List<Category>newCategoryList=categories==null?new ArrayList<>():new ArrayList<>(categories);
         newCategoryList.add(category);
         product.setCategories(newCategoryList);
         productRepository.save(product);
         return product;
    }

    @Override
    @Transactional
    public Product addProductToShop(Long productId, Long shopId, String username) {
        User savedUser=userService.findByName(username);
        Product product=productRepository.getById(productId);
        Shop shop =shopRepositroy.getById(shopId);
        User shopUser=shop.getUser();
        if(Objects.equals(savedUser,shopUser)){
        List<Shop>shops=product.getShops();
        List<Shop> newShopList=shops==null? new ArrayList<>():new ArrayList<>(shops);
        newShopList.add(shop);
        product.setShops(newShopList);
        productRepository.save(product);
        return product;
    }
        throw new RuntimeException("Shop doesn't belong to user");
    }

    @Override
    public BucketDto addToUserBucket(Long productId, String username) {
        User user = userService.findByName(username);
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        Bucket bucket = user.getBucket();
        if (bucket == null) {
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userRepository.save(user);
        } else {
            return allMapper.fromBucket(bucketService.addProductToBucket(bucket, Collections.singletonList(productId)));
        }
       return allMapper.fromBucket(user.getBucket());
    }
}
    //    public void addProductToShop(ProductDto productDto,List<Long>ShopIds){
//        Product product =create(productDto);
//
//    }
//    private List<ShopDto> getCollectById(List<Long> shopIds){
//        List<Shop>shops=shopIds.stream().map(shopRepositroy::getById).collect(Collectors.toList());
//        return shopMapper.fromShopList(shops);
//    }

