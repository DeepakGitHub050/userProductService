package com.productservice.Product.App.dtos;

import com.productservice.Product.App.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleResponseDto {
    private Product product;
}
