package com.firozkhan.ecommerce.model.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.model.entity.Order;

public interface OrderRepository {

     /**
     * Get all orders of a user (order history)
     */
    List<Order> findAllByUserIdOrderByCreatedAtDesc(UUID userId);

    /**
     * Get order by id and user (security-safe)
     */
    Optional<Order> findByIdAndUserId(UUID id, UUID userId);

    /**
     * Get all orders by status (admin / operations)
     */
    List<Order> findAllByStatus(String status);

    /**
     * Get orders within date range (analytics)
     */
    List<Order> findAllByCreatedAtBetween(
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    /**
     * Check if user has placed any order
     */
    boolean existsByUserId(UUID userId);
    
}