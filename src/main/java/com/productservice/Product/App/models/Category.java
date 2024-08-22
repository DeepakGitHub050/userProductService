package com.productservice.Product.App.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Product> products;
}
