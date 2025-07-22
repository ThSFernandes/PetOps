package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petOps.com.petshop.model.dtos.enderecoDto.EnderecoCreateDTO;
import petOps.com.petshop.model.dtos.enderecoDto.EnderecoDTO;
import petOps.com.petshop.service.EnderecoService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable("id") Long idEndereco) {
        EnderecoDTO enderecoDTO = enderecoService.buscarEndereco(idEndereco);
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

//    @GetMapping("/nome/{nome}")
//    public ResponseEntity<EnderecoDTO> buscarEnderecoNomeTutor(@PathVariable("nome") String nomeEndereco) {
//        EnderecoDTO enderecoDTO = enderecoService.bus(nomeEndereco);
//        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
//    }


    @PostMapping
    public ResponseEntity<EnderecoDTO> criarEndereco(@RequestBody EnderecoCreateDTO enderecoCreateDTO){
        EnderecoDTO enderecoDTO = enderecoService.criarEndereco(enderecoCreateDTO);
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<EnderecoDTO> atualizarEndereco(@PathVariable ("id") Long idEndereco, @RequestBody EnderecoCreateDTO enderecoAtualizar){
        EnderecoDTO enderecoDTO = enderecoService.atualizarEndereco(idEndereco, enderecoAtualizar);
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable("id") Long idEndereco){
        enderecoService.deletarEndereco(idEndereco);
        return ResponseEntity.noContent().build();
    }
}
