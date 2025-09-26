package com.iagozancanaro.restaurantreservation.infrastructure.beans;

import com.iagozancanaro.restaurantreservation.core.gateway.RestauranteGateway;
import com.iagozancanaro.restaurantreservation.core.usecases.restaurante.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteBeanConfiguration {

    @Bean
    public BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase(RestauranteGateway restauranteGateway) {
        return new BuscarRestaurantePorIdUseCaseImp(restauranteGateway);
    }

    @Bean
    public CriarRestauranteUseCase criarRestauranteUseCase(RestauranteGateway restauranteGateway) {
        return new CriarRestauranteUseCaseImp(restauranteGateway);
    }

    @Bean
    public ListarRestaurantesUseCase listarRestaurantesUseCase(RestauranteGateway restauranteGateway) {
        return new ListarRestaurantesUseCaseImp(restauranteGateway);
    }

 }
