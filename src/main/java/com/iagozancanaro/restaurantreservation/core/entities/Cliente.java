package com.iagozancanaro.restaurantreservation.core.entities;

public record Cliente(Long id,
                      String nome,
                      String email,
                      String telefone) {}
