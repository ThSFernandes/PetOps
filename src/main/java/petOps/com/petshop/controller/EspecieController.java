package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petOps.com.petshop.model.dtos.especie.EspecieCreateDTO;
import petOps.com.petshop.model.dtos.especie.EspecieDTO;
import petOps.com.petshop.service.EspecieService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/especie")
public class EspecieController {

    private final EspecieService especieService;

    @GetMapping("/id/{id}")
    public ResponseEntity<EspecieDTO> buscarEspeciePorId(@PathVariable("id") Long idEspecie) {
        EspecieDTO especieDTO = especieService.buscarEspecie(idEspecie);
        return new ResponseEntity<>(especieDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EspecieDTO>> buscarTodosEspecies() {
        return ResponseEntity.ok(especieService.buscarTodosEspecies());
    }

    @PostMapping
    public ResponseEntity<EspecieDTO> criarEspecie(@RequestBody EspecieCreateDTO especieCreateDTO){
        EspecieDTO especieDTO = especieService.criarEspecie(especieCreateDTO);
        return new ResponseEntity<>(especieDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<EspecieDTO> atualizarEspecie(@PathVariable ("id") Long idEspecie, @RequestBody EspecieCreateDTO especieAtualizar){
        EspecieDTO especieDTO = especieService.atualizarEspecie(idEspecie, especieAtualizar);
        return new ResponseEntity<>(especieDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarEspecie(@PathVariable("id") Long idEspecie){
        especieService.deletarEspecie(idEspecie);
        return ResponseEntity.noContent().build();
    }
}
