package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.RestauranteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestauranteDtoMapper {

    RestauranteDto toDto(Restaurante restaurante);

    Restaurante toDomain(RestauranteDto dto);
}
