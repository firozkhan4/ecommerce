package com.firozkhan.ecommerce.application.service.order.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.service.order.OrderService;
import com.firozkhan.ecommerce.web.dto.request.PlaceOrderRequest;
import com.firozkhan.ecommerce.web.dto.response.OrderResponse;

@Service
public class OrderServiceImp implements OrderService {

    @Override
    public OrderResponse placeOrder(PlaceOrderRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'placeOrder'");
    }

    @Override
    public OrderResponse getOrderById(UUID orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderById'");
    }

    @Override
    public List<OrderResponse> getMyOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMyOrders'");
    }

    @Override
    public void cancelOrder(UUID orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelOrder'");
    }

}
