package com.iagozancanaro.restaurantreservation.infrastructure.dtos;

import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;

import java.util.List;

public record MesaDto(Long id,
                      Integer numero,
                      Integer capacidade,
                      StatusMesa status,
                      Long restauranteId,
                      List<ReservaDto> reservas) {
}
