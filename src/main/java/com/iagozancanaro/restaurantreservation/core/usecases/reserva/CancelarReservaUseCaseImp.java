package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.AtualizarStatusMesaUseCase;

public class CancelarReservaUseCaseImp implements CancelarReservaUseCase {

    private final ReservaGateway reservaGateway;
    private final MesaGateway mesaGateway;
    private final AtualizarStatusMesaUseCase atualizarStatusMesaUseCase;

    public CancelarReservaUseCaseImp(ReservaGateway reservaGateway, MesaGateway mesaGateway, AtualizarStatusMesaUseCase atualizarStatusMesaUseCase) {
        this.reservaGateway = reservaGateway;
        this.mesaGateway = mesaGateway;
        this.atualizarStatusMesaUseCase = atualizarStatusMesaUseCase;
    }

    @Override
    public Reserva execute(Long id) {
        Reserva reserva = reservaGateway.buscarPorId(id)
                .orElseThrow(() -> new NotFoundException("Reserva com o Id " +id+ " não encontrada"));

        if (reserva.status().equals(StatusReserva.CANCELADA)) {
            throw new IllegalStateException("Reserva já está cancelada");
        }

        // Atualiza status da reserva
        Reserva reservaCancelada = reserva.comStatus(StatusReserva.CANCELADA);

        // Libera a mesa
        atualizarStatusMesaUseCase.execute(reserva.mesaId(), StatusMesa.LIVRE);

        return reservaGateway.salvar(reserva, reserva.clienteId(), reserva.mesaId());

    }
}
