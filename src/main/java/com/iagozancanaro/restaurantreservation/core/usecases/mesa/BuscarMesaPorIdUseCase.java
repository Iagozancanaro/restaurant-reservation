package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;

public interface BuscarMesaPorIdUseCase {

    public Mesa execute(Long id);
}
