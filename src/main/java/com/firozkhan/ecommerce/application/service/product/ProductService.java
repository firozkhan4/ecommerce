package com.firozkhan.ecommerce.application.service.product;

import java.util.List;
import java.util.UUID;

import com.firozkhan.ecommerce.web.dto.request.CreateProductRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateProductRequest;
import com.firozkhan.ecommerce.web.dto.response.ProductResponse;

public interface ProductService {

    ProductResponse createProduct(CreateProductRequest request);

    ProductResponse updateProduct(UUID productId, UpdateProductRequest request);

    ProductResponse getProductById(UUID productId);

    List<ProductResponse> getAllProducts(UUID categoryId, String search, int page, int size);

    void deleteProduct(UUID productId);

    
}