package com.productservice.Product.App.Repositories;

import com.productservice.Product.App.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
