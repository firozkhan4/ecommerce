package com.firozkhan.ecommerce.application.repository.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.modules.seller.domain.entity.Seller;


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

    /**
     * Find seller by GST number
     */
    Optional<Seller> findByGst(String gst);

    /**
     * Check GST uniqueness
     */
    boolean existsByGst(String gst);

}
