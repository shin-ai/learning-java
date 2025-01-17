// package com.pembekalan.xsisacademy.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.pembekalan.xsisacademy.dto.request.AuthorRequestDto;
// import com.pembekalan.xsisacademy.dto.response.AuthorResponseDto;
// import com.pembekalan.xsisacademy.service.AuthorService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.servlet.ModelAndView;


// @Controller
// @RequestMapping("/author")
// public class AuthorController {
    
//     @Autowired
//     AuthorService authorService;

//     @GetMapping("")
//     public ModelAndView getAllAuthors() {
//         ModelAndView view = new ModelAndView("author/index");
//         List<AuthorResponseDto> authorResponseDtos = authorService.getAllAuthors();
//         String title = "Author Page";
//         view.addObject("title", title);
//         view.addObject("authors", authorResponseDtos);
//         return view;
//     }

//     @GetMapping("/form")
//     public ModelAndView userForm() {
//         ModelAndView view = new ModelAndView("author/form");
//         AuthorResponseDto authorResponseDto = new AuthorResponseDto();
//         view.addObject("author", authorResponseDto);
//         return view;
//     }

//     @PostMapping("/save")
//     public ModelAndView saveUser(@ModelAttribute AuthorRequestDto auhtorRequestDto, BindingResult result) {
//         if (!result.hasErrors()) {
//             authorService.saveAuthor(auhtorRequestDto);
//         }
//         return new ModelAndView("redirect:/author");
//     }

//     @GetMapping("/edit/{id}")
//     public ModelAndView editUser(@PathVariable Integer id) {
//         ModelAndView view = new ModelAndView("author/form");
//         AuthorResponseDto authorResponseDto = authorService.getAuthorById(id);
//         view.addObject("author", authorResponseDto);
//         return view;
//     }

//     @GetMapping("/delete/{id}")
//     public ModelAndView deleteUser(@PathVariable Integer id) {
//         authorService.deleteAuthor(id);
//         return new ModelAndView("redirect:/author");
//     }    
// };