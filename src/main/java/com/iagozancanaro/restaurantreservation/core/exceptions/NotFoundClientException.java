package com.iagozancanaro.restaurantreservation.core.exceptions;

public class NotFoundClientException extends RuntimeException {
    public NotFoundClientException(String message) {
        super(message);
    }
}
