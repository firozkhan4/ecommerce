package com.firozkhan.ecommerce.application.service.cart.implement;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.service.cart.CartService;
import com.firozkhan.ecommerce.web.dto.request.AddCartItemRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateCartItemRequest;
import com.firozkhan.ecommerce.web.dto.response.CartResponse;

@Service
public class CartServiceImp implements CartService {

    @Override
    public CartResponse createCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCart'");
    }

    @Override
    public CartResponse addItem(AddCartItemRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    @Override
    public CartResponse updateItem(String productId, UpdateCartItemRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateItem'");
    }

    @Override
    public void removeItem(String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }

    @Override
    public CartResponse getCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCart'");
    }

    @Override
    public void clearCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearCart'");
    }

}
