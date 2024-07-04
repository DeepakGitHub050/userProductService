package com.userproductservice.User.Product.App.services;

import com.userproductservice.User.Product.App.dtos.ProductDto;
import com.userproductservice.User.Product.App.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product addNewProduct(ProductDto productDto);

    Product updateProduct(Long productId, ProductDto productDto);

    boolean deleteProduct(Long productId);
}
