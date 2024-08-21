package com.userproductservice.User.Product.App.services;

import com.userproductservice.User.Product.App.dtos.ProductDto;
import com.userproductservice.User.Product.App.models.Category;
import com.userproductservice.User.Product.App.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductServiceIml implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;


    public FakeStoreProductServiceIml(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<ProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);

        List<Product> resProducts = new ArrayList<>();

        for (ProductDto dto : Objects.requireNonNull(response.getBody())) {
            Product product = new Product();
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setPrice(dto.getPrice());
            product.setDescription(dto.getDescription());
            Category category = new Category();
            category.setName(dto.getCategory());
            product.setCategory(String.valueOf(category));
            product.setImageUrl(dto.getImage());
            resProducts.add(product);
        }
        return resProducts;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class,productId);

        ProductDto productDto = response.getBody();
        Product product = new Product();
        assert productDto != null;
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(String.valueOf(category));
        product.setImageUrl(productDto.getImage());
        product.setRating(productDto.getRating());

        return product;
    }
    @Override
    public Product addNewProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDto.class);

        ProductDto productDto1 = response.getBody();
        Product product1 = new Product();
        assert productDto1 != null;
        product1.setId(productDto1.getId());
        product1.setTitle(productDto1.getTitle());
        product1.setPrice(productDto1.getPrice());
        product1.setDescription(productDto1.getDescription());
        Category category = new Category();
        category.setName(productDto1.getCategory());
        product1.setCategory(String.valueOf(category));
        product1.setImageUrl(productDto1.getImage());

        return product1;
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class,productId);
        ProductDto productDto1 = response.getBody();
        if(productDto1!=null){
            Product product1 = new Product();
            product1.setId(productDto.getId());
            product1.setTitle(productDto.getTitle());
            product1.setPrice(productDto.getPrice());
            product1.setDescription(productDto.getDescription());
            Category category = new Category();
            category.setName(productDto.getCategory());
            product1.setCategory(String.valueOf(category));
            product1.setImageUrl(productDto.getImage());
            return product1;
        }
        else
            return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> entity = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);
        ProductDto productDto = entity.getBody();
        Product product1 = new Product();
        if(productDto!=null){
            restTemplate.delete("https://fakestoreapi.com/products/{id}", productId);
            product1.setId(productDto.getId());
            product1.setTitle(productDto.getTitle());
            product1.setPrice(productDto.getPrice());
            product1.setDescription(productDto.getDescription());
            Category category = new Category();
            category.setName(productDto.getCategory());
            product1.setCategory(String.valueOf(category));
            product1.setImageUrl(productDto.getImage());
            return product1;
        }
        else
            return null;
    }
}
