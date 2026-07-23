package com.shopesphere.shopsphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopesphere.shopsphere.Entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
