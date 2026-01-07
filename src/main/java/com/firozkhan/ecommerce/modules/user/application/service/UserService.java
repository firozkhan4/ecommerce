package com.firozkhan.ecommerce.modules.user.application.service;

import java.util.List;
import java.util.UUID;

import com.firozkhan.ecommerce.modules.user.infrastructure.dto.request.UpdateUserRequest;
import com.firozkhan.ecommerce.modules.user.infrastructure.dto.response.UserResponse;

public interface UserService {

    UserResponse getCurrentUser(String identifier);

    UserResponse updateCurrentUser(UpdateUserRequest request);

    UserResponse getUserById(UUID userId);

    List<UserResponse> getAllUsers(int page, int size);

    void deactivateUser(UUID userId);
}
