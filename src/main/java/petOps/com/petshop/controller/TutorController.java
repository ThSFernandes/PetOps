package petOps.com.petshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petOps.com.petshop.model.dtos.tutorDto.TutorCreateDTO;
import petOps.com.petshop.model.dtos.tutorDto.TutorDTO;
import petOps.com.petshop.service.TutorService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/tutor")
public class TutorController {

    private final TutorService tutorService;

    @GetMapping("id/{id}")
    public ResponseEntity<TutorDTO> buscarTutorPorId(@PathVariable("id") Long idTutor){
        TutorDTO tutorDTO = tutorService.buscarTutor(idTutor);
        return new ResponseEntity<>(tutorDTO, HttpStatus.OK);
    }

    @GetMapping("nome/{nomeTutor}")
    public ResponseEntity<TutorDTO> buscarTutorPorNomedoTutor(@PathVariable("nomeTutor") String nomeTutor){
        TutorDTO tutorDTO = tutorService.buscarTutoresPorNome(nomeTutor);
        return new ResponseEntity<>(tutorDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TutorDTO>> buscarTodosTutors() {
        return ResponseEntity.ok(tutorService.buscarTodosTutores());
    }

    @PostMapping
    public ResponseEntity<TutorDTO> criarTutor(@RequestBody TutorCreateDTO tutorCreateDTO){
        TutorDTO tutorDTO = tutorService.criarTutor(tutorCreateDTO);
        return new ResponseEntity<>(tutorDTO, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<TutorDTO> atualizarTutor(@PathVariable ("id") Long idTutor, @RequestBody TutorCreateDTO tutorAtualizar){
        TutorDTO tutorDTO = tutorService.atualizarTutor(idTutor, tutorAtualizar);
        return new ResponseEntity<>(tutorDTO, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarTutor(@PathVariable("id") Long idTutor){
        tutorService.deletarTutor(idTutor);
        return ResponseEntity.noContent().build();
    }
}
