package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ClienteEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ReservaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaEntityMapper {

    default ReservaEntity toEntity(Reserva reserva, ClienteEntity cliente, MesaEntity mesa) {
        ReservaEntity entity = new ReservaEntity();
        entity.setDataHora(reserva.dataHora());
        entity.setStatus(reserva.status());
        entity.setCliente(cliente);
        entity.setMesa(mesa);
        return entity;
    }

    default Reserva toDomain(ReservaEntity entity) {
        return new Reserva(
                entity.getId(),
                entity.getDataHora(),
                entity.getCliente() != null ? entity.getCliente().getId() : null,
                entity.getMesa() != null ? entity.getMesa().getId() : null,
                entity.getStatus()
        );
    }

    default ReservaEntity toEntity(Reserva reserva) {
        ReservaEntity entity = new ReservaEntity();
        entity.setDataHora(reserva.dataHora());
        entity.setStatus(reserva.status());

        return entity;
    }
}
