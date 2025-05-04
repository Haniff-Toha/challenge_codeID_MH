package com.codeid.eshopper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeid.eshopper.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String findAllCategory(Model model) {
        model.addAttribute("categories", service.findAllCategories());
        model.addAttribute("category", service.findAllCategory());
        return "/modules/category/category";
    }
    
    
}
