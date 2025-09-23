package com.iagozancanaro.restaurantreservation.core.usecases.restaurante;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;

import java.util.List;

public interface ListarRestaurantesUseCase {

    public List<Restaurante> execute();
}
