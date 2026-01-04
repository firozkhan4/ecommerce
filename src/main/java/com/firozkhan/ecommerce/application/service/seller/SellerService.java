package com.firozkhan.ecommerce.application.service.seller;

import java.util.List;
import java.util.UUID;

import com.firozkhan.ecommerce.web.dto.request.CreateSellerRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateSellerRequest;
import com.firozkhan.ecommerce.web.dto.response.SellerResponse;

public interface SellerService {

    SellerResponse createSeller(CreateSellerRequest request);

    SellerResponse updateSeller(UUID sellerId, UpdateSellerRequest request);

    SellerResponse getSellerById(UUID sellerId);

    List<SellerResponse> getAllSellers(String status);

    void deleteSeller(UUID sellerId);

    
}