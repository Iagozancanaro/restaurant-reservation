package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;

public interface AtualizarStatusMesaUseCase {

    public Mesa execute(Long id, StatusMesa novoStatus);

}
