package com.firozkhan.ecommerce.application.service.user.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.service.user.UserService;
import com.firozkhan.ecommerce.web.dto.request.UpdateUserRequest;
import com.firozkhan.ecommerce.web.dto.response.UserResponse;

@Service
public class UserServiceImp implements UserService {

    @Override
    public UserResponse getCurrentUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentUser'");
    }

    @Override
    public UserResponse updateCurrentUser(UpdateUserRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCurrentUser'");
    }

    @Override
    public UserResponse getUserById(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public List<UserResponse> getAllUsers(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public void deactivateUser(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deactivateUser'");
    }

}
