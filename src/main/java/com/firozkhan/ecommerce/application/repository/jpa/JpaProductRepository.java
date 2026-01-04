package com.firozkhan.ecommerce.application.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Product;
import com.firozkhan.ecommerce.model.enums.ProductStatus;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, UUID> {

    /**
     * Get all active products (storefront)
     */
    List<Product> findAllByStatus(ProductStatus status);

    /**
     * Get products by seller
     */
    List<Product> findAllBySellerId(UUID sellerId);

    /**
     * Get active products by seller
     */
    List<Product> findAllBySellerIdAndStatus(UUID sellerId, ProductStatus status);

    /**
     * Find product by SKU (inventory / validation)
     */
    Optional<Product> findBySku(String sku);

    /**
     * Check SKU uniqueness
     */
    boolean existsBySku(String sku);

    /**
     * Get products available now
     */
    List<Product> findAllByAvailableFromBeforeAndExpiresAtAfter(
            LocalDateTime now1,
            LocalDateTime now2
    );

    /**
     * Get low-stock products (inventory alert)
     */
    List<Product> findAllByStockQuantityLessThan(int threshold);

    /**
     * Full-text search (basic)
     */
    List<Product> findAllByNameContainingIgnoreCase(String keyword);

    /**
     * Category based listing
     */
    List<Product> findAllByCategoryId(UUID categoryId);
}
