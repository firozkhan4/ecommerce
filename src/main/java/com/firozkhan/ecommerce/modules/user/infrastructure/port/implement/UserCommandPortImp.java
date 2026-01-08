package com.firozkhan.ecommerce.modules.user.infrastructure.port.implement;

import org.springframework.stereotype.Component;

import com.firozkhan.ecommerce.modules.auth.infrastructure.port.UserCommandPort;
import com.firozkhan.ecommerce.modules.user.domain.entity.User;
import com.firozkhan.ecommerce.modules.user.domain.repository.UserRepository;

@Component
public class UserCommandPortImp implements UserCommandPort {

    private final UserRepository userRepository;

    public UserCommandPortImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
