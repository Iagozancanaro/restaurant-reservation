package com.iagozancanaro.restaurantreservation.core.usecases.cliente;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.ClienteGateway;

public class BuscarClientePorIdUseCaseImp implements BuscarClientePorIdUseCase {

    private final ClienteGateway clienteGateway;

    public BuscarClientePorIdUseCaseImp(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Long id) {
        return clienteGateway.buscarPorId(id)
                .orElseThrow(() -> new NotFoundException("Cliente com ID " + id + " não encontrado"));
    }
}
