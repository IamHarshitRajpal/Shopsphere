package com.shopesphere.shopsphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopesphere.shopsphere.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
