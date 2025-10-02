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
        if (cliente.nome() ==  null || cliente.nome().isBlank()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }
        if (cliente.email() ==  null || cliente.email().isBlank()) {
            throw new IllegalArgumentException("O email do cliente é obrigatório.");
        }
        if (cliente.telefone() ==  null || cliente.telefone().isBlank()) {
            throw new IllegalArgumentException("O telefone do cliente é obrigatório.");
        }

        return clienteGateway.salvar(cliente);
    }

}
