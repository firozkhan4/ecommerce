package com.firozkhan.ecommerce.application.repository.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.application.repository.jpa.JpaSellerRepository;
import com.firozkhan.ecommerce.modules.seller.domain.entity.Seller;
import com.firozkhan.ecommerce.modules.seller.domain.enums.SellerStatus;
import com.firozkhan.ecommerce.modules.seller.domain.repository.SellerRepository;

@Repository
public class SellerRepositoryImp implements SellerRepository {

    private final JpaSellerRepository jpaSellerRepository;

    public SellerRepositoryImp(JpaSellerRepository jpaSellerRepository) {
        this.jpaSellerRepository = jpaSellerRepository;
    }

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

    @Override
    public Seller save(Seller seller) {
        return jpaSellerRepository.save(seller);
    }

}