package com.pembekalan.xsisacademy.dto.response;

import java.time.LocalDateTime;

import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.entity.Publisher;

import lombok.Data;

@Data
public class BookResponseDto {
    private Integer id;
    private Category category;
    private Publisher publisher;
    private Author author;
    private String title;
    private String synopsis;
    private Integer stock;
    private Integer publishedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
}
