package com.example.demomarketplace.mapper;

import com.example.demomarketplace.dto.*;
import com.example.demomarketplace.entities.*;
import org.mapstruct.Mapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class AllMapperImpl implements AllMapper {

    @Override
    public Product toProduct(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategories(toCategoryList(productDto.getCategoryDtos()));
        product.setPrice(productDto.getPrice());
        product.setShops(toShopList(productDto.getShopDtos()));
        return product;
    }

    @Override
    public ProductDto fromProduct(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryDtos(fromCategoryList(product.getCategories()));
        productDto.setShopDtoMinis(fromShopListMini(product.getShops()));
        return productDto;
    }

    @Override
    public List<Product> toProductList(List<ProductDto> productDtos) {
        if (productDtos == null) {
            return null;
        }
        List<Product> list = new ArrayList<>(productDtos.size());
        for (ProductDto productDto : productDtos) {
            list.add(toProduct(productDto));
        }
        return list;
    }

    @Override
    public List<ProductDto> fromProductList(List<Product> products) {
        if (products == null) {
            return null;
        }
        List<ProductDto> list = new ArrayList<>(products.size());
        for (Product product : products) {
            list.add(fromProduct(product));
        }
        return list;
    }



    @Override
    public ProductDtoMini fromProductMini(Product product) {
        if (product == null) {
            return null;
        }
        ProductDtoMini productDtoMini= new ProductDtoMini();
        productDtoMini.setId(product.getId());
        productDtoMini.setName(product.getName());
        productDtoMini.setDescription(product.getDescription());
        productDtoMini.setPrice(product.getPrice());
        return productDtoMini;
    }


    @Override
    public List<ProductDtoMini> fromProductMiniList(List<Product> products) {
        if (products == null) {
            return null;
        }
        List<ProductDtoMini> list = new ArrayList<>(products.size());
        for (Product product : products) {
            list.add(fromProductMini(product));
        }
        return list;
    }

    @Override
    public Category toCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setProducts(toProductList(categoryDto.getProductDtos()));
        return category;
    }

    @Override
    public CategoryDto fromCategory(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setProductDtos(fromProductList(category.getProducts()));
        return categoryDto;
    }

    @Override
    public List<Category> toCategoryList(List<CategoryDto> categoryDtos) {
        if (categoryDtos == null) {
            return null;
        }
        List<Category> list = new ArrayList<>(categoryDtos.size());
        for (CategoryDto categoryDto : categoryDtos) {
            list.add(toCategory(categoryDto));
        }
        return list;

    }

    @Override
    public List<CategoryDto> fromCategoryList(List<Category> categories) {
        if (categories == null) {
            return null;
        }
        List<CategoryDto> list = new ArrayList<>(categories.size());
        for (Category category : categories) {
            list.add(fromCategory(category));
        }
        return list;
    }

    @Override
    public Shop toShop(ShopDto shopDto) {
        if (shopDto == null) {
            return null;
        }
        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        shop.setId(shopDto.getId());
        shop.setProducts(toProductList(shopDto.getProductDtoList()));
        shop.setDescription(shopDto.getDescription());
        shop.setPhone(shopDto.getPhone());
        shop.setUser(toUser(shopDto.getUserDto()));
        return shop;
    }

    @Override
    public ShopDto fromShop(Shop shop) {
        if (shop == null) {
            return null;
        }
        ShopDto shopDto = new ShopDto();
        shopDto.setName(shop.getName());
        shopDto.setId(shop.getId());
        shopDto.setProductDtoList(fromProductList(shop.getProducts()));
        shopDto.setDescription(shop.getDescription());
        shopDto.setPhone(shop.getPhone());
        shopDto.setUserDto(fromUser(shop.getUser()));
        return shopDto;
    }


    @Override
    public List<Shop> toShopList(List<ShopDto> shopDtos) {
        if (shopDtos == null) {
            return null;
        }
        List<Shop> list = new ArrayList<>(shopDtos.size());
        for (ShopDto shopDto : shopDtos) {
            list.add(toShop(shopDto));
        }
        return list;
    }

    @Override
    public List<ShopDto> fromShopList(List<Shop> shops) {
        if (shops == null) {
            return null;
        }
        List<ShopDto> list = new ArrayList<>(shops.size());
        for (Shop shop : shops) {
            list.add(fromShop(shop));
        }
        return list;
    }

    @Override
    public ShopDtoMini fromShopMini(Shop shop) {
        if(shop ==null){
            return null;
        }
        ShopDtoMini shopDtoMini=new ShopDtoMini();
        shopDtoMini.setId(shop.getId());
        shopDtoMini.setDescription(shop.getDescription());
        shopDtoMini.setPhone(shop.getPhone());
        shopDtoMini.setName(shop.getName());
        return shopDtoMini;
    }

    @Override
    public List<ShopDtoMini> fromShopListMini(List<Shop> shops) {
        if (shops == null) {
            return null;
        }
        List<ShopDtoMini> list = new ArrayList<>(shops.size());
        for (Shop shop : shops) {
            list.add(fromShopMini(shop));
        }
        return list;
    }

    @Override
    public User toUser(UserDto userDto) {
        if(userDto==null){
        return null;
        }
        User user=new User();
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return user;
    }

    @Override
    public UserDto fromUser(User user) {
        if(user==null){
            return null;
        }
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

    @Override
    public List<User> toUserList(List<UserDto> userDtos) {
        if(userDtos==null){
        return null;}
        List<User> list=new ArrayList<>(userDtos.size());
        for (UserDto userDto:userDtos){
            list.add(toUser(userDto));
        }
        return list;
    }

    @Override
    public List<UserDto> fromUserList(List<User> users) {
        if(users==null){
            return null;}
        List<UserDto> list=new ArrayList<>(users.size());
        for (User user:users){
            list.add(fromUser(user));
        }
        return list;
    }

    @Override
    public BucketDto fromBucket(Bucket bucket) {
        if(bucket==null){
            return null;
        }
        BucketDto bucketDto=new BucketDto();
        bucketDto.setId(bucket.getId());
        bucketDto.setUserDto(fromUser(bucket.getUser()));
        bucketDto.setProductDtoMinis(fromProductMiniList(bucket.getProducts()));
        return bucketDto;
    }

}
