package com.pembekalan.xsisacademy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Book extends BaseEntity {
    
    public Book(Author author, Category category, Publisher publisher, String title, String synopsis, Integer stock, Integer publishedAt) {
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.title = title;
        this.synopsis = synopsis;
        this.stock = stock;
        this.publishedAt = publishedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    // @Column(name = "author_id")
    // private Long authorId;
    // @Column(name = "category_id")
    // private Long categoryId;
    // @Column(name = "publisher_id")
    // private Long publisherId;

    private String title;
    private String synopsis;
    private Integer stock;
    private Integer publishedAt;
}
