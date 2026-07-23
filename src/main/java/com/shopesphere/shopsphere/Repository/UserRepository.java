package com.shopesphere.shopsphere.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopesphere.shopsphere.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

     Optional<UserEntity> findByEmail(String email);
}
