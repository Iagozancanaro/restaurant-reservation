package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ReservaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaEntityMapper {

    ReservaEntity toEntity(Reserva reserva);

    Reserva toDomain(ReservaEntity reservaEntity);
}
