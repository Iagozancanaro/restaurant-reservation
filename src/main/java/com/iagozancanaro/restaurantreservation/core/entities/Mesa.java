package com.iagozancanaro.restaurantreservation.core.entities;

import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;

public record Mesa(Long id,
                   Integer numero,
                   Integer capacidade,
                   StatusMesa status,
                   Long restauranteId) {}
