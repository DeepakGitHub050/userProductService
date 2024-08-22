package com.userproductservice.User.Product.App.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*private Date createdAt;
    private Date updatedAat;
    private boolean isDeleted = false;*/
}
