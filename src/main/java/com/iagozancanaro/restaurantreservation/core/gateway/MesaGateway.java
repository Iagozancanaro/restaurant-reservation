package com.iagozancanaro.restaurantreservation.core.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.RestauranteEntity;

import java.util.List;
import java.util.Optional;

public interface MesaGateway {
    Mesa salvar (Mesa mesa);

    Optional<Mesa> buscarPorId(Long id);

    List<Mesa> listarMesas();

    Mesa atualizarStatus(Long id, StatusMesa status);

    Optional<MesaEntity> buscarEntityPorId(Long id);
}
