package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.MesaDto;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MesaEntityMapper {

    MesaEntity toEntity(Mesa mesa);

    Mesa toDomain(MesaEntity mesaEntity);
}
