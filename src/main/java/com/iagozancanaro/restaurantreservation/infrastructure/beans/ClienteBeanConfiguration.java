package com.iagozancanaro.restaurantreservation.infrastructure.beans;

import com.iagozancanaro.restaurantreservation.core.gateway.ClienteGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.cliente.BuscarClientePorIdUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.cliente.BuscarClientePorIdUseCaseImp;
import com.iagozancanaro.restaurantreservation.core.usecases.cliente.CriarClienteUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.cliente.CriarClienteUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfiguration {

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClienteGateway clienteGateway) {
        return new CriarClienteUseCaseImp(clienteGateway);
    }

    @Bean
    public BuscarClientePorIdUseCase buscarClientePorIdUseCase(ClienteGateway clienteGateway) {
        return new BuscarClientePorIdUseCaseImp(clienteGateway);
    }
}
