package com.firozkhan.ecommerce.application.service.user;

import java.util.List;
import java.util.UUID;

import com.firozkhan.ecommerce.web.dto.request.UpdateUserRequest;
import com.firozkhan.ecommerce.web.dto.response.UserResponse;

public interface UserService {

    UserResponse getCurrentUser();

    UserResponse updateCurrentUser(UpdateUserRequest request);

    UserResponse getUserById(UUID userId);

    List<UserResponse> getAllUsers(int page, int size);

    void deactivateUser(UUID userId);

}