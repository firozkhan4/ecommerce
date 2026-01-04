package com.firozkhan.ecommerce.application.repository.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.OrderItem;
import com.firozkhan.ecommerce.model.repository.OrderItemRepository;

@Repository
public class OrderItemRepositoryImp implements OrderItemRepository {

    @Override
    public List<OrderItem> findAllByOrderId(UUID orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByOrderId'");
    }

    @Override
    public List<OrderItem> findAllByProductId(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByProductId'");
    }

    
}