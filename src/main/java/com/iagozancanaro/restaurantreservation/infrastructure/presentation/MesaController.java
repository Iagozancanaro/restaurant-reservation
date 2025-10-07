package com.iagozancanaro.restaurantreservation.infrastructure.presentation;

import com.iagozancanaro.restaurantreservation.core.entities.Mesa;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.AtualizarStatusMesaUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.BuscarMesaPorIdUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.CriarMesaUseCase;
import com.iagozancanaro.restaurantreservation.core.usecases.mesa.ListarMesasUseCase;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.MesaDto;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.MesaDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/mesas")
public class MesaController {

    private final AtualizarStatusMesaUseCase atualizarStatusMesaUseCase;
    private final BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;
    private final CriarMesaUseCase criarMesaUseCase;
    private final ListarMesasUseCase listarMesasUseCase;
    private final MesaDtoMapper mesaDtoMapper;

    public MesaController(AtualizarStatusMesaUseCase atualizarStatusMesaUseCase, BuscarMesaPorIdUseCase buscarMesaPorIdUseCase, CriarMesaUseCase criarMesaUseCase, ListarMesasUseCase listarMesasUseCase, MesaDtoMapper mesaDtoMapper) {
        this.atualizarStatusMesaUseCase = atualizarStatusMesaUseCase;
        this.buscarMesaPorIdUseCase = buscarMesaPorIdUseCase;
        this.criarMesaUseCase = criarMesaUseCase;
        this.listarMesasUseCase = listarMesasUseCase;
        this.mesaDtoMapper = mesaDtoMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarMesa(@RequestBody MesaDto mesaDto) {
        Mesa novaMesa = criarMesaUseCase.execute(mesaDtoMapper.toDomain(mesaDto));
        Map<String, Object> response = Map.of(
                "mensagem", "Mesa cadastrada com sucesso no nosso banco de dados",
                "dadosDaMesa", mesaDtoMapper.toDto(novaMesa)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDto> buscarMesaPorId(@PathVariable Long id) {
        Mesa mesa = buscarMesaPorIdUseCase.execute(id);
        return ResponseEntity.ok(mesaDtoMapper.toDto(mesa));
    }

    @GetMapping
    public ResponseEntity<List<MesaDto>> listarMesas() {
        List<MesaDto> mesasDto = listarMesasUseCase.execute().stream()
                .map(mesaDtoMapper::toDto)
                .toList();

        return ResponseEntity.ok(mesasDto);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<MesaDto> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        Mesa mesaAtualizada = atualizarStatusMesaUseCase.execute(id, Enum.valueOf(com.iagozancanaro.restaurantreservation.core.enums.StatusMesa.class, status.toUpperCase()));
        return ResponseEntity.ok(mesaDtoMapper.toDto(mesaAtualizada));
    }
}
