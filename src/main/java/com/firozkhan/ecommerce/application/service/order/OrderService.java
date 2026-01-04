package com.firozkhan.ecommerce.application.service.order;

import java.util.List;
import java.util.UUID;

import com.firozkhan.ecommerce.web.dto.request.PlaceOrderRequest;
import com.firozkhan.ecommerce.web.dto.response.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(PlaceOrderRequest request);

    OrderResponse getOrderById(UUID orderId);

    List<OrderResponse> getMyOrders();

    void cancelOrder(UUID orderId);

    
}