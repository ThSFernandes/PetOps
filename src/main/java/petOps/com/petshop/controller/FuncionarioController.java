package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petOps.com.petshop.model.dtos.funcionarioDto.FuncionarioCreateDTO;
import petOps.com.petshop.model.dtos.funcionarioDto.FuncionarioDTO;
import petOps.com.petshop.service.FuncionarioService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping("/id/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable("id") Long idFuncionario) {
        FuncionarioDTO funcionarioDTO = funcionarioService.buscarFuncionario(idFuncionario);
        return new ResponseEntity<>(funcionarioDTO, HttpStatus.OK);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioNome(@PathVariable("nome") String nomeFuncionario) {
        FuncionarioDTO funcionarioDTO = funcionarioService.buscarFuncionarioPorNome(nomeFuncionario);
        return new ResponseEntity<>(funcionarioDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> buscarTodosFuncionarios() {
        return ResponseEntity.ok(funcionarioService.buscarTodosFuncionarios());
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criarFuncionario(@RequestBody FuncionarioCreateDTO funcionarioCreateDTO){
        FuncionarioDTO funcionarioDTO = funcionarioService.criarFuncionario(funcionarioCreateDTO);
        return new ResponseEntity<>(funcionarioDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@PathVariable ("id") Long idFuncionario, @RequestBody FuncionarioCreateDTO funcionarioAtualizar){
        FuncionarioDTO funcionarioDTO = funcionarioService.atualizarFuncionario(idFuncionario, funcionarioAtualizar);
        return new ResponseEntity<>(funcionarioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarFuncinario(@PathVariable("id") Long idFuncionario){
        funcionarioService.deletarFuncionario(idFuncionario);
        return ResponseEntity.noContent().build();
    }

}
