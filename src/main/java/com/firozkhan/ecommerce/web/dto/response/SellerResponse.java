package com.firozkhan.ecommerce.web.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.firozkhan.ecommerce.modules.seller.domain.entity.Seller;
import com.firozkhan.ecommerce.modules.seller.domain.enums.SellerStatus;

import lombok.Builder;

@Builder
public class SellerResponse {

    private UUID id;
    private UUID userId;
    private String shopName;
    private SellerStatus status;
    private String gst;
    private LocalDateTime createdAt;

    public SellerResponse() {
    }

    public SellerResponse(UUID id, UUID userId, String shopName, SellerStatus status, String gst,
            LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.shopName = shopName;
        this.status = status;
        this.gst = gst;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public SellerStatus getStatus() {
        return status;
    }

    public void setStatus(SellerStatus status) {
        this.status = status;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static SellerResponse toDto(Seller seller){
        return SellerResponse.builder()
        .id(seller.getId())
        .userId(seller.getUserId())
        .shopName(seller.getShopName())
        .status(seller.getStatus())
        .gst(seller.getGst())
        .createdAt(seller.getCreatedAt())
        .build();

    }

}
