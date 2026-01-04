package com.firozkhan.ecommerce.application.service.shipment;

import java.util.List;
import java.util.UUID;

import com.firozkhan.ecommerce.web.dto.request.CreateShipmentRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateShipmentStatusRequest;
import com.firozkhan.ecommerce.web.dto.response.ShipmentResponse;

public interface ShipmentService {

    ShipmentResponse createShipment(CreateShipmentRequest request);

    ShipmentResponse updateStatus(UUID shipmentId, UpdateShipmentStatusRequest request);

    ShipmentResponse getShipmentById(UUID shipmentId);

    List<ShipmentResponse> getAllShipments(String status, UUID orderId);
    
}