package com.firozkhan.ecommerce.web.dto.response;

import java.util.UUID;

public class AuthResponse {

    private UUID id;
    private String token;

    public AuthResponse() {
    }

    public AuthResponse(UUID id, String token) {
        this.id = id;
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
