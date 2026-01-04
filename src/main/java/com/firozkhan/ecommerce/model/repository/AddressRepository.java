package com.firozkhan.ecommerce.model.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.model.entity.Address;

public interface AddressRepository {

     /**
     * Get all addresses of a user
     */
    List<Address> findAllByUserId(UUID userId);

    /**
     * Get default address of a user
     */
    Optional<Address> findByUserIdAndIsDefaultTrue(UUID userId);

    /**
     * Check if user already has a default address
     */
    boolean existsByUserIdAndIsDefaultTrue(UUID userId);

    /**
     * Delete all addresses of a user (used on account removal)
     */
    void deleteAllByUserId(UUID userId);

    /**
     * Get address by user and id (security-safe)
     */
    Optional<Address> findByIdAndUserId(UUID id, UUID userId);
}