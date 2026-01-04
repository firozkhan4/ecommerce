package com.firozkhan.ecommerce.application.repository.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Seller;
import com.firozkhan.ecommerce.model.enums.SellerStatus;
import com.firozkhan.ecommerce.model.repository.SellerRepository;

@Repository
public class SellerRepositoryImp implements SellerRepository {

    @Override
    public Optional<Seller> findByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByUserId'");
    }

    @Override
    public List<Seller> findAllByStatus(SellerStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStatus'");
    }

    @Override
    public Optional<Seller> findByGst(String gst) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByGst'");
    }

    @Override
    public boolean existsByGst(String gst) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByGst'");
    }

    
}