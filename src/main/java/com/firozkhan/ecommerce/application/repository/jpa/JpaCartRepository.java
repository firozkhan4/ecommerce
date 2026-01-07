package com.firozkhan.ecommerce.application.repository.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.modules.cart.domain.entity.Cart;

@Repository
public interface JpaCartRepository extends JpaRepository<Cart, UUID> {

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
