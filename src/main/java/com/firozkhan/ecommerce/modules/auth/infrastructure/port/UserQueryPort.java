package com.firozkhan.ecommerce.modules.auth.infrastructure.port;

import com.firozkhan.ecommerce.modules.user.domain.entity.User;

public interface UserQueryPort {

    User findByUsername(String username);

    User findByIdentifier(String identifier);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByPhone(String phone);
}
