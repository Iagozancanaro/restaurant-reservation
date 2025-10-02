package com.iagozancanaro.restaurantreservation.infrastructure.beans;

import com.iagozancanaro.restaurantreservation.core.gateway.ClienteGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.AtualizarStatusMesaUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.reserva.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaBeanConfiguration {

    @Bean
    public AtualizarStatusReservaUseCase atualizarStatusReservaUseCase(
            ReservaGateway reservaGateway,
            MesaGateway mesaGateway) {
        return new AtualizarStatusReservaUseCaseImp(reservaGateway, mesaGateway);
    }

    @Bean
    public BuscarReservaPorIdUseCase buscarReservaPorIdUseCase(ReservaGateway reservaGateway) {
        return new BuscarReservaPorIdUseCaseImp(reservaGateway);
    }

    @Bean
    public CancelarReservaUseCase cancelarReservaUseCase(
            ReservaGateway reservaGateway,
            MesaGateway mesaGateway,
            AtualizarStatusMesaUseCase atualizarStatusMesaUseCase) {
        return new CancelarReservaUseCaseImp(reservaGateway, mesaGateway, atualizarStatusMesaUseCase);
    }

    @Bean
    public CriarReservaUseCase criarReservaUseCase(
            ReservaGateway reservaGateway,
            ClienteGateway clienteGateway,
            MesaGateway mesaGateway,
            AtualizarStatusMesaUseCase atualizarStatusMesaUseCase) {
        return new CriarReservaUseCaseImp(reservaGateway, clienteGateway, mesaGateway, atualizarStatusMesaUseCase);
    }

    @Bean
    public ListarReservasUseCase listarReservasUseCase(ReservaGateway reservaGateway) {
        return new ListarReservasUseCaseImp(reservaGateway);
    }
}
