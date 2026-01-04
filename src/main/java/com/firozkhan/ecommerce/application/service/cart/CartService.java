package com.firozkhan.ecommerce.application.service.cart;

import com.firozkhan.ecommerce.web.dto.request.AddCartItemRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateCartItemRequest;
import com.firozkhan.ecommerce.web.dto.response.CartResponse;

public interface CartService {

    CartResponse createCart();

    CartResponse addItem(AddCartItemRequest request);

    CartResponse updateItem(String productId, UpdateCartItemRequest request);

    void removeItem(String productId);

    CartResponse getCart();

    void clearCart();

    
}