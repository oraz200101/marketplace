package com.example.demomarketplace.dao;

import com.example.demomarketplace.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
