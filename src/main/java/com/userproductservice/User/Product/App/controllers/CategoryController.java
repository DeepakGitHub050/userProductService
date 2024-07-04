package com.userproductservice.User.Product.App.controllers;

import com.userproductservice.User.Product.App.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllCategories() {
        return "All categories";
    }

    @GetMapping("/{categoryId}")
    public String getProductsInCategory(@PathVariable("categoryId") Long categoryId) {
        return "Category " + categoryId + " products";
    }

}
