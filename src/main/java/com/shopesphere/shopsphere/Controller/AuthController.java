package com.shopesphere.shopsphere.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopesphere.shopsphere.DTO.AuthResponse;
import com.shopesphere.shopsphere.DTO.RequestLogin;
import com.shopesphere.shopsphere.DTO.RequestRegister;
import com.shopesphere.shopsphere.Service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController{

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RequestRegister request) {
        System.out.println("Received registration request: " + request);
        AuthResponse response = authService.register(request);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody RequestLogin request) {
        return ResponseEntity.ok(authService.login(request));
    }
    
}
