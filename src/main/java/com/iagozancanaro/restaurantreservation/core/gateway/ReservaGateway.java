package com.iagozancanaro.restaurantreservation.core.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;

import java.util.List;
import java.util.Optional;

public interface ReservaGateway {

    Reserva salvar (Reserva reserva);

    Optional<Reserva> buscarPorId(Long id);

    List<Reserva> listarReservas();

    Reserva atualizarStatus(Long id, StatusReserva novoStatus);

    Reserva cancelarReserva(Long id);
}
