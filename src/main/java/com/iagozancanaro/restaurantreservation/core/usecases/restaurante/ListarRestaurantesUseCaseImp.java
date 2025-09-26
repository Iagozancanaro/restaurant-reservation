package com.iagozancanaro.restaurantreservation.core.usecases.restaurante;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.core.gateway.RestauranteGateway;

import java.util.List;

public class ListarRestaurantesUseCaseImp implements ListarRestaurantesUseCase{

    private final RestauranteGateway restauranteGateway;

    public ListarRestaurantesUseCaseImp(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public List<Restaurante> execute() {
        return restauranteGateway.listarRestaurantes();
    }
}
