package com.firozkhan.ecommerce.application.service.auth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.firozkhan.ecommerce.application.exception.BadCredentialsException;
import com.firozkhan.ecommerce.application.service.auth.implement.AuthServiceImp;
import com.firozkhan.ecommerce.model.entity.User;
import com.firozkhan.ecommerce.model.repository.UserRepository;
import com.firozkhan.ecommerce.web.dto.request.LoginRequest;
import com.firozkhan.ecommerce.web.dto.request.RegisterRequest;
import com.firozkhan.ecommerce.web.dto.response.AuthResponse;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImp authService;

    private User mockUser;

    @BeforeEach
    void setUp() {
        mockUser = new User(
                "firoz@gmail.com",
                "9097976187",
                "hashed_password",
                null);
    }

    // =========================
    // REGISTER TEST CASES
    // =========================

    @Test
    @DisplayName("Register - Success")
    void register_success() {
        RegisterRequest request = new RegisterRequest("firoz@gmail.com", "9097976187", "password");

        when(passwordEncoder.encode("password")).thenReturn("hashed_password");
        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        AuthResponse response = authService.register(request);

        assertThat(response).isNotNull();
        verify(passwordEncoder).encode("password");
        verify(userRepository).save(any(User.class));
    }

    @Test
    @DisplayName("Register - User already exists")
    void register_userAlreadyExists() {
        RegisterRequest request = new RegisterRequest("firoz@gmail.com", "9097976187", "password");

        when(userRepository.existsByEmailIgnoreCase("firoz@gmail.com")).thenReturn(true);

        assertThatThrownBy(() -> authService.register(request))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("User already exists");

        verify(userRepository).existsByEmailIgnoreCase("firoz@gmail.com");
        verify(userRepository, never()).save(any());
        verify(passwordEncoder, never()).encode(any());
    }

    @Test
    @DisplayName("Register - Null request")
    void register_nullRequest() {
        assertThatThrownBy(() -> authService.register(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Register - Empty email")
    void register_emptyEmail() {
        RegisterRequest request = new RegisterRequest("", "9097976187", "password");

        assertThatThrownBy(() -> authService.register(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Register - Empty password")
    void register_emptyPassword() {
        RegisterRequest request = new RegisterRequest("firoz@gmail.com", "9097976187", "");

        assertThatThrownBy(() -> authService.register(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Register - Password encoder failure")
    void register_passwordEncoderFailure() {
        RegisterRequest request = new RegisterRequest("firoz@gmail.com", "9097976187", "password");

        when(passwordEncoder.encode("password"))
                .thenThrow(new RuntimeException("Encoder failure"));

        assertThatThrownBy(() -> authService.register(request))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Encoder failure");
    }

    @Test
    @DisplayName("Register - Repository save failure")
    void register_repositoryFailure() {
        RegisterRequest request = new RegisterRequest("firoz@gmail.com", "9097976187", "password");

        when(passwordEncoder.encode("password")).thenReturn("hashed_password");
        when(userRepository.save(any(User.class)))
                .thenThrow(new RuntimeException("DB failure"));

        assertThatThrownBy(() -> authService.register(request))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("DB failure");
    }

    // =========================
    // LOGIN TEST CASES
    // =========================

    @Test
    @DisplayName("Login - Success")
    void login_success() {
        LoginRequest request = new LoginRequest("firoz@gmail.com", "password");

        when(userRepository.findByIdentifier("firoz@gmail.com"))
                .thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches("password", "hashed_password"))
                .thenReturn(true);

        AuthResponse response = authService.login(request);

        assertThat(response).isNotNull();
        verify(userRepository).findByIdentifier("firoz@gmail.com");
        verify(passwordEncoder).matches("password", "hashed_password");
    }

    @Test
    @DisplayName("Login - User not found")
    void login_userNotFound() {
        LoginRequest request = new LoginRequest("unknown@gmail.com", "password");

        when(userRepository.findByIdentifier("unknown@gmail.com"))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> authService.login(request))
                .isInstanceOf(BadCredentialsException.class)
                .hasMessageContaining("Invalid Credentials");
    }

    @Test
    @DisplayName("Login - Wrong password")
    void login_wrongPassword() {
        LoginRequest request = new LoginRequest("firoz@gmail.com", "wrong_password");

        when(userRepository.findByIdentifier("firoz@gmail.com"))
                .thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches("wrong_password", "hashed_password"))
                .thenReturn(false);

        assertThatThrownBy(() -> authService.login(request))
                .isInstanceOf(BadCredentialsException.class)
                .hasMessageContaining("Invalid Credentials");

        verify(passwordEncoder).matches("wrong_password", "hashed_password");
    }

    @Test
    @DisplayName("Login - Null request")
    void login_nullRequest() {
        assertThatThrownBy(() -> authService.login(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Login - Empty identifier")
    void login_emptyIdentifier() {
        LoginRequest request = new LoginRequest("", "password");

        assertThatThrownBy(() -> authService.login(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Login - Empty password")
    void login_emptyPassword() {
        LoginRequest request = new LoginRequest("firoz@gmail.com", "");

        assertThatThrownBy(() -> authService.login(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Login - Password encoder failure")
    void login_passwordEncoderFailure() {
        LoginRequest request = new LoginRequest("firoz@gmail.com", "password");

        when(userRepository.findByIdentifier("firoz@gmail.com"))
                .thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches(any(), any()))
                .thenThrow(new RuntimeException("Encoder crash"));

        assertThatThrownBy(() -> authService.login(request))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Encoder crash");
    }
}
