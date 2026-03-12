package com.order.service.exception;

public abstract class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message){
        super(message);
    }   
}
