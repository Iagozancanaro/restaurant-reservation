package com.iagozancanaro.restaurantreservation.infrastructure.presentation;

import com.iagozancanaro.restaurantreservation.core.entities.Cliente;
import com.iagozancanaro.restaurantreservation.core.usecases.cliente.BuscarClientePorIdUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.cliente.CriarClienteUseCase;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.ClienteDto;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.ClienteDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;
    private final CriarClienteUseCase criarClienteUseCase;
    private final ClienteDtoMapper clienteDtoMapper;

    public ClienteController(BuscarClientePorIdUseCase buscarClientePorIdUseCase, CriarClienteUseCase criarClienteUseCase, ClienteDtoMapper clienteDtoMapper) {
        this.buscarClientePorIdUseCase = buscarClientePorIdUseCase;
        this.criarClienteUseCase = criarClienteUseCase;
        this.clienteDtoMapper = clienteDtoMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarCliente(@RequestBody ClienteDto clienteDto) {
        Cliente novoCliente = criarClienteUseCase.execute(clienteDtoMapper.toDomain(clienteDto));
        Map<String, Object> response = Map.of(
                "mensagem", "Cliente cadastrado com sucesso no nosso banco de dados",
                "dadosDoCliente", clienteDtoMapper.toDto(novoCliente)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = buscarClientePorIdUseCase.execute(id);
        return ResponseEntity.ok(clienteDtoMapper.toDto(cliente));
    }

}
