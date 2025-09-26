package com.iagozancanaro.restaurantreservation.infrastructure.beans;

import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.reserva.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaBeanConfiguration {

    @Bean
    public AtualizarStatusReservaUseCase atualizarStatusReservaUseCase(ReservaGateway reservaGateway) {
        return new AtualizarStatusReservaUseCaseImp(reservaGateway);
    }

    @Bean
    public BuscarReservaPorIdUseCase buscarReservaPorIdUseCase(ReservaGateway reservaGateway) {
        return new BuscarReservaPorIdUseCaseImp(reservaGateway);
    }

    @Bean
    public CancelarReservaUseCase cancelarReservaUseCase(ReservaGateway reservaGateway) {
        return new CancelarReservaUseCaseImp(reservaGateway);
    }

    @Bean
    public CriarReservaUseCase criarReservaUseCase(ReservaGateway reservaGateway) {
        return new CriarReservaUseCaseImp(reservaGateway);
    }

    @Bean
    public ListarReservasUseCase listarReservasUseCase(ReservaGateway reservaGateway) {
        return new ListarReservasUseCaseImp(reservaGateway);
    }
}
