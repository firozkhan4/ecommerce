package com.firozkhan.ecommerce.application.service.payment;

import java.util.UUID;

import com.firozkhan.ecommerce.web.dto.request.ConfirmPaymentRequest;
import com.firozkhan.ecommerce.web.dto.request.InitiatePaymentRequest;
import com.firozkhan.ecommerce.web.dto.response.PaymentResponse;

public interface PaymentService {

    PaymentResponse initiatePayment(InitiatePaymentRequest request);

    PaymentResponse confirmPayment(ConfirmPaymentRequest request);

    PaymentResponse getPaymentByOrderId(UUID orderId);

    
}