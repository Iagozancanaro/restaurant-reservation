package com.iagozancanaro.restaurantreservation.infrastructure.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.enums.StatusMesa;
import com.iagozancanaro.restaurantreservation.core.gateway.MesaGateway;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.MesaEntityMapper;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MesaRepositoryGateway implements MesaGateway {

    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;

    @Override
    public Mesa salvar(Mesa mesa) {
        MesaEntity entity = mesaEntityMapper.toEntity(mesa);
        MesaEntity novaMesa = mesaRepository.save(entity);
        return mesaEntityMapper.toDomain(novaMesa);
    }

    @Override
    public Optional<Mesa> buscarPorId(Long id) {
        return mesaRepository.findById(id)
                .map(mesaEntityMapper::toDomain);
    }

    @Override
    public List<Mesa> listarMesas() {
        return mesaRepository.findAll()
                .stream()
                .map(mesaEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Mesa atualizarStatus(Long id, StatusMesa status) {
        MesaEntity entity = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
        entity.setStatus(status);
        MesaEntity atualizada = mesaRepository.save(entity);
        return mesaEntityMapper.toDomain(atualizada);
    }
}
