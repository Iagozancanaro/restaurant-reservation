package com.iagozancanaro.restaurantreservation.core.usecases.reserva;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;
import com.iagozancanaro.restaurantreservation.core.exceptions.MesaNotAvailableException;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.ClienteGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.AtualizarStatusMesaUseCase;

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
        //Buscar cliente
        clienteGateway.buscarPorId(reserva.clienteId())
                .orElseThrow(() -> new NotFoundException("Cliente com o Id " +reserva.clienteId()+ " , não encontrado."));

        //Buscar mesa e validar disponibilidade
        Mesa mesa = mesaGateway.buscarPorId(reserva.mesaId())
                .orElseThrow(() -> new NotFoundException("Mesa com o Id " +reserva.mesaId()+ " , não encontrada."));

        if (!StatusMesa.LIVRE.equals(mesa.status())) {
            throw new MesaNotAvailableException("Mesa " +mesa.numero() + " não esta disponível.");
        }
        //Atualiza status da mesa
        atualizarStatusMesaUseCase.execute(mesa.id(), StatusMesa.RESERVADA);

        //Define status da reserva
        Reserva reservaConfirmada = reserva.comStatus(StatusReserva.CONFIRMADA);

        return reservaGateway.salvar(reservaConfirmada);
    }
}
