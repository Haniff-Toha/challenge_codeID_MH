package com.codeid.eshopper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeid.eshopper.service.CategoryService;
import com.codeid.eshopper.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String findAllCategory(Model model) {
        model.addAttribute("category", categoryService.findAllCategories());
        model.addAttribute("products", productService.findAllProducts());
        return "/modules/product/product";
    }
    
}
