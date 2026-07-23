package com.shopesphere.shopsphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopesphere.shopsphere.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
