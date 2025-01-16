package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pembekalan.xsisacademy.dto.request.PublisherRequestDto;
import com.pembekalan.xsisacademy.dto.response.PublisherResponseDto;
import com.pembekalan.xsisacademy.service.PublisherService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/publisher")
public class PublisherController {
    
    @Autowired
    PublisherService publisherService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("publisher/index");
        List<PublisherResponseDto> publishers = publisherService.getAllPublishers();
        String title = "Publisher Page";
        view.addObject("title", title);
        view.addObject("publishers", publishers);
        return view;
    }
    
    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("publisher/form");
        PublisherResponseDto publisher = new PublisherResponseDto();
        view.addObject("publisher", publisher);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute PublisherRequestDto publisherRequestDto, BindingResult result) {
        if (!result.hasErrors()) {
            publisherService.savePublisher(publisherRequestDto);
        }
        return new ModelAndView("redirect:/publisher");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("publisher/form");
       PublisherResponseDto publisherResponseDto = publisherService.getPublisherById(id);
        view.addObject("publisher", publisherResponseDto);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id) {
        publisherService.deletePublisher(id);
        return new ModelAndView("redirect:/publisher");
    }

}
