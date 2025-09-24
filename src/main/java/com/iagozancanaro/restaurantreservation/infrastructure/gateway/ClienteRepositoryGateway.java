package com.iagozancanaro.restaurantreservation.infrastructure.gateway;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;
import com.iagozancanaro.restaurantreservation.core.gateway.ClienteGateway;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.ClienteEntityMapper;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ClienteEntity;
import com.iagozancanaro.restaurantreservation.infrastructure.persistence.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity entity = clienteEntityMapper.toEntity(cliente);
        ClienteEntity novoCliente = clienteRepository.save(entity);
        return clienteEntityMapper.toDomain(novoCliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(clienteEntityMapper::toDomain);
    }
}
