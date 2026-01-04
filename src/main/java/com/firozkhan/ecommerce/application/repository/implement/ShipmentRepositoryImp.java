package com.firozkhan.ecommerce.application.repository.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.model.entity.Shipment;
import com.firozkhan.ecommerce.model.enums.ShipmentStatus;
import com.firozkhan.ecommerce.model.repository.ShipmentRepository;

@Repository
public class ShipmentRepositoryImp implements ShipmentRepository {

    @Override
    public Optional<Shipment> findByOrderId(UUID orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByOrderId'");
    }

    @Override
    public Optional<Shipment> findByTrackingNumber(String trackingNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTrackingNumber'");
    }

    @Override
    public List<Shipment> findAllByStatus(ShipmentStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByStatus'");
    }

    @Override
    public List<Shipment> findAllByCarrier(String carrier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByCarrier'");
    }

    @Override
    public boolean existsByOrderId(UUID orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByOrderId'");
    }

}