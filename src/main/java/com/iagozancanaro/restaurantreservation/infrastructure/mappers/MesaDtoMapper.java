package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.MesaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MesaDtoMapper {

    MesaDto toDto(Mesa mesa);

    Mesa toDomain(MesaDto dto);

}
