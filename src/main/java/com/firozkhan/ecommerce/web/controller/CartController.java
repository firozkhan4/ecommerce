package com.firozkhan.ecommerce.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firozkhan.ecommerce.application.service.cart.CartService;
import com.firozkhan.ecommerce.web.dto.request.AddCartItemRequest;
import com.firozkhan.ecommerce.web.dto.request.UpdateCartItemRequest;
import com.firozkhan.ecommerce.web.dto.response.CartResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * Create cart for logged-in user (idempotent)
     */
    @PostMapping
    public ResponseEntity<CartResponse> createCart() {
        CartResponse response = cartService.createCart();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Add item to cart
     */
    @PostMapping("/items")
    public ResponseEntity<CartResponse> addItemToCart(
            @Valid @RequestBody AddCartItemRequest request) {
        CartResponse response = cartService.addItem(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Update cart item quantity
     */
    @PutMapping("/items/{productId}")
    public ResponseEntity<CartResponse> updateCartItem(
            @PathVariable String productId,
            @Valid @RequestBody UpdateCartItemRequest request) {
        CartResponse response = cartService.updateItem(productId, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Remove item from cart
     */
    @DeleteMapping("/items/{productId}")
    public ResponseEntity<Void> removeItemFromCart(
            @PathVariable String productId) {
        cartService.removeItem(productId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get cart details
     */
    @GetMapping
    public ResponseEntity<CartResponse> getCartDetails() {
        CartResponse response = cartService.getCart();
        return ResponseEntity.ok(response);
    }

    /**
     * Clear cart
     */
    @DeleteMapping
    public ResponseEntity<Void> clearCart() {
        cartService.clearCart();
        return ResponseEntity.noContent().build();
    }
}
