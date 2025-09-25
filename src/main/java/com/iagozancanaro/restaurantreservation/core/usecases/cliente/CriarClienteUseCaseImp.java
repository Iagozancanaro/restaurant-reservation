package com.iagozancanaro.restaurantreservation.core.usecases.cliente;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;
import com.iagozancanaro.restaurantreservation.core.gateway.ClienteGateway;

public class CriarClienteUseCaseImp implements CriarClienteUseCase {

    final private ClienteGateway clienteGateway;

    public CriarClienteUseCaseImp(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteGateway.salvar(cliente);
    }

}
