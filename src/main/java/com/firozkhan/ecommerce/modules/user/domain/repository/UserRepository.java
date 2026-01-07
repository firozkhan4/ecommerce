package com.firozkhan.ecommerce.modules.user.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.modules.user.domain.entity.User;

public interface UserRepository {

    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByPhone(String phone);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByPhone(String phone);

    boolean existsById(UUID id);

    Optional<User> findById(UUID id);

    User save(User user);

    Optional<User> findByIdentifier(String identifier);

}