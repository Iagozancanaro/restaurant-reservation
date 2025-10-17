package com.iagozancanaro.restaurantreservation.core.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ClienteEntity;

import java.util.Optional;

public interface ClienteGateway {

    Cliente salvar(Cliente cliente);

    Optional<Cliente> buscarPorId(Long id);

    Optional<ClienteEntity> buscarEntityPorId(Long id);
}
