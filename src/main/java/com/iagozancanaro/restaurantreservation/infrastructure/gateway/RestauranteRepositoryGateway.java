package com.iagozancanaro.restaurantreservation.infrastructure.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.core.gateway.RestauranteGateway;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.RestauranteEntityMapper;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.RestauranteEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestauranteRepositoryGateway implements RestauranteGateway {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;

    @Override
    public Restaurante salvar(Restaurante restaurante) {
        RestauranteEntity entity = restauranteEntityMapper.toEntity(restaurante);
        RestauranteEntity novoRestaurante = restauranteRepository.save(entity);
        return restauranteEntityMapper.toDomain(novoRestaurante);
    }

    @Override
    public Optional<Restaurante> buscarPorId(Long id) {
        return restauranteRepository.findById(id)
                .map(restauranteEntityMapper::toDomain);
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll()
                .stream()
                .map(restauranteEntityMapper::toDomain)
                .toList();
    }
}
