package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;

public class CriarMesaUseCaseImp implements CriarMesaUseCase {

    private final MesaGateway mesaGateway;

    public CriarMesaUseCaseImp(MesaGateway mesaGateway) {
        this.mesaGateway = mesaGateway;
    }

    @Override
    public Mesa execute(Mesa mesa) {
        return mesaGateway.salvar(mesa);
    }
}
