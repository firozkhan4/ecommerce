package com.firozkhan.ecommerce.application.service.auth.implement;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.exception.NotFoundException;
import com.firozkhan.ecommerce.application.service.auth.AuthService;
import com.firozkhan.ecommerce.model.entity.User;
import com.firozkhan.ecommerce.model.repository.UserRepository;
import com.firozkhan.ecommerce.web.dto.request.LoginRequest;
import com.firozkhan.ecommerce.web.dto.request.RegisterRequest;
import com.firozkhan.ecommerce.web.dto.response.AuthResponse;

@Service
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        var user = userRepository.findByEmailIgnoreCase(request.getEmail())
                .orElseThrow(() -> new NotFoundException("User not found"));

        var match = passwordEncoder.matches(request.getPassword(), user.getPasswordHash());

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }

        return new AuthResponse(user.getId().toString(), "");
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        boolean exists;

        if (request.getEmail() == null || request.getEmail().isBlank()) {
            exists = userRepository.existsByPhone(request.getPhone());
        } else {
            exists = userRepository.existsByEmailIgnoreCase(request.getEmail());
        }

        if (exists) {
            throw new RuntimeException("User already exists");
        }

        var hashedPassword = passwordEncoder.encode(request.getPassword());
        var user = new User(request.getEmail(), request.getPhone(), hashedPassword, null);
        userRepository.save(user);

        return new AuthResponse(user.getId().toString(),"");
    }

}
