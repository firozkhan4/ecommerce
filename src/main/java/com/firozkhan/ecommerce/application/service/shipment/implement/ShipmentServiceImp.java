package com.firozkhan.ecommerce.application.service.shipment.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.application.service.shipment.ShipmentService;
import com.firozkhan.ecommerce.web.dto.request.CreateShipmentRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateShipmentStatusRequest;
import com.firozkhan.ecommerce.web.dto.response.ShipmentResponse;

@Service
public class ShipmentServiceImp implements ShipmentService {

    @Override
    public ShipmentResponse createShipment(CreateShipmentRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createShipment'");
    }

    @Override
    public ShipmentResponse updateStatus(UUID shipmentId, UpdateShipmentStatusRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStatus'");
    }

    @Override
    public ShipmentResponse getShipmentById(UUID shipmentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShipmentById'");
    }

    @Override
    public List<ShipmentResponse> getAllShipments(String status, UUID orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllShipments'");
    }

}
