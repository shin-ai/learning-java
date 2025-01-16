package com.pembekalan.xsisacademy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.dto.request.AuthorRequestDto;
import com.pembekalan.xsisacademy.dto.response.AuthorResponseDto;
import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.repository.AuthorRepository;
import com.pembekalan.xsisacademy.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    
    @Autowired
    AuthorRepository authorRepository;

    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        List<Author> authors = authorRepository.getAllAuthor();
        List<AuthorResponseDto> authorResponseDtos = authors.stream().map(author -> modelMapper().map(author, AuthorResponseDto.class)).collect(Collectors.toList());
        return authorResponseDtos;
    }

    @Override
    public AuthorResponseDto getAuthorById(Integer id) {
        Author author = authorRepository.findById(id).orElse(null);
        AuthorResponseDto authorResponseDto = modelMapper().map(author, AuthorResponseDto.class);
        return authorResponseDto;
    }
    
    @Override
    public Author saveAuthor(AuthorRequestDto authorRequestDto) {
        Author author = modelMapper().map(authorRequestDto, Author.class);
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

}
