package com.firozkhan.ecommerce.application.repository.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Seller;
import com.firozkhan.ecommerce.model.enums.SellerStatus;

@Repository
public interface JpaSellerRepository extends JpaRepository<Seller, UUID> {

    /**
     * Get seller by user (1–1 mapping)
     */
    Optional<Seller> findByUserId(UUID userId);

    /**
     * Check if user is already registered as seller
     */
    boolean existsByUserId(UUID userId);

    /**
     * Get sellers by status (admin moderation)
     */
    List<Seller> findAllByStatus(SellerStatus status);

    /**
     * Find seller by GST number
     */
    Optional<Seller> findByGst(String gst);

    /**
     * Check GST uniqueness
     */
    boolean existsByGst(String gst);
}
