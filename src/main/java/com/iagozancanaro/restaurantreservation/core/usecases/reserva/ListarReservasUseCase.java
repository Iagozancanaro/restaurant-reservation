package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;

import java.util.List;

public interface ListarReservasUseCase {

    public List<Reserva> execute();
}
