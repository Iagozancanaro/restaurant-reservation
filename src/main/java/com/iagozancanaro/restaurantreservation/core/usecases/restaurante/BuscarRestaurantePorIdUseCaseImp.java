package com.iagozancanaro.restaurantreservation.core.usecases.restaurante;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.RestauranteGateway;

public class BuscarRestaurantePorIdUseCaseImp implements BuscarRestaurantePorIdUseCase {

    private final RestauranteGateway restauranteGateway;

    public BuscarRestaurantePorIdUseCaseImp(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Restaurante execute(Long id) {
        return restauranteGateway.buscarPorId(id)
                .orElseThrow(() -> new NotFoundException("Restaurante com ID " + id + " não encontrado"));
    }
}
