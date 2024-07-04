package com.userproductservice.User.Product.App.dtos;

import com.userproductservice.User.Product.App.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleResponseDto {
    private Product product;
}
