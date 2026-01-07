package com.firozkhan.ecommerce.modules.shipment.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firozkhan.ecommerce.application.service.shipment.ShipmentService;
import com.firozkhan.ecommerce.web.dto.request.CreateShipmentRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateShipmentStatusRequest;
import com.firozkhan.ecommerce.web.dto.response.ShipmentResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    /**
     * Create shipment for an order
     */
    @PostMapping
    public ResponseEntity<ShipmentResponse> createShipment(
            @Valid @RequestBody CreateShipmentRequest request
    ) {
        ShipmentResponse response = shipmentService.createShipment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Update shipment status (e.g., In Transit, Delivered)
     */
    @PutMapping("/{shipmentId}/status")
    public ResponseEntity<ShipmentResponse> updateShipmentStatus(
            @PathVariable UUID shipmentId,
            @Valid @RequestBody UpdateShipmentStatusRequest request
    ) {
        ShipmentResponse response = shipmentService.updateStatus(shipmentId, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Get shipment by ID
     */
    @GetMapping("/{shipmentId}")
    public ResponseEntity<ShipmentResponse> getShipmentById(
            @PathVariable UUID shipmentId
    ) {
        ShipmentResponse response = shipmentService.getShipmentById(shipmentId);
        return ResponseEntity.ok(response);
    }

    /**
     * List all shipments (optional filters)
     */
    @GetMapping
    public ResponseEntity<List<ShipmentResponse>> getAllShipments(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) UUID orderId
    ) {
        List<ShipmentResponse> shipments = shipmentService.getAllShipments(status, orderId);
        return ResponseEntity.ok(shipments);
    }
}
