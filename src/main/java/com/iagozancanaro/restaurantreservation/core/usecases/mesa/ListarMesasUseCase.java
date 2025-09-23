package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;

import java.util.List;

public interface ListarMesasUseCase {

    public List<Mesa> execute();
}
