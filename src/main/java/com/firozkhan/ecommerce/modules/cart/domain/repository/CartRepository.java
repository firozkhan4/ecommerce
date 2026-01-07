package com.firozkhan.ecommerce.modules.cart.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.modules.cart.domain.entity.Cart;

public interface CartRepository {

      /**
     * Get cart by user
     * (Each user should have at most one active cart)
     */
    Optional<Cart> findByUserId(UUID userId);

    /**
     * Check if cart already exists for user
     */
    boolean existsByUserId(UUID userId);

    /**
     * Delete cart by user (used on account deletion)
     */
    void deleteByUserId(UUID userId);
    
}