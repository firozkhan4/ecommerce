package com.firozkhan.ecommerce.model.repository;

import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.model.entity.User;

public interface UserRepository {

    Optional<User> findByEmailIgnoreCase(String email);

    /**
     * Find user by phone
     */
    Optional<User> findByPhone(String phone);

    /**
     * Check if email already exists
     */
    boolean existsByEmailIgnoreCase(String email);

    /**
     * Check if phone already exists
     */
    boolean existsByPhone(String phone);

    boolean existsById(UUID id);

    Optional<User> findById(UUID id);

    User save(User user);

    Optional<User> findByIdentifier(String identifier);

}