package com.example.demomarketplace.dao;

import com.example.demomarketplace.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  User findByName(String name);
}
