package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;

public interface AtualizarStatusReservaUseCase {

    public Reserva execute(Long id, StatusReserva status);
}
