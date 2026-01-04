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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "cart_items", indexes = {
        @Index(name = "idx_cart_item_cart", columnList = "cart_id"),
        @Index(name = "idx_cart_item_product", columnList = "product_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uk_cart_product", columnNames = { "cart_id", "product_id" })
})
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "Cart ID is required")
    @Column(name = "cart_id", nullable = false)
    private UUID cartId;

    @NotNull(message = "Product ID is required")
    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Column(nullable = false)
    private int quantity;

    @PositiveOrZero(message = "Unit price cannot be negative")
    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @PositiveOrZero(message = "Total price cannot be negative")
    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ---- Constructors ----

    protected CartItem() {
        // JPA only
    }

    public CartItem(
            UUID cartId,
            UUID productId,
            int quantity,
            double unitPrice) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    // ---- Getters ----

    public UUID getId() {
        return id;
    }

    public UUID getCartId() {
        return cartId;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ---- Business Logic ----

    public void updateQuantity(int newQuantity) {
        if (newQuantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }
        this.quantity = newQuantity;
        recalculateTotal();
    }

    private void recalculateTotal() {
        this.totalPrice = this.quantity * this.unitPrice;
    }
}
