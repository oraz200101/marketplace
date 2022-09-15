package com.example.demomarketplace.service;

import com.example.demomarketplace.dto.CategoryDto;
import com.example.demomarketplace.entities.Category;

public interface CategoryService {
    CategoryDto create(CategoryDto categoryDto);
}
