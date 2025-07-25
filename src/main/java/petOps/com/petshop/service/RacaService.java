package petOps.com.petshop.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.racaDto.RacaCreateDTO;
import petOps.com.petshop.model.dtos.racaDto.RacaDTO;
import petOps.com.petshop.model.entity.Raca;
import petOps.com.petshop.model.mapper.RacaMapper;
import petOps.com.petshop.repository.RacaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RacaService {
    private final RacaRepository racaRepository;
    private final RacaMapper racaMapper;

    public RacaDTO criarRaca(RacaCreateDTO racaCreateDTO){
        log.info("Iniciando criação da espécie");

        Raca raca = racaMapper.toEntity(racaCreateDTO);
        raca = racaRepository.save(raca);

        log.info("Raça criado com sucesso. ID={}", raca.getIdRaca());

        return racaMapper.toDto(raca);
    }

    public RacaDTO buscarRaca(Long idRaca){
        return racaRepository.findById(idRaca)
                .map(raca -> {
                    log.info("Raça encontrada; ID={}", idRaca);
                    return racaMapper.toDto(raca);
                }).orElseThrow(() -> {
                    log.warn("Raça não encontrada. ID={}", idRaca);
                    return new EntityNotFoundException("Raça com id = " + idRaca + " não encontrada");
                });
    }

    public List<RacaDTO> buscarTodosRacas(){
        return racaRepository.findAll()
                .stream()
                .map(racaMapper::toDto)
                .toList();
    }

    public RacaDTO atualizarRaca(Long idRaca, RacaCreateDTO racaCreateDTO){
        Raca racaAtualizar = buscarRacaById(idRaca);

        racaAtualizar.setNomeRaca(racaCreateDTO.getNomeRaca());
        racaAtualizar.setEspecie(racaCreateDTO.getEspecie());

        racaRepository.save(racaAtualizar);

        return racaMapper.toDto(racaAtualizar);
    }

    public void deletarRaca(Long idRaca){
        if (!racaRepository.existsById(idRaca)){
            log.warn("Raça com ID={}, não encontrada", idRaca);
            throw new EntityNotFoundException("Raça com id = " + idRaca + " não encontrada");
        }

        racaRepository.deleteById(idRaca);
        log.info("Raça deletada com sucesso. ID={}", idRaca);
    }

    public Raca buscarRacaById(Long idRaca){
        return racaRepository.findById(idRaca)
                .orElseThrow(
                        () -> new EntityNotFoundException("Raça com id = " + idRaca + " não encontrada")
                );
    }
}
