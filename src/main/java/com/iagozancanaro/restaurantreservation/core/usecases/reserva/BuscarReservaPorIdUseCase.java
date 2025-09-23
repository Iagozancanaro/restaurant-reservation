package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;

public interface BuscarReservaPorIdUseCase {

    public Reserva execute(Long id);
}
