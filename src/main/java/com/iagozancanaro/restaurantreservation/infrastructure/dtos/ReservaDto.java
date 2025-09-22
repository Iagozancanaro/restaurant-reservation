package com.iagozancanaro.restaurantreservation.infrastructure.dtos;

import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;

import java.time.LocalDateTime;

public record ReservaDto(Long id,
                         LocalDateTime dataHora,
                         Long clienteId,
                         Long mesaId,
                         StatusReserva status) {
}
