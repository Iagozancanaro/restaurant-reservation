package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;

public class AtualizarStatusReservaUseCaseImp implements AtualizarStatusReservaUseCase {

    private final ReservaGateway reservaGateway;
    private final MesaGateway mesaGateway;

    public AtualizarStatusReservaUseCaseImp(ReservaGateway reservaGateway, MesaGateway mesaGateway) {
        this.reservaGateway = reservaGateway;
        this.mesaGateway = mesaGateway;
    }

    @Override
    public Reserva execute(Long id, StatusReserva status) {

        // Verifica se a reserva ja esta CANCELADA
        if (status == StatusReserva.CANCELADA) {
            throw new IllegalStateException("Não é possivel atualizar uma reserva já cancelada");
        }

        Reserva reserva = reservaGateway.buscarPorId(id)
                .orElseThrow(() -> new NotFoundException("Reserva com o Id " +id+ " não encontrada"));

        Mesa mesa = mesaGateway.buscarPorId(reserva.mesaId())
                .orElseThrow(() -> new NotFoundException("Mesa com o Id " +reserva.mesaId()+ " não encontrada"));

        // Atualizar conforme o novo status
        if (status == StatusReserva.CANCELADA || status == StatusReserva.CONCLUIDA) {
            // Libera a mesa
            mesaGateway.atualizarStatus(mesa.id(), StatusMesa.LIVRE);
        } else if (status == StatusReserva.CONFIRMADA) {
            // Garante que a mesa esteja livre antes de reservar
            if (!StatusMesa.LIVRE.equals(mesa.status())) {
                throw new RuntimeException("Mesa " +mesa.numero()+ " não está disponível para confirmar a reserva.");
            }
            mesaGateway.atualizarStatus(mesa.id(), StatusMesa.RESERVADA);
        }

        // Atualizar status da reserva
        Reserva reservaAtualizada = reserva.comStatus(status);
        return reservaGateway.salvar(reserva, reserva.clienteId(), reserva.mesaId());
    }
}
