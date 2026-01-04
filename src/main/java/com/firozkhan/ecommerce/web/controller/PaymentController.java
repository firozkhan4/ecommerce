package com.firozkhan.ecommerce.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firozkhan.ecommerce.application.service.payment.PaymentService;
import com.firozkhan.ecommerce.web.dto.request.ConfirmPaymentRequest;
import com.firozkhan.ecommerce.web.dto.request.InitiatePaymentRequest;
import com.firozkhan.ecommerce.web.dto.response.PaymentResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Initiate payment for an order
     */
    @PostMapping("/initiate")
    public ResponseEntity<PaymentResponse> initiatePayment(
            @Valid @RequestBody InitiatePaymentRequest request) {
        PaymentResponse response = paymentService.initiatePayment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Confirm payment (gateway callback / client confirmation)
     */
    @PostMapping("/confirm")
    public ResponseEntity<PaymentResponse> confirmPayment(
            @Valid @RequestBody ConfirmPaymentRequest request) {
        PaymentResponse response = paymentService.confirmPayment(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Get payment details by order ID
     */
    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentByOrderId(
            @PathVariable UUID orderId) {
        PaymentResponse response = paymentService.getPaymentByOrderId(orderId);
        return ResponseEntity.ok(response);
    }
}
