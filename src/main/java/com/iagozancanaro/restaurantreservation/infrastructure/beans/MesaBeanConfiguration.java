package com.iagozancanaro.restaurantreservation.infrastructure.beans;

import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MesaBeanConfiguration {

    @Bean
    public AtualizarStatusMesaUseCase atualizarStatusMesaUseCase(MesaGateway mesaGateway) {
        return new AtualizarStatusMesaUseCaseImp(mesaGateway);
    }

    @Bean
    public BuscarMesaPorIdUseCase buscarMesaPorIdUseCase(MesaGateway mesaGateway) {
        return new BuscarMesaPorIdUseCaseImp(mesaGateway);
    }

    @Bean
    public CriarMesaUseCase criarMesaUseCase(MesaGateway mesaGateway) {
        return new CriarMesaUseCaseImp(mesaGateway);
    }

    @Bean
    public ListarMesasUseCase listarMesasUseCase(MesaGateway mesaGateway) {
        return new ListarMesasUseCaseImp(mesaGateway);
    }

}
