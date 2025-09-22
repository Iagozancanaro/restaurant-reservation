package com.iagozancanaro.restaurantreservation.infrastructure.mappers;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.RestauranteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestauranteEntityMapper {

    RestauranteEntity toEntity(Restaurante restaurante);

    Restaurante toDomain(RestauranteEntity restauranteEntity);
}
