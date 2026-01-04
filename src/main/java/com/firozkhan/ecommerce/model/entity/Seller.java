package com.firozkhan.ecommerce.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.firozkhan.ecommerce.model.enums.SellerStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(
    name = "sellers",
    indexes = {
        @Index(name = "idx_seller_user_id", columnList = "user_id"),
        @Index(name = "idx_seller_status", columnList = "status")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_seller_gst", columnNames = "gst")
    }
)
public class Seller {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "User ID is required")
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @NotBlank(message = "Shop name cannot be blank")
    @Size(min = 3, max = 100, message = "Shop name must be between 3 and 100 characters")
    @Column(name = "shop_name", nullable = false, length = 100)
    private String shopName;

    @NotNull(message = "Seller status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SellerStatus status;

    @NotBlank(message = "GST number is required")
    @Pattern(
        regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$",
        message = "Invalid GST number format"
    )
    @Column(nullable = false, length = 15)
    private String gst;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ---- Constructors ----

    protected Seller() {
        // JPA only
    }

    public Seller(UUID userId, String shopName, SellerStatus status, String gst) {
        this.userId = userId;
        this.shopName = shopName;
        this.status = status;
        this.gst = gst;
    }

    // ---- Getters ----

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getShopName() {
        return shopName;
    }

    public SellerStatus getStatus() {
        return status;
    }

    public String getGst() {
        return gst;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ---- Business Methods ----

    public void activate() {
        this.status = SellerStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = SellerStatus.INACTIVE;
    }
}
