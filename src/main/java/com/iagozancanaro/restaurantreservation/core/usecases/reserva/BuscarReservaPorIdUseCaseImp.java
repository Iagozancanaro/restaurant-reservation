package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;

public class BuscarReservaPorIdUseCaseImp implements BuscarReservaPorIdUseCase {

    private final ReservaGateway reservaGateway;

    public BuscarReservaPorIdUseCaseImp(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Long id) {
        return reservaGateway.buscarPorId(id)
                .orElseThrow(() -> new NotFoundException("Reserva com ID " + id + " não encontrada"));
    }
}
