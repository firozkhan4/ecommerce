package com.firozkhan.ecommerce.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "addresses", indexes = {
        @Index(name = "idx_address_user", columnList = "user_id"),
        @Index(name = "idx_address_default", columnList = "is_default")
})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "User ID is required")
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @NotBlank(message = "Street address is required")
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String street;

    @NotBlank(message = "City is required")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String state;

    @NotBlank(message = "ZIP / Postal code is required")
    @Pattern(regexp = "^[0-9]{5,10}$", message = "Invalid ZIP / Postal code")
    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @NotBlank(message = "Country is required")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String country;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault = false;

    @NotBlank(message = "Address type is required")
    @Size(max = 20)
    @Column(name = "address_type", nullable = false, length = 20)
    private String addressType; // HOME, WORK, OTHER

    @Size(max = 50)
    @Column(length = 50)
    private String label; // e.g. "Mom's House", "Office"

    @Size(max = 500)
    @Column(length = 500)
    private String instructions; // Delivery instructions

    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "Invalid latitude format")
    @Column(length = 20)
    private String latitude;

    @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "Invalid longitude format")
    @Column(length = 20)
    private String longitude;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ---- Constructors ----

    protected Address() {
        // JPA only
    }

    public Address(
            UUID userId,
            String street,
            String city,
            String state,
            String zipCode,
            String country,
            String addressType) {
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.addressType = addressType;
    }

    // ---- Getters ----

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public String getAddressType() {
        return addressType;
    }

    public String getLabel() {
        return label;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ---- Business Logic ----

    public void markAsDefault() {
        this.isDefault = true;
    }

    public void unmarkDefault() {
        this.isDefault = false;
    }
}
