package petOps.com.petshop.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.tutorDto.TutorCreateDTO;
import petOps.com.petshop.model.dtos.tutorDto.TutorDTO;
import petOps.com.petshop.model.entity.Tutor;
import petOps.com.petshop.model.mapper.TutorMapper;
import petOps.com.petshop.repository.TutorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TutorService {

    private final TutorRepository tutorRepository;
    private final TutorMapper tutorMapper;

    public TutorDTO criarTutor(TutorCreateDTO tutorCreateDTO){
        log.info("Iniciando criação do tutor");

        Tutor tutor = tutorMapper.toEntity(tutorCreateDTO);
        tutor = tutorRepository.save(tutor);

        log.info("Tutor criado com sucesso. ID={}", tutor.getIdTutor());

        return tutorMapper.toDto(tutor);
    }

    public TutorDTO buscarTutor(Long idTutor){
        return tutorRepository.findById(idTutor)
                .map( tutor -> {
                    log.info("Tutor encontrado. ID={}", idTutor);
                    return tutorMapper.toDto(tutor);
                }).orElseThrow(() -> {
                    log.warn("Tutor não encontrado. ID={}", idTutor);
                    return new EntityNotFoundException("Tutor com id = " + idTutor + " não encontrado");
                });
    }

    public List<TutorDTO> buscarTodosTutores(){
        return tutorRepository.findAll()
                .stream()
                .map(tutorMapper::toDto)
                .toList();
    }

    public TutorDTO buscarTutoresPorNome(String nomeTutor){
        log.info("Iniciando busca por nome do tutor: {}", nomeTutor);
        Tutor tutor = tutorRepository.findByNomeTutor(nomeTutor)
                .orElseThrow(() -> {
                    log.warn("Tutor não encontrado: {}", nomeTutor);
                    return new EntityNotFoundException("Tutor com nome = " + nomeTutor + " , não encontrado");
                });
        return tutorMapper.toDto(tutor);
    }

    public  TutorDTO atualizarTutor(Long idTutor, TutorCreateDTO tutorCreateDTO){
        Tutor tutorAtualizar = buscarTutorById(idTutor);

        tutorAtualizar.setNomeTutor(tutorCreateDTO.getNomeTutor());
        tutorAtualizar.setCpf(tutorCreateDTO.getCpf());
        tutorAtualizar.setTelefone(tutorCreateDTO.getTelefone());
        tutorAtualizar.setEmail(tutorCreateDTO.getEmail());
        tutorAtualizar.setDataNascimento(tutorCreateDTO.getDataNascimento());

        tutorRepository.save(tutorAtualizar);

        return tutorMapper.toDto(tutorAtualizar);
    }

    public void deletarTutor(Long idTutor){
        if(!tutorRepository.existsById(idTutor)){
            log.warn("Tutor com ID = {}, não encontrado", idTutor);
            throw new EntityNotFoundException("Tutor com id = " + idTutor + " não encontrado");
        }

        tutorRepository.deleteById(idTutor);
        log.info("Tutor deletado com sucesso. ID = {}", idTutor);
    }

    public Tutor buscarTutorById(Long idTutor){
        return tutorRepository.findById(idTutor)
                .orElseThrow(
                        () -> new EntityNotFoundException("Tutor com id = " + idTutor + " não encontrado")
                );
    }

}
