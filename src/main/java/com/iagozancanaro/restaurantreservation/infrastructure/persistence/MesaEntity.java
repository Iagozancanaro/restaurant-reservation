package com.iagozancanaro.restaurantreservation.infrastructure.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mesa")
public class MesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    private StatusMesa status;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    @OneToMany(mappedBy = "mesa")
    @JsonIgnore
    private List<ReservaEntity> reservas;

}
