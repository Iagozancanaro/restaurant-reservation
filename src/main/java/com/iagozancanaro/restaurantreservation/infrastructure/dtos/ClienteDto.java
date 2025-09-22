package com.iagozancanaro.restaurantreservation.infrastructure.dtos;

import java.util.List;

public record ClienteDto(Long id,
                         String nome,
                         String email,
                         String telefone,
                         List<ReservaDto> reservas) {
}
