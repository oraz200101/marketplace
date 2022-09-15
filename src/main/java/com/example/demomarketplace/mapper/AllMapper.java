package com.example.demomarketplace.mapper;

import com.example.demomarketplace.dto.*;
import com.example.demomarketplace.entities.*;

import java.util.List;

public interface AllMapper  {
    Product toProduct(ProductDto productDto);
    ProductDto fromProduct(Product product);
    List<Product> toProductList(List<ProductDto> productDtos);
    List<ProductDto> fromProductList(List<Product> products);
    ProductDtoMini fromProductMini(Product product);
    List<ProductDtoMini> fromProductMiniList(List<Product> products);

    Category toCategory(CategoryDto categoryDto);
    CategoryDto fromCategory(Category category);
    List<Category> toCategoryList( List<CategoryDto> categoryDtos);
    List<CategoryDto> fromCategoryList(List<Category> categories);
    Shop toShop(ShopDto shopDto);
    ShopDto fromShop(Shop shop);
    List<Shop> toShopList(List<ShopDto> shopDtos);
    List<ShopDto> fromShopList(List<Shop> shops);
    ShopDtoMini fromShopMini(Shop shop);
    List<ShopDtoMini> fromShopListMini(List<Shop> shops);
    User toUser(UserDto userDto);
    UserDto fromUser(User user);
    List<User> toUserList(List<UserDto> userDtos);
    List<UserDto>fromUserList(List<User>users);
    BucketDto fromBucket(Bucket bucket);

}
