package com.iagozancanaro.restaurantreservation.infrastructure.presentation;

import com.iagozancanaro.restaurantreservation.core.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, String>> handleBusinessExceptions(BusinessException ex) {
        Map<String, String> body = Map.of(
                "error", ex.getClass().getSimpleName(),
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}


