package com.firozkhan.ecommerce.application.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Order;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, UUID> {

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
