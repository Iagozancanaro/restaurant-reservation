package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;

public class CancelarReservaUseCaseImp implements CancelarReservaUseCase {

    private final ReservaGateway reservaGateway;

    public CancelarReservaUseCaseImp(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Long id) {
        return reservaGateway.cancelarReserva(id);
    }
}
