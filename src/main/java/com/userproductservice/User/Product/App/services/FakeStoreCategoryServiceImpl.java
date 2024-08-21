package com.userproductservice.User.Product.App.services;

import com.userproductservice.User.Product.App.dtos.ProductDto;
import com.userproductservice.User.Product.App.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<String> getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class);
        String[] str = response.getBody();
        assert str != null;
        return Arrays.stream(str).toList();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> products =restTemplate.getForEntity("https://fakestoreapi.com/products/category/" + category, ProductDto[].class);

        if (products.getBody() != null) {
            ProductDto[] productDtos = Objects.requireNonNull(products.getBody());
            List<Product> productList = new ArrayList<>();
            for (ProductDto productDto : productDtos) {
                Product product = new Product();
                product.setId(productDto.getId());
                product.setCategory(productDto.getCategory());
                product.setImageUrl(productDto.getImage());
                product.setRating(productDto.getRating());
                product.setDescription(productDto.getDescription());
                product.setPrice(productDto.getPrice());
                product.setTitle(productDto.getTitle());
                productList.add(product);
            }

            return productList;
        }
        else
            return null;
    }
}
