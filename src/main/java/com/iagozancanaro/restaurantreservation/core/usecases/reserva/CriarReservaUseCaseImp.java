package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;
import com.iagozancanaro.restaurantreservation.core.exceptions.MesaNotAvailableException;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.ClienteGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.AtualizarStatusMesaUseCase;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ClienteEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaEntity;

public class CriarReservaUseCaseImp implements CriarReservaUseCase {

    private final ReservaGateway reservaGateway;
    private final ClienteGateway clienteGateway;
    private final MesaGateway mesaGateway;
    private final AtualizarStatusMesaUseCase atualizarStatusMesaUseCase;

    public CriarReservaUseCaseImp(ReservaGateway reservaGateway, ClienteGateway clienteGateway, MesaGateway mesaGateway, AtualizarStatusMesaUseCase atualizarStatusMesaUseCase) {
        this.reservaGateway = reservaGateway;
        this.clienteGateway = clienteGateway;
        this.mesaGateway = mesaGateway;
        this.atualizarStatusMesaUseCase = atualizarStatusMesaUseCase;
    }

    @Override
    public Reserva execute(Reserva reserva) {
        // Buscar cliente e guardar em uma variável
        ClienteEntity clienteEntity = clienteGateway.buscarEntityPorId(reserva.clienteId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));

        // Buscar mesa e validar disponibilidade
        MesaEntity mesaEntity = mesaGateway.buscarEntityPorId(reserva.mesaId())
                .orElseThrow(() -> new NotFoundException("Mesa não encontrada."));

        if (!StatusMesa.LIVRE.equals(mesaEntity.getStatus())) {
            throw new MesaNotAvailableException("Mesa " + mesaEntity.getNumero() + " não está disponível.");
        }

        // Atualiza status da mesa
        atualizarStatusMesaUseCase.execute(mesaEntity.getId(), StatusMesa.RESERVADA);
        Reserva reservaConfirmada = reserva.comStatus(StatusReserva.CONFIRMADA);

        return reservaGateway.salvar(reservaConfirmada, reserva.clienteId(), reserva.mesaId());
    }
}
