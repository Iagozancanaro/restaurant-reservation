package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntity toEntity(Cliente cliente);

    Cliente toDomain(ClienteEntity clienteEntity);
}
