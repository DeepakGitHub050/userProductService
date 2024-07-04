package com.userproductservice.User.Product.App.controllers;

import com.userproductservice.User.Product.App.dtos.ProductDto;
import com.userproductservice.User.Product.App.models.Product;
import com.userproductservice.User.Product.App.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{pId}")
    public ResponseEntity<Product> getSingleResponseDto(@PathVariable Long pId) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "dks/application/json");
        /*GetSingleResponseDto responseDto = new GetSingleResponseDto();
        responseDto.setProduct(productService.getSingleProduct(pId));
        return responseDto;*/
        //return productService.getSingleProduct(pId);
        ResponseEntity<Product> response = new ResponseEntity<>(productService.getSingleProduct(pId),headers, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        ResponseEntity<Product> response = new ResponseEntity<>(productService.addNewProduct(productDto),HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{pID}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long pID, @RequestBody ProductDto productDto) {
        Product product = productService.updateProduct(pID, productDto);
        if (product==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{pId}")
    public String deleteProduct(@PathVariable int pId) {
        return "Deleting product: " + pId;
    }
}
