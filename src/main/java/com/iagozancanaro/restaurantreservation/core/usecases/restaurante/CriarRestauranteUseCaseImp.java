package com.iagozancanaro.restaurantreservation.core.usecases.restaurante;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.core.exceptions.InvalidCapacityException;
import com.iagozancanaro.restaurantreservation.core.gateway.RestauranteGateway;

public class CriarRestauranteUseCaseImp implements CriarRestauranteUseCase{

    private final RestauranteGateway restauranteGateway;

    public CriarRestauranteUseCaseImp(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    @Override
    public Restaurante execute(Restaurante restaurante) {
        if (restaurante.capacidadeTotal() <= 0) {
            throw new InvalidCapacityException("A capacidade total do restaurante deve ser maior que 0");
        }
        return restauranteGateway.salvar(restaurante);
    }
}
