package com.iagozancanaro.restaurantreservation.infrastructure.presentation;

import com.iagozancanaro.restaurantreservation.core.entities.Reserva;
import com.iagozancanaro.restaurantreservation.core.usecases.reserva.*;
import com.iagozancanaro.restaurantreservation.infrastructure.dtos.ReservaDto;
import com.iagozancanaro.restaurantreservation.infrastructure.mappers.ReservaDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/reservas")
public class ReservaController {

    private final AtualizarStatusReservaUseCase atualizarStatusReservaUseCase;
    private final BuscarReservaPorIdUseCase buscarReservaPorIdUseCase;
    private final CancelarReservaUseCase cancelarReservaUseCase;
    private final CriarReservaUseCase criarReservaUseCase;
    private final ListarReservasUseCase listarReservasUseCase;
    private final ReservaDtoMapper reservaDtoMapper;

    public ReservaController(AtualizarStatusReservaUseCase atualizarStatusReservaUseCase, BuscarReservaPorIdUseCase buscarReservaPorIdUseCase, CancelarReservaUseCase cancelarReservaUseCase, CriarReservaUseCase criarReservaUseCase, ListarReservasUseCase listarReservasUseCase, ReservaDtoMapper reservaDtoMapper) {
        this.atualizarStatusReservaUseCase = atualizarStatusReservaUseCase;
        this.buscarReservaPorIdUseCase = buscarReservaPorIdUseCase;
        this.cancelarReservaUseCase = cancelarReservaUseCase;
        this.criarReservaUseCase = criarReservaUseCase;
        this.listarReservasUseCase = listarReservasUseCase;
        this.reservaDtoMapper = reservaDtoMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarReserva(@RequestBody ReservaDto reservaDto) {
        Reserva novaReserva = criarReservaUseCase.execute(reservaDtoMapper.toDomain(reservaDto));
        Map<String, Object> response = Map.of(
                "mensagem", "Reserva cadastrada com sucesso no nosso banco de dados",
                "dadosDaReserva", reservaDtoMapper.toDto(novaReserva)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> buscarReservaPorId(@PathVariable Long id) {
        Reserva reserva = buscarReservaPorIdUseCase.execute(id);
        return ResponseEntity.ok(reservaDtoMapper.toDto(reserva));
    }

    @GetMapping
    public ResponseEntity<List<ReservaDto>> listarReservas() {
        List<ReservaDto> reservasDto = listarReservasUseCase.execute().stream()
                .map(reservaDtoMapper::toDto)
                .toList();

        return ResponseEntity.ok(reservasDto);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ReservaDto> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        Reserva reservaAtualizada = atualizarStatusReservaUseCase.execute(id, Enum.valueOf(com.iagozancanaro.restaurantreservation.core.enums.StatusReserva.class, status.toUpperCase()));
        return ResponseEntity.ok(reservaDtoMapper.toDto(reservaAtualizada));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Map<String, Object>> cancelarReserva(@PathVariable Long id) {
        Reserva reservaCancelada = cancelarReservaUseCase.execute(id);
        Map<String, Object> response = Map.of(
                "mensagem", "Reserva cancelada com sucesso",
                "reserva", reservaDtoMapper.toDto(reservaCancelada)
        );
        return ResponseEntity.ok(response);
    }
}
