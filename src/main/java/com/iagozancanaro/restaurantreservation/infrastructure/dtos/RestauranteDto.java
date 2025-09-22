package com.iagozancanaro.restaurantreservation.infrastructure.dtos;

import java.util.List;

public record RestauranteDto(Long id,
                             String nome,
                             String endereco,
                             String telefone,
                             Integer capacidadeTotal,
                             List<MesaDto> mesas){}
