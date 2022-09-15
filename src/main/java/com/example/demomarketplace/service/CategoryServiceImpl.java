package com.example.demomarketplace.service;

import com.example.demomarketplace.dao.CategoryRepository;
import com.example.demomarketplace.dto.CategoryDto;
import com.example.demomarketplace.entities.Category;
import com.example.demomarketplace.mapper.AllMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final AllMapperImpl allMapper;
    @Autowired(required = false)
    public CategoryServiceImpl(CategoryRepository categoryRepository, AllMapperImpl allMapper) {
        this.categoryRepository = categoryRepository;
        this.allMapper = allMapper;
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        return allMapper.fromCategory(categoryRepository.save(allMapper.toCategory(categoryDto)));
    }
}
