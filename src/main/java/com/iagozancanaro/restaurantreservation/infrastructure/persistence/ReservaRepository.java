package com.iagozancanaro.restaurantreservation.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

}
