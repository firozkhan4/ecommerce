package com.firozkhan.ecommerce.application.service.auth;

import com.firozkhan.ecommerce.web.dto.request.LoginRequest;
import com.firozkhan.ecommerce.web.dto.request.RegisterRequest;
import com.firozkhan.ecommerce.web.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
    
}