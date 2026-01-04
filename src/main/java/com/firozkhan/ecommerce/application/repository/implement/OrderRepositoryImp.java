package com.firozkhan.ecommerce.application.repository.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Order;
import com.firozkhan.ecommerce.model.repository.OrderRepository;

@Repository
public class OrderRepositoryImp implements OrderRepository {

    @Override
    public List<Order> findAllByUserIdOrderByCreatedAtDesc(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByUserIdOrderByCreatedAtDesc'");
    }

    @Override
    public Optional<Order> findByIdAndUserId(UUID id, UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdAndUserId'");
    }

    @Override
    public List<Order> findAllByStatus(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStatus'");
    }

    @Override
    public List<Order> findAllByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByCreatedAtBetween'");
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByUserId'");
    }

    
}