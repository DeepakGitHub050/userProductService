package com.userproductservice.User.Product.App.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> products;
}
