package com.pembekalan.xsisacademy.dto.request;

import lombok.Data;

@Data
public class BookRequestDto {
    private Integer id;

    private String title;
    private String synopsis;
    private Integer stock;
    private String publishedAt;

    private Integer author_id;
    private Integer category_id;
    private Integer publisher_id;
}
