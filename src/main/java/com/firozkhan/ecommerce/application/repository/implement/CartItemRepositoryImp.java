package com.firozkhan.ecommerce.application.repository.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.application.repository.jpa.JpaCartItemRepository;
import com.firozkhan.ecommerce.model.entity.CartItem;
import com.firozkhan.ecommerce.model.repository.CartItemRepository;

@Repository
public class CartItemRepositoryImp implements CartItemRepository {
    
    private final JpaCartItemRepository jpaCartItemRepository;

    public CartItemRepositoryImp(JpaCartItemRepository jpaCartItemRepository) {
        this.jpaCartItemRepository = jpaCartItemRepository;
    }

    @Override
    public List<CartItem> findAllByCartId(UUID cartId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByCartId'");
    }

    @Override
    public Optional<CartItem> findByCartIdAndProductId(UUID cartId, UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCartIdAndProductId'");
    }

    @Override
    public boolean existsByCartIdAndProductId(UUID cartId, UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByCartIdAndProductId'");
    }

    @Override
    public void deleteByCartIdAndProductId(UUID cartId, UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByCartIdAndProductId'");
    }

    @Override
    public void deleteAllByCartId(UUID cartId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByCartId'");
    }

    
}