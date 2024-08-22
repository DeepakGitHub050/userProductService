package com.productservice.Product.App.services;

import com.productservice.Product.App.Repositories.CategoryRepository;
import com.productservice.Product.App.Repositories.ProductRepository;
import com.productservice.Product.App.dtos.ProductDto;
import com.productservice.Product.App.models.Category;
import com.productservice.Product.App.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository1) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository1;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getSingleProduct(Long pId) {
        return productRepository.findById(pId).orElse(null);
    }

    public Product addNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(product.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        Category category = categoryRepository.findCategoryByName(productDto.getCategory());

        if (category != null) {
            product.setCategory(category.getName());
            category.getProducts().add(product);
            productRepository.save(product);
        }
        else {
            Category newCategory = new Category();
            newCategory.setName(productDto.getCategory());
            product.setCategory(newCategory.getName());
            Set<Product> products = Set.of(product);
            newCategory.setProducts(products);
            productRepository.save(product);
            categoryRepository.save(newCategory);
        }

        return product;
    }

    public Product updateProduct(Long pID, ProductDto productDto) {
        Product product = productRepository.findById(pID).orElse(null);
        if (product != null) {
            product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setImageUrl(productDto.getImageUrl());
            Category category = categoryRepository.findCategoryByName(productDto.getCategory());
            if (category != null) {
                product.setCategory(category.getName());
                category.getProducts().add(product);
                productRepository.save(product);
            }
        }
        return product;
    }

    public Product deleteProduct(Long pId) {
        Product product = productRepository.findById(pId).orElse(null);
        if (product != null) {
            Category category = categoryRepository.findCategoryByName(product.getCategory());
            Set<Product> products = category.getProducts();
            products.remove(product);
            productRepository.delete(product);
            return product;
        }
        return null;
    }
}
