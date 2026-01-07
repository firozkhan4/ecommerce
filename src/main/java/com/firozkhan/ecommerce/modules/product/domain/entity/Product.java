package com.firozkhan.ecommerce.modules.product.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.firozkhan.ecommerce.modules.product.domain.enums.ProductStatus;

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
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products", indexes = {
        @Index(name = "idx_product_seller", columnList = "seller_id"),
        @Index(name = "idx_product_category", columnList = "category_id"),
        @Index(name = "idx_product_status", columnList = "status"),
        @Index(name = "idx_product_sku", columnList = "sku")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uk_product_sku", columnNames = "sku")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 150)
    @Column(nullable = false, length = 150)
    private String name;

    @Size(max = 2000)
    @Column(length = 2000)
    private String description;

    @NotNull
    @PositiveOrZero(message = "MRP cannot be negative")
    @Column(nullable = false)
    private double price;

    @NotNull(message = "Seller is required")
    @Column(name = "seller_id", nullable = false)
    private UUID sellerId;

    @NotNull(message = "Category is required")
    @Column(name = "category_id", nullable = false)
    private UUID categoryId;

    @NotNull
    @PositiveOrZero(message = "Stock quantity cannot be negative")
    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @NotBlank(message = "SKU is required")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String sku;

    @Size(max = 500)
    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @NotNull(message = "Product status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProductStatus status = ProductStatus.DRAFT;

    @NotNull
    @PositiveOrZero(message = "Selling price cannot be negative")
    @Column(name = "selling_price", nullable = false)
    private double sellingPrice;

    @Column(name = "available_from")
    private LocalDateTime availableFrom;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "is_adult_product", nullable = false)
    private Boolean adultProduct = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ---- Constructors ----

    protected Product() {
        // JPA only
    }

    public Product(
            String name,
            String description,
            double price,
            double sellingPrice,
            UUID sellerId,
            UUID categoryId,
            int stockQuantity,
            String sku) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.sellingPrice = sellingPrice;
        this.sellerId = sellerId;
        this.categoryId = categoryId;
        this.stockQuantity = stockQuantity;
        this.sku = sku;
        this.status = ProductStatus.DRAFT;
    }

    // ---- Getters ----

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getSku() {
        return sku;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public Boolean isAdultProduct() {
        return adultProduct;
    }

    public LocalDateTime getAvailableFrom() {
        return availableFrom;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ---- Business Logic ----

    public Boolean isInStock() {
        return stockQuantity > 0;
    }

    public void publish() {
        if (sellingPrice > price) {
            throw new IllegalStateException("Selling price cannot exceed MRP");
        }
        this.status = ProductStatus.AVAILABLE;
    }

    public void discontinue() {
        this.status = ProductStatus.DISCONTINUED;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0 || quantity > stockQuantity) {
            throw new IllegalArgumentException("Invalid stock reduction");
        }
        this.stockQuantity -= quantity;
    }
}
