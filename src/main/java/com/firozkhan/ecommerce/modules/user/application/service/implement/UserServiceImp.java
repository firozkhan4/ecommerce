package com.firozkhan.ecommerce.modules.user.application.service.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.modules.user.application.exception.UserNotFoundException;
import com.firozkhan.ecommerce.modules.user.application.service.UserService;
import com.firozkhan.ecommerce.modules.user.domain.repository.UserRepository;
import com.firozkhan.ecommerce.modules.user.infrastructure.dto.request.UpdateUserRequest;
import com.firozkhan.ecommerce.modules.user.infrastructure.dto.response.UserResponse;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getCurrentUser(String email) {
        var user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UserNotFoundException());

        return new UserResponse();
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
