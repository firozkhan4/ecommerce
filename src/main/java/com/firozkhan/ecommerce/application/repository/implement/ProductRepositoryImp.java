package com.firozkhan.ecommerce.application.repository.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Product;
import com.firozkhan.ecommerce.model.enums.ProductStatus;
import com.firozkhan.ecommerce.model.repository.ProductRepository;

@Repository
public class ProductRepositoryImp implements ProductRepository {

    @Override
    public List<Product> findAllByStatus(ProductStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStatus'");
    }

    @Override
    public List<Product> findAllBySellerId(UUID sellerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllBySellerId'");
    }

    @Override
    public List<Product> findAllBySellerIdAndStatus(UUID sellerId, ProductStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllBySellerIdAndStatus'");
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBySku'");
    }

    @Override
    public boolean existsBySku(String sku) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsBySku'");
    }

    @Override
    public List<Product> findAllByAvailableFromBeforeAndExpiresAtAfter(LocalDateTime now1, LocalDateTime now2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByAvailableFromBeforeAndExpiresAtAfter'");
    }

    @Override
    public List<Product> findAllByStockQuantityLessThan(int threshold) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStockQuantityLessThan'");
    }

    @Override
    public List<Product> findAllByNameContainingIgnoreCase(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByNameContainingIgnoreCase'");
    }

    @Override
    public List<Product> findAllByCategoryId(UUID categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByCategoryId'");
    }

    
}