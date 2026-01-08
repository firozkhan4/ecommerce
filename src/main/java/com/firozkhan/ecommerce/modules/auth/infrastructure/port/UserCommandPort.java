package com.firozkhan.ecommerce.modules.auth.infrastructure.port;

import com.firozkhan.ecommerce.modules.user.domain.entity.User;

public interface UserCommandPort {

    User save(User user);
    
}
