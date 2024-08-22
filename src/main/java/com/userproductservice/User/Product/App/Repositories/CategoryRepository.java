package com.userproductservice.User.Product.App.Repositories;

import com.userproductservice.User.Product.App.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import com.userproductservice.User.Product.App.models.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String category);
}
