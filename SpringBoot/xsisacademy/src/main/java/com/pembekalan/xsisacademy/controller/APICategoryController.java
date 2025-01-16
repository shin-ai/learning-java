package com.pembekalan.xsisacademy.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.request.CategoryRequestDto;
import com.pembekalan.xsisacademy.dto.response.ApiResponseDto;
import com.pembekalan.xsisacademy.dto.response.CategoryResponseDto;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.service.CategoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/category")
public class APICategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategory() {
        try {
            List<CategoryResponseDto> categoryResponse = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponseDto<>(200, "success", categoryResponse));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponseDto<>(500, "internal server error", e));
        }
    }

    // @GetMapping("")
    // public ResponseEntity<?> getAllCategory() {
    //     LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
    //     try {
    //         List<CategoryResponseDto> categoryResponse = categoryService.getAllCategories();
    //         resultMap.put("status", "200");
    //         resultMap.put("message", "success");
    //         resultMap.put("data", categoryResponse);
    //         return new ResponseEntity<>(resultMap, HttpStatus.OK);
    //     } catch (Exception e) {
    //         resultMap.put("status", "500");
    //         resultMap.put("message", "failed");
    //         resultMap.put("error", e);
    //         return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            CategoryResponseDto CategoryResponseDto = categoryService.getCategoryById(id);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("data", CategoryResponseDto);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            Category category = categoryService.saveCategory(categoryRequestDto);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("data", category);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequestDto categoryRequestDto) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            categoryRequestDto.setId(id);
            categoryService.saveCategory(categoryRequestDto);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            resultMap.put("data", categoryRequestDto);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            categoryService.deleteCategory(id);
            resultMap.put("status", "200");
            resultMap.put("message", "success");
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
