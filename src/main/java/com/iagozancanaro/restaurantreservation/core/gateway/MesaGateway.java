package com.iagozancanaro.restaurantreservation.core.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;

import java.util.List;
import java.util.Optional;

public interface MesaGateway {
    Mesa salvar (Mesa mesa);

    Optional<Mesa> buscarPorId(Long id);

    List<Mesa> listarMesas();

    Mesa atualizarStatus(Long id, StatusMesa status);
}
