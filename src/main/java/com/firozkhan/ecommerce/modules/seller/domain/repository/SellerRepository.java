package com.firozkhan.ecommerce.modules.seller.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.modules.seller.domain.entity.Seller;
import com.firozkhan.ecommerce.modules.seller.domain.enums.SellerStatus;


public interface SellerRepository {

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

    Seller save(Seller seller);

}