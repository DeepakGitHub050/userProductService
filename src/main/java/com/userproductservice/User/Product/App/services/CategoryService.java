package com.userproductservice.User.Product.App.services;

import com.userproductservice.User.Product.App.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<String>();
        categories.add("Category 1");
        categories.add("Category 2");
        categories.add("Category 3");
        return categories;
    }

    public List<Product> getProductByCategory(String category) {
        return null;
    }
}
