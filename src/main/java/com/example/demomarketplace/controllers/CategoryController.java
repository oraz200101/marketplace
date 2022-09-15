package com.example.demomarketplace.controllers;

import com.example.demomarketplace.dto.CategoryDto;
import com.example.demomarketplace.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryServiceImpl categoryService;
    @Autowired
    public void setCategoryService(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping(consumes = "application/json",produces = "application/json")
    public CategoryDto create(@RequestBody CategoryDto categoryDto){
        return categoryService.create(categoryDto);
    }
}
