package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import petOps.com.petshop.model.dtos.petDto.PetCreateDTO;
import petOps.com.petshop.model.dtos.petDto.PetDTO;
import petOps.com.petshop.service.PetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/pet")
public class PetController {

    private final PetService petService;

    @GetMapping("/id/{id}")
    public ResponseEntity<PetDTO> buscarPetPorId(@PathVariable("id") Long idPet) {
        PetDTO petDTO = petService.buscarPet(idPet);
        return new ResponseEntity<>(petDTO, HttpStatus.OK);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<PetDTO> buscarPetNome(@PathVariable("nome") String nomePet) {
        PetDTO petDTO = petService.buscarPetPorNome(nomePet);
        return new ResponseEntity<>(petDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> buscarTodosPets() {
        return ResponseEntity.ok(petService.buscarTodosPets());
    }

    @PostMapping
    public ResponseEntity<PetDTO> criarPet(@RequestBody PetCreateDTO petCreateDTO){
        PetDTO petDTO = petService.criarPet(petCreateDTO);
        return new ResponseEntity<>(petDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<PetDTO> atualizarPet(@PathVariable ("id") Long idPet, @RequestBody PetCreateDTO petAtualizar){
        PetDTO petDTO = petService.atualizarPet(idPet, petAtualizar);
        return new ResponseEntity<>(petDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarPet(@PathVariable("id") Long idPet){
        petService.deletarPet(idPet);
        return ResponseEntity.noContent().build();
    }
}
