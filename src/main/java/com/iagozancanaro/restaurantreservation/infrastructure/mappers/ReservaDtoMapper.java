package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.ReservaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaDtoMapper {

    ReservaDto toDto(Reserva reserva);

    Reserva toDomain(ReservaDto dto);
}
