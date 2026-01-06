package com.firozkhan.ecommerce.application.repository.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.User;

@Repository
public interface JpaUserRepository extends JpaRepository<User, UUID> {

    /**
     * Find user by email
     */
    Optional<User> findByEmailIgnoreCase(String email);

    /**
     * Find user by phone
     */
    Optional<User> findByPhone(String phone);

    /**
     * Check if email already exists
     */
    boolean existsByEmailIgnoreCase(String email);

    /**
     * Check if phone already exists
     */
    boolean existsByPhone(String phone);
    
    boolean existsById(UUID id);

    Optional<User> findById(UUID id);

    @Query("SELECT u from User u WHERE u.email = :identifier OR u.phone = :identifier")
    Optional<User> findByIdentifier(@Param("identifier") String identifier);
}
