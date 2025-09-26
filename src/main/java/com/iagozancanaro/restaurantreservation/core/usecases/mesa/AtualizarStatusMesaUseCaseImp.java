package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;

public class AtualizarStatusMesaUseCaseImp implements AtualizarStatusMesaUseCase {

    private final MesaGateway mesaGateway;

    public AtualizarStatusMesaUseCaseImp(MesaGateway mesaGateway) {
        this.mesaGateway = mesaGateway;
    }

    @Override
    public Mesa execute(Long id, StatusMesa novoStatus) {
        return mesaGateway.atualizarStatus(id, novoStatus);
    }
}
