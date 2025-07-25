package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petOps.com.petshop.model.dtos.racaDto.RacaCreateDTO;
import petOps.com.petshop.model.dtos.racaDto.RacaDTO;
import petOps.com.petshop.service.RacaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/raca")
public class RacaController {

    private final RacaService racaService;

    @GetMapping("/id/{id}")
    public ResponseEntity<RacaDTO> buscarRacaPorId(@PathVariable("id") Long idRaca) {
        RacaDTO racaDTO = racaService.buscarRaca(idRaca);
        return new ResponseEntity<>(racaDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RacaDTO>> buscarTodosRacas() {
        return ResponseEntity.ok(racaService.buscarTodosRacas());
    }

    @PostMapping
    public ResponseEntity<RacaDTO> criarRaca(@RequestBody RacaCreateDTO racaCreateDTO){
        RacaDTO racaDTO = racaService.criarRaca(racaCreateDTO);
        return new ResponseEntity<>(racaDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<RacaDTO> atualizarRaca(@PathVariable ("id") Long idRaca, @RequestBody RacaCreateDTO racaAtualizar){
        RacaDTO racaDTO = racaService.atualizarRaca(idRaca, racaAtualizar);
        return new ResponseEntity<>(racaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarRaca(@PathVariable("id") Long idRaca){
        racaService.deletarRaca(idRaca);
        return ResponseEntity.noContent().build();
    }
}
