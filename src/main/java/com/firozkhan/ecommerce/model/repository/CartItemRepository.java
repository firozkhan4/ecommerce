package com.firozkhan.ecommerce.model.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.model.entity.CartItem;

public interface CartItemRepository {

    /**
     * Get all items of a cart
     */
    List<CartItem> findAllByCartId(UUID cartId);

    /**
     * Get cart item by cart and product (to avoid duplicates)
     */
    Optional<CartItem> findByCartIdAndProductId(UUID cartId, UUID productId);

    /**
     * Check if product already exists in cart
     */
    boolean existsByCartIdAndProductId(UUID cartId, UUID productId);

    /**
     * Delete a specific product from cart
     */
    void deleteByCartIdAndProductId(UUID cartId, UUID productId);

    /**
     * Clear entire cart
     */
    void deleteAllByCartId(UUID cartId);
}