package com.shopesphere.shopsphere.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopesphere.shopsphere.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    public List<OrderEntity> findByUserUserId(Long userId);
}
