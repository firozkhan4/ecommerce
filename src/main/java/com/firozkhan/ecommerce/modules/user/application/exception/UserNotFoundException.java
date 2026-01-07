package com.firozkhan.ecommerce.modules.user.application.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){

    }

    public UserNotFoundException(String message){
        super(message);
    }
    
}