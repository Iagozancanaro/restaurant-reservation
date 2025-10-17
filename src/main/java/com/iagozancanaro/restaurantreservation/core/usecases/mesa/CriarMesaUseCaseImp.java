package com.iagozancanaro.restaurantreservation.core.usecases.mesa;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.core.exceptions.InvalidCapacityException;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;

public class CriarMesaUseCaseImp implements CriarMesaUseCase {

    private final MesaGateway mesaGateway;

    public CriarMesaUseCaseImp(MesaGateway mesaGateway) {
        this.mesaGateway = mesaGateway;
    }

    @Override
    public Mesa execute(Mesa mesa) {
        if (mesa.capacidade() <= 0) {
            throw new InvalidCapacityException("A capacidade total da mesa deve ser maior que 0");
        }
        Mesa mesaComStatus = mesa.comStatus(StatusMesa.LIVRE);

        return mesaGateway.salvar(mesaComStatus);
    }
}
