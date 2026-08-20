package com.shopesphere.shopsphere.Service;

import com.shopesphere.shopsphere.DTO.AuthResponse;
import com.shopesphere.shopsphere.DTO.RequestLogin;
import com.shopesphere.shopsphere.DTO.RequestRegister;

public interface AuthService {
    AuthResponse register(RequestRegister request);
    AuthResponse login(RequestLogin request);
}
