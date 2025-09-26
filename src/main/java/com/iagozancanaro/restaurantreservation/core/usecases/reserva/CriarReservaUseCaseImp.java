package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;

public class CriarReservaUseCaseImp implements CriarReservaUseCase {

    private final ReservaGateway reservaGateway;

    public CriarReservaUseCaseImp(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Reserva reserva) {
        return reservaGateway.salvar(reserva);
    }
}
