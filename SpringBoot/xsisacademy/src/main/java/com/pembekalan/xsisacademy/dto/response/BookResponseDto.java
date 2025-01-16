package com.pembekalan.xsisacademy.dto.response;

import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.entity.Publisher;

import lombok.Data;

@Data
public class BookResponseDto {
    private Integer id;

    private String title;
    private String synopsis;
    private Integer stock;
    private String publishedAt;

    private Author author;
    private Category category;
    private Publisher publisher;
}
