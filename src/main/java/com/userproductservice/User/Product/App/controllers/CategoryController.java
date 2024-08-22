package com.userproductservice.User.Product.App.controllers;

import com.userproductservice.User.Product.App.models.Product;
import com.userproductservice.User.Product.App.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<Set<Product>> getProductsInCategory(@PathVariable("category") String category) {
        Set<Product> res = categoryService.getProductByCategory(category);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{category}")
    public ResponseEntity<String> deleteCategory(@PathVariable("category") String category) {
        String categoryName = categoryService.deleteCategory(category);
        if (categoryName!=null){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
