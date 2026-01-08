package com.firozkhan.ecommerce.modules.auth.application.service.implement;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.comman.StringUtils;
import com.firozkhan.ecommerce.application.exception.BadCredentialsException;
import com.firozkhan.ecommerce.modules.auth.application.service.AuthService;
import com.firozkhan.ecommerce.modules.auth.application.service.JwtService;
import com.firozkhan.ecommerce.modules.auth.infrastructure.port.UserCommandPort;
import com.firozkhan.ecommerce.modules.auth.infrastructure.port.UserQueryPort;
import com.firozkhan.ecommerce.modules.user.domain.entity.User;
import com.firozkhan.ecommerce.web.dto.request.LoginRequest;
import com.firozkhan.ecommerce.web.dto.request.RegisterRequest;
import com.firozkhan.ecommerce.web.dto.response.AuthResponse;

@Service
public class AuthServiceImp implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserQueryPort userQueryPort;
    private final UserCommandPort userCommandPort;
    private final JwtService jwtService;

    public AuthServiceImp(PasswordEncoder passwordEncoder, UserQueryPort userQueryPort, UserCommandPort userCommandPort,
            JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.userQueryPort = userQueryPort;
        this.userCommandPort = userCommandPort;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        if (request == null || StringUtils.isNullOrBlank(request.getIdentifier())
                || StringUtils.isNullOrBlank(request.getPassword())) {
            throw new IllegalArgumentException();
        }

        var user = userQueryPort.findByIdentifier(request.getIdentifier());

        var match = passwordEncoder.matches(request.getPassword(), user.getPasswordHash());

        if (!match) {
            throw new BadCredentialsException("Invalid Credentials");
        }

        return new AuthResponse(user.getId(), jwtService.generateAccessToken(user.getEmail()));
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (request == null || StringUtils.isNullOrBlank(request.getEmail())
                || StringUtils.isNullOrBlank(request.getPassword())
                || StringUtils.isNullOrBlank(request.getPhone())) {
            throw new IllegalArgumentException();
        }

        if (userQueryPort.existsByEmailIgnoreCase(request.getEmail())
                || userQueryPort.existsByPhone(request.getPhone())) {
            throw new IllegalStateException("User already exists");
        }

        var hashedPassword = passwordEncoder.encode(request.getPassword());
        var user = new User(request.getEmail(), request.getPhone(), hashedPassword, null);
        var newUser = userCommandPort.save(user);

        return new AuthResponse(newUser.getId(), user.getEmail());
    }

}
