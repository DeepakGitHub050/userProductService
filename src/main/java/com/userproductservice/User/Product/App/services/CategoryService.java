package com.userproductservice.User.Product.App.services;

import com.userproductservice.User.Product.App.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<String> getAllCategories();
    List<Product> getProductByCategory(String category);
}