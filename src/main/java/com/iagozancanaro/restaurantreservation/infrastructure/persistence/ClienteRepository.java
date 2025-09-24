package com.iagozancanaro.restaurantreservation.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
