package com.pembekalan.xsisacademy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.dto.request.BookRequestDto;
import com.pembekalan.xsisacademy.dto.response.BookResponseDto;
import com.pembekalan.xsisacademy.entity.Book;
import com.pembekalan.xsisacademy.repository.BookRepository;
import com.pembekalan.xsisacademy.service.BookService;

@Service
public class BookServiceImpl implements BookService{
    
    @Autowired
    BookRepository bookRepository;

    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        List<BookResponseDto> booksResponseDtos = books.stream().map(book -> modelMapper().map(book, BookResponseDto.class)).collect(Collectors.toList());
        return booksResponseDtos;
    }

    @Override
    public BookResponseDto getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        BookResponseDto bookResponseDto = modelMapper().map(book, BookResponseDto.class);
        return bookResponseDto;
    }

    @Override
    public Book saveBook(BookRequestDto BookRequestDto) {
        Book book = modelMapper().map(BookRequestDto, Book.class);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

}
