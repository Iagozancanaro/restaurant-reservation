package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;

import java.util.List;

public class ListarMesasUseCaseImp implements ListarMesasUseCase {

    private final MesaGateway mesaGateway;

    public ListarMesasUseCaseImp(MesaGateway mesaGateway) {
        this.mesaGateway = mesaGateway;
    }

    @Override
    public List<Mesa> execute() {
        return mesaGateway.listarMesas();
    }
}
