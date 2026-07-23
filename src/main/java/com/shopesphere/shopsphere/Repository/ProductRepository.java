package com.shopesphere.shopsphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopesphere.shopsphere.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
