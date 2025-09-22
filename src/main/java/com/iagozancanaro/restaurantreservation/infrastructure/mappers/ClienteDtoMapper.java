package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.ClienteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {

    ClienteDto toDto(Cliente cliente);

    Cliente toDomain(ClienteDto dto);
}
