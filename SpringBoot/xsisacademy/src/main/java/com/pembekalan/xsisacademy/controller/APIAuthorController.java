package com.pembekalan.xsisacademy.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.request.AuthorRequestDto;
import com.pembekalan.xsisacademy.dto.response.AuthorResponseDto;
import com.pembekalan.xsisacademy.service.AuthorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/author")
public class APIAuthorController {
    
    @Autowired
    AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<?> getAllAuthor() {
        List<AuthorResponseDto> authorResponse = authorService.getAllAuthors();
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", authorResponse);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    
    @GetMapping("/{id}/")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer id) {
        AuthorResponseDto authorResponse = authorService.getAuthorById(id);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status","200");
        resultMap.put("message","success");
        resultMap.put("data",authorResponse);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody AuthorRequestDto authorRequestDto) {
        authorRequestDto.setId(id);
        authorService.saveAuthor(authorRequestDto);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", authorRequestDto);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

}
