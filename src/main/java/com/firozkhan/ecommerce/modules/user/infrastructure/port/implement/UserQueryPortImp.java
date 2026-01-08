package com.firozkhan.ecommerce.modules.user.infrastructure.port.implement;

import org.springframework.stereotype.Component;

import com.firozkhan.ecommerce.modules.auth.infrastructure.port.UserQueryPort;
import com.firozkhan.ecommerce.modules.user.application.exception.UserNotFoundException;
import com.firozkhan.ecommerce.modules.user.domain.entity.User;
import com.firozkhan.ecommerce.modules.user.domain.repository.UserRepository;

@Component
public class UserQueryPortImp implements UserQueryPort {

    private UserRepository userRepository;

    public UserQueryPortImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public User findByIdentifier(String identifier) {
        return userRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public boolean existsByEmailIgnoreCase(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }

}
