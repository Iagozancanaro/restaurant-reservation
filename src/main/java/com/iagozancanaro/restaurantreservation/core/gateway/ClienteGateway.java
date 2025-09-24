package com.iagozancanaro.restaurantreservation.core.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;

import java.util.Optional;

public interface ClienteGateway {

    Cliente salvar(Cliente cliente);

    Optional<Cliente> buscarPorId(Long id);
}
