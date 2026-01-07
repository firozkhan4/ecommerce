package com.firozkhan.ecommerce.application.repository.implement;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.modules.cart.domain.entity.Cart;
import com.firozkhan.ecommerce.modules.cart.domain.repository.CartRepository;

@Repository
public class CartRepositoryImp implements CartRepository {

    @Override
    public Optional<Cart> findByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByUserId'");
    }

    @Override
    public void deleteByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByUserId'");
    }

    
}