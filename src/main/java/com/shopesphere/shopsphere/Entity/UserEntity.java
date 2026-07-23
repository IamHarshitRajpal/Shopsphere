package com.shopesphere.shopsphere.Entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shopesphere.shopsphere.Model.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    // Constructors
    public UserEntity() {
    }

    public UserEntity(Long userId, String name, String email, String password, UserRole role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role.name())); // Prefixing with "ROLE_" as per Spring Security convention
    }

    @Override
    public String getUsername() {
        return this.email; // Assuming email is used as the username for authentication
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming accounts never expire. Adjust as necessary.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming accounts are never locked. Adjust as necessary.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming credentials never expire. Adjust as necessary.
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming all users are enabled by default. Adjust as necessary.
    }

}
