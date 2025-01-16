package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.response.ApiResponseDto;
import com.pembekalan.xsisacademy.dto.response.BookResponseDto;
import com.pembekalan.xsisacademy.service.BookService;

@RestController
@RequestMapping("/api/book")
public class APIBookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategory() {
        try {
            List<BookResponseDto> bookResponse = bookService.getAllBooks();
            return ResponseEntity.ok(new ApiResponseDto<>(200, "success", bookResponse));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponseDto<>(500, "internal server error", e));
        }
    }
}
