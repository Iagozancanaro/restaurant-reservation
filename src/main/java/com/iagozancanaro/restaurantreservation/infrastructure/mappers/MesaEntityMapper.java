package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.RestauranteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MesaEntityMapper {

    MesaEntity toEntity(Mesa mesa);

    default Mesa toDomain(MesaEntity mesaEntity) {
        return new Mesa(
                mesaEntity.getId(),
                mesaEntity.getNumero(),
                mesaEntity.getCapacidade(),
                mesaEntity.getStatus(),
                mesaEntity.getRestaurante() != null ? mesaEntity.getRestaurante().getId() : null
        );
    }

    default MesaEntity toEntity(Mesa mesa, RestauranteEntity restaurante) {
        MesaEntity entity = new MesaEntity();
        entity.setNumero(mesa.numero());
        entity.setCapacidade(mesa.capacidade());
        entity.setStatus(mesa.status());
        entity.setRestaurante(restaurante);
        return entity;
    }

}
