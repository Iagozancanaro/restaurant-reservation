package com.iagozancanaro.restaurantreservation.core.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ClienteEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaEntity;

import java.util.List;
import java.util.Optional;

public interface ReservaGateway {

    Reserva salvar (Reserva reserva, Long clientId, Long mesaId);

    Optional<Reserva> buscarPorId(Long id);

    List<Reserva> listarReservas();

    Reserva atualizarStatus(Long id, StatusReserva novoStatus);

    Reserva cancelarReserva(Long id);
}
