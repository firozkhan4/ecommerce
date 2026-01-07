package com.firozkhan.ecommerce.modules.order.domain.repository;

import java.util.List;
import java.util.UUID;

import com.firozkhan.ecommerce.modules.order.domain.entity.OrderItem;

public interface OrderItemRepository {

      /**
     * Get all items of an order
     */
    List<OrderItem> findAllByOrderId(UUID orderId);

    /**
     * Get all items of a product (analytics / seller reporting)
     */
    List<OrderItem> findAllByProductId(UUID productId);
    
}