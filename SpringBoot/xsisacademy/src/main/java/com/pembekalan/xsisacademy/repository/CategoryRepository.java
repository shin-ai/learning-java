package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pembekalan.xsisacademy.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    // @Query(value ="SELECT * FROM category ORDER BY updated_at DESC", nativeQuery = true)
    // List<Category> getAllCategory();

    @Query(value ="SELECT c FROM Category c ORDER BY c.updatedAt DESC")
    List<Category> getAllCategory();
}
