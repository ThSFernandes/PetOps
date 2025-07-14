package petOps.com.petshop.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.enderecoDto.EnderecoCreateDTO;
import petOps.com.petshop.model.dtos.enderecoDto.EnderecoDTO;
import petOps.com.petshop.model.entity.Endereco;
import petOps.com.petshop.model.mapper.EnderecoMapper;
import petOps.com.petshop.repository.EnderecoRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    public EnderecoDTO criarEndereco(EnderecoCreateDTO enderecoCreateDTO){
        log.info("Iniciando criação do endereço");

        Endereco endereco = enderecoMapper.toEntity(enderecoCreateDTO);
        endereco = enderecoRepository.save(endereco);

        log.info("Endereço criado com sucesso. ID={}", endereco.getIdEndereco());

        return enderecoMapper.toDto(endereco);
    }

    public EnderecoDTO buscarEndereco(Long idEndereco){
        return enderecoRepository.findById(idEndereco)
                .map(endereco -> {
                    log.info("Endereço encontrado; ID={}", idEndereco);
                    return enderecoMapper.toDto(endereco);
                }).orElseThrow(() -> {
                    log.warn("Endereço não encontrado. ID={}", idEndereco);
                    return new EntityNotFoundException("Endereço com id = " + idEndereco + " não encontrado");
                });
    }

    public EnderecoDTO atualizarEndereco(Long idEndereco, EnderecoCreateDTO enderecoCreateDTO){
        Endereco enderecoAtualizar = buscarEnderecoById(idEndereco);

        enderecoAtualizar.setLogradouro(enderecoCreateDTO.getLogradouro());
        enderecoAtualizar.setBairro(enderecoCreateDTO.getBairro());
        enderecoAtualizar.setNumeroCasa(enderecoCreateDTO.getNumeroCasa());
        enderecoAtualizar.setComplemento(enderecoCreateDTO.getComplemento());
        enderecoAtualizar.setCidade(enderecoCreateDTO.getCidade());
        enderecoAtualizar.setEstado(enderecoCreateDTO.getEstado());
        enderecoAtualizar.setTutores(enderecoCreateDTO.getTutores());

        enderecoRepository.save(enderecoAtualizar);

        return enderecoMapper.toDto(enderecoAtualizar);
    }

    public void deletarEndereco(Long idEndereco){
        if (!enderecoRepository.existsById(idEndereco)){
            log.warn("Endereço com ID={}, não encontrado", idEndereco);
            throw new EntityNotFoundException("Endereço com id = " + idEndereco + " não encontrado");
        }

        enderecoRepository.deleteById(idEndereco);
        log.info("Endereço deletado com sucesso. ID={}", idEndereco);
    }

    public Endereco buscarEnderecoById(Long idEndereco){
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(
                        () -> new EntityNotFoundException("Endereço com id = " + idEndereco + " não encontrado")
                );
    }

}
