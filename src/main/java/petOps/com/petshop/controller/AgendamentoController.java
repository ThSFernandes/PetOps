package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoCreateDTO;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoDTO;
import petOps.com.petshop.service.AgendamentoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @GetMapping("id/{id}")
    public ResponseEntity<AgendamentoDTO> buscarAgendamentoPorId(@PathVariable("id") Long idAgendamento){
        AgendamentoDTO agendamentoDTO = agendamentoService.buscarAgendamento(idAgendamento);
        return new ResponseEntity<>(agendamentoDTO, HttpStatus.OK);
    }

    @GetMapping("nome/{nomePet}")
    public ResponseEntity<List<AgendamentoDTO>> buscarAgendamentoPorNomedoPet(@PathVariable("nomePet") String nomePet){
        List<AgendamentoDTO> agendamentoDTO = agendamentoService.buscarAgendamentoPorPet(nomePet);
        return new ResponseEntity<>(agendamentoDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> buscarTodosAgendamentos() {
        return ResponseEntity.ok(agendamentoService.buscarTodosAgendamentos());
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> criarAgendamento(@RequestBody AgendamentoCreateDTO agendamentoCreateDTO){
        AgendamentoDTO agendamentoDTO = agendamentoService.criarAgendamento(agendamentoCreateDTO);
        return new ResponseEntity<>(agendamentoDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<AgendamentoDTO> atualizarAgendamento(@PathVariable ("id") Long idAgendamento, @RequestBody AgendamentoCreateDTO agendamentoAtualizar){
        AgendamentoDTO agendamentoDTO = agendamentoService.atualizarAgendamento(idAgendamento, agendamentoAtualizar);
        return new ResponseEntity<>(agendamentoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable("id") Long idAgendamento){
        agendamentoService.deletarAgendamento(idAgendamento);
        return ResponseEntity.noContent().build();
    }

}
