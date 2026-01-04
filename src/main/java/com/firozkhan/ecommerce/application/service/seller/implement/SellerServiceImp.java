package com.firozkhan.ecommerce.application.service.seller.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.service.seller.SellerService;
import com.firozkhan.ecommerce.web.dto.request.CreateSellerRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateSellerRequest;
import com.firozkhan.ecommerce.web.dto.response.SellerResponse;

@Service
public class SellerServiceImp implements SellerService {

    @Override
    public SellerResponse createSeller(CreateSellerRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSeller'");
    }

    @Override
    public SellerResponse updateSeller(UUID sellerId, UpdateSellerRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSeller'");
    }

    @Override
    public SellerResponse getSellerById(UUID sellerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSellerById'");
    }

    @Override
    public List<SellerResponse> getAllSellers(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSellers'");
    }

    @Override
    public void deleteSeller(UUID sellerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSeller'");
    }

}
