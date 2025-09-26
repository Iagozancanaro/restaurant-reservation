package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;

import java.util.List;

public class ListarReservasUseCaseImp implements ListarReservasUseCase {

    private final ReservaGateway reservaGateway;

    public ListarReservasUseCaseImp(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public List<Reserva> execute() {
        return reservaGateway.listarReservas();
    }
}
