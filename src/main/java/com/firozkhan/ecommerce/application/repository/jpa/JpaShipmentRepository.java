package com.firozkhan.ecommerce.application.repository.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Shipment;
import com.firozkhan.ecommerce.model.enums.ShipmentStatus;

@Repository
public interface JpaShipmentRepository extends JpaRepository<Shipment, UUID> {

    /**
     * Get shipment by order
     */
    Optional<Shipment> findByOrderId(UUID orderId);

    /**
     * Get shipment by tracking number
     */
    Optional<Shipment> findByTrackingNumber(String trackingNumber);

    /**
     * Get shipments by status (logistics dashboard)
     */
    List<Shipment> findAllByStatus(ShipmentStatus status);

    /**
     * Get all shipments of a carrier
     */
    List<Shipment> findAllByCarrier(String carrier);

    /**
     * Check if shipment already exists for order
     */
    boolean existsByOrderId(UUID orderId);
}
