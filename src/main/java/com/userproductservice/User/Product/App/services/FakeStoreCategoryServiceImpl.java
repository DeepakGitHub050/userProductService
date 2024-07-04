package com.userproductservice.User.Product.App.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getProductByCategory(Long categoryId) {
        return null;
    }
}
