package com.firozkhan.ecommerce.application.service.seller.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.exception.ResourceNotFoundException;
import com.firozkhan.ecommerce.application.service.seller.SellerService;
import com.firozkhan.ecommerce.modules.seller.domain.entity.Seller;
import com.firozkhan.ecommerce.modules.seller.domain.repository.SellerRepository;
import com.firozkhan.ecommerce.modules.user.domain.repository.UserRepository;
import com.firozkhan.ecommerce.web.dto.request.CreateSellerRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateSellerRequest;
import com.firozkhan.ecommerce.web.dto.response.SellerResponse;

@Service
public class SellerServiceImp implements SellerService {

    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;


    public SellerServiceImp(SellerRepository sellerRepository, UserRepository userRepository) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SellerResponse createSeller(CreateSellerRequest request) {
        
        if(!userRepository.existsById(request.getUserId()))
            throw new ResourceNotFoundException("User not found");
        
        var seller = new Seller(request.getUserId(), request.getShopName(), request.getGst());

        var newSeller = sellerRepository.save(seller);

        return SellerResponse.toDto(newSeller);
    }

    @Override
    public SellerResponse updateSeller(UUID sellerId, UpdateSellerRequest request) {
       return null;
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
