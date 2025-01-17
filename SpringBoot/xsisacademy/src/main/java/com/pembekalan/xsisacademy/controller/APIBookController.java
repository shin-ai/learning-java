package com.pembekalan.xsisacademy.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.request.BookRequestDto;
import com.pembekalan.xsisacademy.dto.response.ApiResponseDto;
import com.pembekalan.xsisacademy.dto.response.BookResponseDto;
import com.pembekalan.xsisacademy.entity.Book;
import com.pembekalan.xsisacademy.service.BookService;

@RestController
@RequestMapping("/api/book")
public class APIBookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<?> getAllBook() {
        try {
            List<BookResponseDto> bookResponse = bookService.getAllBooks();
            return ResponseEntity.ok(new ApiResponseDto<>(200, "success", bookResponse));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponseDto<>(500, "internal server error", e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        BookResponseDto bookResponseDto = bookService.getBookById(id);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", bookResponseDto);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveBook(@RequestBody BookRequestDto bookRequestDto){
        // ModelMapper modelMapper = new ModelMapper();
        // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        // modelMapper.getConfiguration().setSkipNullEnabled(true);
        Book book = bookService.saveBook(bookRequestDto);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", book);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody BookRequestDto bookRequestDto) {
        bookRequestDto.setId(id);
        bookRequestDto.setAuthor_id(bookRequestDto.getAuthor_id());
        bookRequestDto.setPublisher_id(bookRequestDto.getPublisher_id());
        bookRequestDto.setCategory_id(bookRequestDto.getPublisher_id());

        bookService.saveBook(bookRequestDto);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", bookRequestDto);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

}
