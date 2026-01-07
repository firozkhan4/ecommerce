package com.firozkhan.ecommerce.modules.product.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.firozkhan.ecommerce.modules.product.domain.entity.Product;
import com.firozkhan.ecommerce.modules.product.domain.enums.ProductStatus;

public interface ProductRepository {

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
            LocalDateTime now2);

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
