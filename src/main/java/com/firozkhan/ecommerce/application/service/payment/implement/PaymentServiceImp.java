package com.firozkhan.ecommerce.application.service.payment.implement;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.service.payment.PaymentService;
import com.firozkhan.ecommerce.web.dto.request.ConfirmPaymentRequest;
import com.firozkhan.ecommerce.web.dto.request.InitiatePaymentRequest;
import com.firozkhan.ecommerce.web.dto.response.PaymentResponse;

@Service
public class PaymentServiceImp implements PaymentService {

    @Override
    public PaymentResponse initiatePayment(InitiatePaymentRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initiatePayment'");
    }

    @Override
    public PaymentResponse confirmPayment(ConfirmPaymentRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'confirmPayment'");
    }

    @Override
    public PaymentResponse getPaymentByOrderId(UUID orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentByOrderId'");
    }

}
