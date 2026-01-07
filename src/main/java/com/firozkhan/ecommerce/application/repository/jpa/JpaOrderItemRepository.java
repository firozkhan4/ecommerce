package com.firozkhan.ecommerce.application.repository.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.modules.order.domain.entity.OrderItem;

@Repository
public interface JpaOrderItemRepository extends JpaRepository<OrderItem, UUID> {

    /**
     * Get all items of an order
     */
    List<OrderItem> findAllByOrderId(UUID orderId);

    /**
     * Get all items of a product (analytics / seller reporting)
     */
    List<OrderItem> findAllByProductId(UUID productId);

}
