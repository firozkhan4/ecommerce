package com.firozkhan.ecommerce.modules.user.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firozkhan.ecommerce.modules.user.application.service.UserService;
import com.firozkhan.ecommerce.modules.user.infrastructure.dto.request.UpdateUserRequest;
import com.firozkhan.ecommerce.modules.user.infrastructure.dto.response.UserResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get logged-in user profile
     */
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getMyProfile() {
        UserResponse response = userService.getCurrentUser(null);
        return ResponseEntity.ok(response);
    }

    /**
     * Update logged-in user profile
     */
    @PutMapping("/me")
    public ResponseEntity<UserResponse> updateMyProfile(
            @Valid @RequestBody UpdateUserRequest request) {
        UserResponse response = userService.updateCurrentUser(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Get user by ID (Admin)
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID userId) {
        UserResponse response = userService.getUserById(userId);
        return ResponseEntity.ok(response);
    }

    /**
     * List all users (Admin)
     */
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        List<UserResponse> users = userService.getAllUsers(page, size);
        return ResponseEntity.ok(users);
    }

    /**
     * Deactivate user account (Admin or self)
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deactivateUser(@PathVariable UUID userId) {
        userService.deactivateUser(userId);
        return ResponseEntity.noContent().build();
    }
}
