package com.productservice.Product.App.services;

import com.productservice.Product.App.Repositories.CategoryRepository;
import com.productservice.Product.App.models.Category;
import com.productservice.Product.App.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
