package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import petOps.com.petshop.model.dtos.servicoDto.ServicoCreateDTO;
import petOps.com.petshop.model.dtos.servicoDto.ServicoDTO;
import petOps.com.petshop.service.ServicoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/servico")
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ServicoDTO> buscarServicoPorId(@PathVariable("id") Long idServico) {
        ServicoDTO servicoDTO = servicoService.buscarServico(idServico);
        return new ResponseEntity<>(servicoDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> buscarTodosServicos() {
        return ResponseEntity.ok(servicoService.buscarTodosServicos());
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> criarServico(@RequestBody ServicoCreateDTO servicoCreateDTO){
        ServicoDTO servicoDTO = servicoService.criarServico(servicoCreateDTO);
        return new ResponseEntity<>(servicoDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ServicoDTO> atualizarServico(@PathVariable ("id") Long idServico, @RequestBody ServicoCreateDTO servicoAtualizar){
        ServicoDTO servicoDTO = servicoService.atualizarServico(idServico, servicoAtualizar);
        return new ResponseEntity<>(servicoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable("id") Long idServico){
        servicoService.deletarServico(idServico);
        return ResponseEntity.noContent().build();
    }
}
