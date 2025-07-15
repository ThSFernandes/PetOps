package petOps.com.petshop.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.petDto.PetCreateDTO;
import petOps.com.petshop.model.dtos.petDto.PetDTO;
import petOps.com.petshop.model.entity.Pet;
import petOps.com.petshop.model.mapper.PetMapper;
import petOps.com.petshop.repository.PetRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetService {

    private final PetRepository petRepository;
    private PetMapper petMapper;

    public PetDTO criarPet(PetCreateDTO petCreateDTO){
        log.info("Iniciando criação do pet");

        Pet pet = petMapper.toEntity(petCreateDTO);
        pet = petRepository.save(pet);

        log.info("Pet criado com sucesso. ID={}", pet.getIdPet());

        return petMapper.toDto(pet);
    }

    public PetDTO buscarPet(Long idPet){
        return petRepository.findById(idPet)
                .map( pet -> {
                    log.info("Pet encontrado; ID={}", idPet);
                    return petMapper.toDto(pet);
                }).orElseThrow(() -> {
                    log.warn("Pet não encontrado. ID={}", idPet);
                    return new EntityNotFoundException("Pet com id = " + idPet + " não encontrado");
                });
    }

    public PetDTO buscarPetPorNome(String nomePet){
        log.info("Iniciando busca por nome do pet: {}", nomePet);
        Pet pet = petRepository
                .findByNomePet(nomePet)
                .orElseThrow( () -> {
                    log.warn("Pet não encontrado: {}", nomePet);
                    return new EntityNotFoundException("Pet com nome = " + nomePet + " , não encontrado");
                });
        return petMapper.toDto(pet);
    }

    public PetDTO atualizarPet(Long idPet, PetCreateDTO petCreateDTO){
        Pet petAtualizar = buscarPetById(idPet);

        petAtualizar.setNomePet(petCreateDTO.getNomePet());
        petAtualizar.setPorte(petCreateDTO.getPorte());
        petAtualizar.setSexoPet(petCreateDTO.getSexoPet());
        petAtualizar.setDataNascimento(petCreateDTO.getDataNascimento());
        petAtualizar.setTutores(petCreateDTO.getTutores());
        petAtualizar.setIdEspecie(petCreateDTO.getIdEspecie());
        petAtualizar.setIdRaca(petCreateDTO.getIdRaca());

        petRepository.save(petAtualizar);

        return petMapper.toDto(petAtualizar);
    }

    public void deletarPet(Long idPet){
        if(!petRepository.existsById(idPet)){
            log.warn("Pet com ID={}, não encontrado", idPet);
            throw new EntityNotFoundException("Pet com id = " + idPet + " não encontrado");
        }

        petRepository.deleteById(idPet);
        log.info("Pet deletado com sucesso. ID={}", idPet);
    }

    public Pet buscarPetById(Long idPet){
        return petRepository.findById(idPet)
                .orElseThrow(
                        () -> new EntityNotFoundException("Pet com id = " + idPet + " não encontrado")
                );
    }
}
