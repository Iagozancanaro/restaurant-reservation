package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.exceptions.NotFoundException;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;

public class BuscarMesaPorIdUseCaseImp implements BuscarMesaPorIdUseCase {

    private final MesaGateway mesaGateway;

    public BuscarMesaPorIdUseCaseImp(MesaGateway mesaGateway) {
        this.mesaGateway = mesaGateway;
    }

    @Override
    public Mesa execute(Long id) {
        return mesaGateway.buscarPorId(id)
                .orElseThrow(() -> new NotFoundException("Mesa com ID " + id + " não encontrada"));
    }
}
