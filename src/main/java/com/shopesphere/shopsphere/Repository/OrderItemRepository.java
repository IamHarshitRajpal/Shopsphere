package com.shopesphere.shopsphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopesphere.shopsphere.Entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

}
