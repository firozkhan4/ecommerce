package com.firozkhan.ecommerce.web.dto.request;

import java.util.UUID;

public class CreateSellerRequest {

    private UUID userId;
    private String shopName;
    private String gst;

    public CreateSellerRequest() {
    }

    public CreateSellerRequest(UUID userId, String shopName, String gst) {
        this.userId = userId;
        this.shopName = shopName;
        this.gst = gst;
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

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

}
