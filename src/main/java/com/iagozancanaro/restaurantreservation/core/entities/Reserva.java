package com.iagozancanaro.restaurantreservation.core.entities;

import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;

import java.time.LocalDateTime;

public record Reserva(Long id,
                      LocalDateTime dataHora,
                      Long clienteId,
                      Long mesaId,
                      StatusReserva status) {}
