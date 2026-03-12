package com.order.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends EntityNotFoundException {

    public OrderNotFoundException(int id) {
        super("Order not found with Order ID: " + id);
    }
}
