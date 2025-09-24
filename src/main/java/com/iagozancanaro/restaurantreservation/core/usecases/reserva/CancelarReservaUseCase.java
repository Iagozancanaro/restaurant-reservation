package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;

public interface CancelarReservaUseCase {

    Reserva execute(Long id);
}
