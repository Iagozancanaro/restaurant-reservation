package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;

public interface AtualizarReservaUseCase {

    public Reserva execute(Long id, Reserva dadosAtualizados);
}
