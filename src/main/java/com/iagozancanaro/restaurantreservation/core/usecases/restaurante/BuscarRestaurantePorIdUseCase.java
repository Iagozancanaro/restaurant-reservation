package com.iagozancanaro.restaurantreservation.core.usecases.restaurante;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;

public interface BuscarRestaurantePorIdUseCase {

    public Restaurante execute(Long id);
}
