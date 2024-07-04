package com.userproductservice.User.Product.App.services;

import org.springframework.stereotype.Service;

public interface CategoryService {
    String getAllCategories();
    String getProductByCategory(Long categoryId);
}