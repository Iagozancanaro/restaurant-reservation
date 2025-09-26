package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;

public class AtualizarStatusReservaUseCaseImp implements AtualizarStatusReservaUseCase {

    private final ReservaGateway reservaGateway;

    public AtualizarStatusReservaUseCaseImp(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Long id, StatusReserva status) {
        return reservaGateway.atualizarStatus(id, status);
    }
}
