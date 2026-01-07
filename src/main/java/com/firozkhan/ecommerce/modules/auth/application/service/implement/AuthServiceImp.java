package com.firozkhan.ecommerce.modules.auth.application.service.implement;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.comman.StringUtils;
import com.firozkhan.ecommerce.application.exception.BadCredentialsException;
import com.firozkhan.ecommerce.modules.auth.application.service.AuthService;
import com.firozkhan.ecommerce.modules.user.domain.entity.User;
import com.firozkhan.ecommerce.modules.user.domain.repository.UserRepository;
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

        if (request == null || StringUtils.isNullOrBlank(request.getIdentifier())
                || StringUtils.isNullOrBlank(request.getPassword())) {
            throw new IllegalArgumentException();
        }

        var user = userRepository.findByIdentifier(request.getIdentifier())
                .orElseThrow(() -> new BadCredentialsException("Invalid Credentials"));

        var match = passwordEncoder.matches(request.getPassword(), user.getPasswordHash());

        if (!match) {
            throw new BadCredentialsException("Invalid Credentials");
        }

        return new AuthResponse(user.getId(), "");
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (request == null || StringUtils.isNullOrBlank(request.getEmail())
                || StringUtils.isNullOrBlank(request.getPassword())
                || StringUtils.isNullOrBlank(request.getPhone())) {
            throw new IllegalArgumentException();
        }

        if (userRepository.existsByEmailIgnoreCase(request.getEmail())
                || userRepository.existsByPhone(request.getPhone())) {
            throw new IllegalStateException("User already exists");
        }

        var hashedPassword = passwordEncoder.encode(request.getPassword());
        var user = new User(request.getEmail(), request.getPhone(), hashedPassword, null);
        var newUser = userRepository.save(user);

        return new AuthResponse(newUser.getId(), "");
    }

}
