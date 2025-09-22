package com.iagozancanaro.restaurantreservation.core.entities;

public record Restaurante(Long id,
                          String nome,
                          String endereco,
                          String telefone,
                          Integer capacidadeTotal) {}
