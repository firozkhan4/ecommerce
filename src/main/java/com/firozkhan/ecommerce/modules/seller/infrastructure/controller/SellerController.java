package com.firozkhan.ecommerce.modules.seller.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firozkhan.ecommerce.application.service.seller.SellerService;
import com.firozkhan.ecommerce.web.dto.request.CreateSellerRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateSellerRequest;
import com.firozkhan.ecommerce.web.dto.response.SellerResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    /**
     * Onboard as a new seller
     */
    @PostMapping
    public ResponseEntity<SellerResponse> createSeller(
            @Valid @RequestBody CreateSellerRequest request) {
        SellerResponse response = sellerService.createSeller(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Update seller profile
     */
    @PutMapping("/{sellerId}")
    public ResponseEntity<SellerResponse> updateSeller(
            @PathVariable UUID sellerId,
            @Valid @RequestBody UpdateSellerRequest request) {
        SellerResponse response = sellerService.updateSeller(sellerId, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Get seller profile
     */
    @GetMapping("/{sellerId}")
    public ResponseEntity<SellerResponse> getSeller(
            @PathVariable UUID sellerId) {
        SellerResponse response = sellerService.getSellerById(sellerId);
        return ResponseEntity.ok(response);
    }

    /**
     * List all sellers (optional filtering)
     */
    @GetMapping
    public ResponseEntity<List<SellerResponse>> getAllSellers(
            @RequestParam(required = false) String status) {
        List<SellerResponse> sellers = sellerService.getAllSellers(status);
        return ResponseEntity.ok(sellers);
    }

    /**
     * Delete seller (soft delete)
     */
    @DeleteMapping("/{sellerId}")
    public ResponseEntity<Void> deleteSeller(
            @PathVariable UUID sellerId) {
        sellerService.deleteSeller(sellerId);
        return ResponseEntity.noContent().build();
    }
}
