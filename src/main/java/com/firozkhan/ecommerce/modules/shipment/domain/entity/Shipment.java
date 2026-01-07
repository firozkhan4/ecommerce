package com.firozkhan.ecommerce.modules.shipment.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.firozkhan.ecommerce.modules.shipment.domain.enums.ShipmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(
    name = "shipments",
    indexes = {
        @Index(name = "idx_shipment_order", columnList = "order_id"),
        @Index(name = "idx_shipment_tracking", columnList = "tracking_number"),
        @Index(name = "idx_shipment_status", columnList = "status")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_shipment_tracking", columnNames = "tracking_number")
    }
)
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "Order ID is required")
    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @NotBlank(message = "Tracking number is required")
    @Size(max = 100)
    @Column(name = "tracking_number", nullable = false, length = 100)
    private String trackingNumber;

    @NotBlank(message = "Carrier name is required")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String carrier;

    @NotNull(message = "Shipment status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ShipmentStatus status = ShipmentStatus.PENDING;

    @Column(name = "estimated_delivery")
    private LocalDate estimatedDelivery;

    @NotNull(message = "Shipment address is required")
    @Column(name = "shipment_address_id", nullable = false)
    private UUID shipmentAddressId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ---- Constructors ----

    protected Shipment() {
        // JPA only
    }

    public Shipment(
            UUID orderId,
            String trackingNumber,
            String carrier,
            UUID shipmentAddressId
    ) {
        this.orderId = orderId;
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
        this.shipmentAddressId = shipmentAddressId;
        this.status = ShipmentStatus.PENDING;
    }

    // ---- Getters ----

    public UUID getId() { return id; }
    public UUID getOrderId() { return orderId; }
    public String getTrackingNumber() { return trackingNumber; }
    public String getCarrier() { return carrier; }
    public ShipmentStatus getStatus() { return status; }
    public LocalDate getEstimatedDelivery() { return estimatedDelivery; }
    public UUID getShipmentAddressId() { return shipmentAddressId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // ---- Business Methods ----

    public void markShipped(LocalDate estimatedDelivery) {
        this.status = ShipmentStatus.SHIPPED;
        this.estimatedDelivery = estimatedDelivery;
    }

    public void markDelivered() {
        this.status = ShipmentStatus.DELIVERED;
    }

    public void markFailed() {
        this.status = ShipmentStatus.FAILED;
    }
}
