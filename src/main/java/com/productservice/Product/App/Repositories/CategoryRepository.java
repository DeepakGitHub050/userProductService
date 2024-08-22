package com.productservice.Product.App.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.productservice.Product.App.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String category);
}
