package com.pembekalan.xsisacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.pembekalan.xsisacademy.dto.response.CategoryResponseDto;
import com.pembekalan.xsisacademy.utility.ApiEndpoints;

import java.util.Map;

@Controller
public class ViewController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/publisher")
    public String getAllPublishers(Model model) {
        String title = "Publisher Page";
        Map response = restTemplate.getForObject(ApiEndpoints.PUBLISHERS, Map.class);
        model.addAttribute("publishers", response.get("data"));
        model.addAttribute("title", title);
        return "publisher/index"; // templates/publisher/index.html
    }

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        String title = "User Page";
        Map response = restTemplate.getForObject(ApiEndpoints.USERS, Map.class);
        model.addAttribute("users", response.get("data"));
        model.addAttribute("title", title);
        return "user/index"; // templates/publisher/index.html
    }

    @GetMapping("/category")
    public String getAllCategories(Model model) {
        String title = "Category Page";
        Map response = restTemplate.getForObject(ApiEndpoints.CATEGORIES, Map.class);
        model.addAttribute("categories", response.get("data"));
        model.addAttribute("title", title);
        return "category/index"; // templates/publisher/index.html
    }

    @GetMapping("/category/form")
    public String formCategories(Model model) {
        String title = "Category Form";
        CategoryResponseDto categoyResponseDto = new CategoryResponseDto();
        model.addAttribute("category", categoyResponseDto);
        model.addAttribute("title", title);
        return "category/form"; // templates/publisher/index.html
    }

    @GetMapping("/author")
    public String getAllAuthors(Model model) {
        String title = "Author Page";
        Map response = restTemplate.getForObject(ApiEndpoints.AUTHORS, Map.class);
        model.addAttribute("authors", response.get("data"));
        model.addAttribute("title", title);
        return "author/index"; // templates/publisher/index.html
    }

    @GetMapping("/book")
    public String getAllBooks(Model model) {
        String title = "Book Page";
        Map response = restTemplate.getForObject(ApiEndpoints.BOOKS, Map.class);
        model.addAttribute("books", response.get("data"));
        model.addAttribute("title", title);
        return "book/index"; // templates/publisher/index.html
    }
}
