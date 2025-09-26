package com.iagozancanaro.restaurantreservation.core.usecases.restaurante;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.core.gateway.RestauranteGateway;

public class CriarRestauranteUseCaseImp implements CriarRestauranteUseCase{

    private final RestauranteGateway restauranteGateway;

    public CriarRestauranteUseCaseImp(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Restaurante execute(Restaurante restaurante) {
        return restauranteGateway.salvar(restaurante);
    }
}
