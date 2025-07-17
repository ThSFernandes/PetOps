package petOps.com.petshop.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.especie.EspecieCreateDTO;
import petOps.com.petshop.model.dtos.especie.EspecieDTO;
import petOps.com.petshop.model.entity.Especie;
import petOps.com.petshop.model.mapper.EspecieMapper;
import petOps.com.petshop.repository.EspecieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EspecieService {

    private final EspecieRepository especieRepository;
    private final EspecieMapper especieMapper;

    public EspecieDTO criarEspecie(EspecieCreateDTO especieCreateDTO){
        log.info("Iniciando criação da espécie");

        Especie especie = especieMapper.toEntity(especieCreateDTO);
        especie = especieRepository.save(especie);

        log.info("Espécie criado com sucesso. ID={}", especie.getIdEspecie());

        return especieMapper.toDto(especie);
    }

    public EspecieDTO buscarEspecie(Long idEspecie){
        return especieRepository.findById(idEspecie)
                .map(especie -> {
                    log.info("Espécie encontrada; ID={}", idEspecie);
                    return especieMapper.toDto(especie);
                }).orElseThrow(() -> {
                    log.warn("Espécie não encontrada. ID={}", idEspecie);
                    return new EntityNotFoundException("Espécie com id = " + idEspecie + " não encontrada");
                });
    }

    public List<EspecieDTO> buscarTodosEspecies(){
        return especieRepository.findAll()
                .stream()
                .map(especieMapper::toDto)
                .toList();
    }

    public EspecieDTO atualizarEspecie(Long idEspecie, EspecieCreateDTO especieCreateDTO){
        Especie especieAtualizar = buscarEspecieById(idEspecie);

        especieAtualizar.setNomeEspecie(especieCreateDTO.getNomeEspecie());

        especieRepository.save(especieAtualizar);

        return especieMapper.toDto(especieAtualizar);
    }

    public void deletarEspecie(Long idEspecie){
        if (!especieRepository.existsById(idEspecie)){
            log.warn("Espécie com ID={}, não encontrada", idEspecie);
            throw new EntityNotFoundException("Espécie com id = " + idEspecie + " não encontrada");
        }

        especieRepository.deleteById(idEspecie);
        log.info("Espécie deletada com sucesso. ID={}", idEspecie);
    }

    public Especie buscarEspecieById(Long idEspecie){
        return especieRepository.findById(idEspecie)
                .orElseThrow(
                        () -> new EntityNotFoundException("Espécie com id = " + idEspecie + " não encontrada")
                );
    }
}
