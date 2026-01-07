package com.firozkhan.ecommerce.modules.auth.infrastructure.port;

import java.util.Optional;

import com.firozkhan.ecommerce.modules.user.domain.entity.User;

public interface UserQueryPort {

    Optional<User> findByUsername(String username);
}
