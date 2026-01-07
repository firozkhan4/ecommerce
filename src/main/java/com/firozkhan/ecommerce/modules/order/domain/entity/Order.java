package com.firozkhan.ecommerce.modules.order.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.firozkhan.ecommerce.modules.order.domain.enums.OrderStatus;
import com.firozkhan.ecommerce.modules.payment.domain.enums.PaymentMethod;
import com.firozkhan.ecommerce.modules.payment.domain.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "orders", indexes = {
        @Index(name = "idx_order_user", columnList = "user_id"),
        @Index(name = "idx_order_status", columnList = "status"),
        @Index(name = "idx_order_payment_status", columnList = "payment_status")
})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "User ID is required")
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @NotNull
    @PositiveOrZero(message = "Total amount cannot be negative")
    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @NotNull(message = "Shipping address is required")
    @Column(name = "shipping_address_id", nullable = false)
    private UUID shippingAddressId;

    @NotNull(message = "Billing address is required")
    @Column(name = "billing_address_id", nullable = false)
    private UUID billingAddressId;

    @NotNull(message = "Order status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private OrderStatus status = OrderStatus.PENDING;

    @NotNull(message = "Payment method is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, length = 30)
    private PaymentMethod paymentMethod;

    @NotNull(message = "Payment status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false, length = 30)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ---- Constructors ----

    protected Order() {
        // JPA only
    }

    public Order(
            UUID userId,
            UUID shippingAddressId,
            UUID billingAddressId,
            double totalAmount,
            PaymentMethod paymentMethod) {
        this.userId = userId;
        this.shippingAddressId = shippingAddressId;
        this.billingAddressId = billingAddressId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.status = OrderStatus.PENDING;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    // ---- Getters ----

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public UUID getShippingAddressId() {
        return shippingAddressId;
    }

    public UUID getBillingAddressId() {
        return billingAddressId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ---- Business Logic ----

    public void markPaid() {
        this.paymentStatus = PaymentStatus.SUCCESS;
        this.status = OrderStatus.CONFIRMED;
    }

    public void markShipped() {
        this.status = OrderStatus.SHIPPED;
    }

    public void markDelivered() {
        this.status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (this.status == OrderStatus.DELIVERED) {
            throw new IllegalStateException("Delivered orders cannot be cancelled");
        }
        this.status = OrderStatus.CANCELLED;
    }
}
