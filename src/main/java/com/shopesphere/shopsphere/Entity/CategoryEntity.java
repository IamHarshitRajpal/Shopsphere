package com.shopesphere.shopsphere.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<ProductEntity> products;

    // Constructors
    public CategoryEntity() {
    }
    
    public CategoryEntity(Long categoryId, String name, List<ProductEntity> products) {
        this.categoryId = categoryId;
        this.name = name;
        this.products = products;
    }

    // Getters and Setters
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
