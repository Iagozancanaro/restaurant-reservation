package com.iagozancanaro.restaurantreservation.core.exceptions;

public class NotFoundException extends BusinessException {
    public NotFoundException(String message) {
        super(message);
    }
}
