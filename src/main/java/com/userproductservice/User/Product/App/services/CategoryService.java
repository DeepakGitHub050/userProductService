package com.userproductservice.User.Product.App.services;

import com.userproductservice.User.Product.App.Repositories.CategoryRepository;
import com.userproductservice.User.Product.App.models.Category;
import com.userproductservice.User.Product.App.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<String> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(Category::getName).toList();
    }

    public Set<Product> getProductByCategory(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        if (category != null) {
            return category.getProducts();
        }
        return null;
    }
    public String deleteCategory(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        if (category != null) {
            categoryRepository.delete(category);
            return categoryName;
        }
        return null;
    }
}
