package com.iagozancanaro.restaurantreservation.infrastructure.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.enums.StatusReserva;
import com.iagozancanaro.restaurantreservation.core.gateway.ReservaGateway;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.ReservaEntityMapper;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReservaRepositoryGateway implements ReservaGateway {

    private final ReservaRepository reservaRepository;
    private final ReservaEntityMapper reservaEntityMapper;
    private final ClienteRepository clienteRepository;
    private final MesaRepository mesaRepository;

    @Override
    public Reserva salvar(Reserva reserva, Long clienteId, Long mesaId) {
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        MesaEntity mesaEntity = mesaRepository.findById(mesaId)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        ReservaEntity entity = reservaEntityMapper.toEntity(reserva);
        entity.setCliente(clienteEntity);
        entity.setMesa(mesaEntity);

        ReservaEntity novaReserva = reservaRepository.save(entity);
        return reservaEntityMapper.toDomain(novaReserva);
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .map(reservaEntityMapper::toDomain);
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(reservaEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Reserva atualizarStatus(Long id, StatusReserva novoStatus) {
        ReservaEntity entity = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        entity.setStatus(novoStatus);
        ReservaEntity atualizada = reservaRepository.save(entity);
        return reservaEntityMapper.toDomain(atualizada);
    }

    @Override
    public Reserva cancelarReserva(Long id) {
        return atualizarStatus(id, StatusReserva.CANCELADA);
    }
}
