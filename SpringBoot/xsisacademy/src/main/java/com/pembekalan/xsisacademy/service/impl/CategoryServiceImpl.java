package com.pembekalan.xsisacademy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.dto.request.CategoryRequestDto;
import com.pembekalan.xsisacademy.dto.response.CategoryResponseDto;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.repository.CategoryRepository;
import com.pembekalan.xsisacademy.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    CategoryRepository categoryRepository;

    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categories = categoryRepository.getAllCategory();
        List<CategoryResponseDto> categoryResponseDtos = categories.stream().map(category -> modelMapper().map(category, CategoryResponseDto.class)).collect(Collectors.toList());
        return categoryResponseDtos;
    }

    @Override
    public CategoryResponseDto getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        CategoryResponseDto categoryResponseDto = modelMapper().map(category, CategoryResponseDto.class);
        return categoryResponseDto;
    }

    @Override
    public Category saveCategory(CategoryRequestDto categoryRequestDto) {
        Category category = modelMapper().map(categoryRequestDto, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category!= null) {
            category.setIsDeleted(true);
            categoryRepository.save(category);
        }
    }

}
