package com.iagozancanaro.restaurantreservation.infrastructure.presentation;

import com.iagozancanaro.restaurantreservation.core.entities.Restaurante;
import com.iagozancanaro.restaurantreservation.core.usecases.restaurante.BuscarRestaurantePorIdUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.restaurante.CriarRestauranteUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.restaurante.ListarRestaurantesUseCase;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.RestauranteDto;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.RestauranteDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/restaurantes")
public class RestauranteController {

    private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;
    private final CriarRestauranteUseCase criarRestauranteUseCase;
    private final ListarRestaurantesUseCase listarRestaurantesUseCase;
    private final RestauranteDtoMapper restauranteDtoMapper;

    public RestauranteController(BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase, CriarRestauranteUseCase criarRestauranteUseCase, ListarRestaurantesUseCase listarRestaurantesUseCase, RestauranteDtoMapper restauranteDtoMapper) {
        this.buscarRestaurantePorIdUseCase = buscarRestaurantePorIdUseCase;
        this.criarRestauranteUseCase = criarRestauranteUseCase;
        this.listarRestaurantesUseCase = listarRestaurantesUseCase;
        this.restauranteDtoMapper = restauranteDtoMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarRestaurante(@RequestBody RestauranteDto restauranteDto) {
        Restaurante novoRestaurante = criarRestauranteUseCase.execute(restauranteDtoMapper.toDomain(restauranteDto));
        Map<String, Object> response = Map.of(
                "mensagem", "Restaurante cadastrado com sucesso no nosso banco de dados",
                "dadosDaRestaurante", restauranteDtoMapper.toDto(novoRestaurante)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDto> buscarRestaurantePorId(@PathVariable Long id) {
        Restaurante restaurante = buscarRestaurantePorIdUseCase.execute(id);
        return ResponseEntity.ok(restauranteDtoMapper.toDto(restaurante));
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDto>> listarRestaurantes() {
        List<RestauranteDto> restaurantesDto = listarRestaurantesUseCase.execute().stream()
                .map(restauranteDtoMapper::toDto)
                .toList();

        return ResponseEntity.ok(restaurantesDto);
    }
}
