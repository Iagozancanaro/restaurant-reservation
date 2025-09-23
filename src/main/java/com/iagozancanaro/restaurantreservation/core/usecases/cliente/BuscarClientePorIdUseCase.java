package com.iagozancanaro.restaurantreservation.core.usecases.cliente;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;

public interface BuscarClientePorIdUseCase {

    public Cliente execute(Long id);
}
