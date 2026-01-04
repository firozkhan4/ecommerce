package com.firozkhan.ecommerce.application.service.product.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.service.product.ProductService;
import com.firozkhan.ecommerce.web.dto.request.CreateProductRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateProductRequest;
import com.firozkhan.ecommerce.web.dto.response.ProductResponse;

@Service
public class ProductServiceImp implements ProductService {

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public ProductResponse updateProduct(UUID productId, UpdateProductRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public ProductResponse getProductById(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

    @Override
    public List<ProductResponse> getAllProducts(UUID categoryId, String search, int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public void deleteProduct(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

}
