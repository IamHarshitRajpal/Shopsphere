package com.shopesphere.shopsphere.Service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopesphere.shopsphere.DTO.AuthResponse;
import com.shopesphere.shopsphere.DTO.RequestLogin;
import com.shopesphere.shopsphere.DTO.RequestRegister;
import com.shopesphere.shopsphere.Exception.DuplicateResourceException;
import com.shopesphere.shopsphere.Exception.ResourceNotFoundException;
import com.shopesphere.shopsphere.Model.UserRole;
import com.shopesphere.shopsphere.Repository.UserRepository;
import com.shopesphere.shopsphere.Entity.UserEntity;

@Service
public class AuthImpleService implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthImpleService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthResponse register(RequestRegister request){
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("User already exists with email: " + request.getEmail());
        }

        UserEntity newUser = new UserEntity();

        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(UserRole.USER);
        userRepository.save(newUser);

        return new AuthResponse("not-implemented", newUser.getEmail(), newUser.getRole().toString());
    }    

    @Override
    public AuthResponse login(RequestLogin request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, user.getEmail(), user.getRole().toString());
    }

}
