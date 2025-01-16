package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
     @Query(value ="SELECT b FROM Book b ORDER BY b.updatedAt DESC")
    List<Book> getAllBooks();
}
