package petOps.com.petshop.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.servicoDto.ServicoCreateDTO;
import petOps.com.petshop.model.dtos.servicoDto.ServicoDTO;
import petOps.com.petshop.model.entity.Servico;
import petOps.com.petshop.model.mapper.ServicoMapper;
import petOps.com.petshop.repository.ServicoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ServicoMapper servicoMapper;

    public ServicoDTO criarServico(ServicoCreateDTO servicoCreateDTO){
        log.info("Iniciando criação do serviço");

        Servico servico = servicoMapper.toEntity(servicoCreateDTO);
        servico = servicoRepository.save(servico);

        log.info("Serviço criado com sucesso. ID={}", servico.getIdServico());

        return servicoMapper.toDto(servico);
    }

    public ServicoDTO buscarServico(Long idServico){
        return servicoRepository.findById(idServico)
                .map(servico -> {
                    log.info("Serviço encontrado; ID={}", idServico);
                    return servicoMapper.toDto(servico);
                }).orElseThrow(() -> {
                    log.warn("Serviço não encontrado. ID={}", idServico);
                    return new EntityNotFoundException("Serviço com id = " + idServico + " não encontrado");
                });
    }

    public List<ServicoDTO> buscarTodosServicos(){
        return servicoRepository.findAll()
                .stream()
                .map(servicoMapper::toDto)
                .toList();
    }

    public ServicoDTO atualizarServico(Long idServico, ServicoCreateDTO servicoCreateDTO){
        Servico servicoAtualizar = buscarServicoById(idServico);

        servicoAtualizar.setNomeServico(servicoCreateDTO.getNomeServico());
        servicoAtualizar.setValor(servicoCreateDTO.getValor());

        servicoRepository.save(servicoAtualizar);

        return servicoMapper.toDto(servicoAtualizar);
    }

    public void deletarServico(Long idServico){
        if (!servicoRepository.existsById(idServico)){
            log.warn("Serviço com ID={}, não encontrado", idServico);
            throw new EntityNotFoundException("Serviço com id = " + idServico + " não encontrado");
        }

        servicoRepository.deleteById(idServico);
        log.info("Serviço deletado com sucesso. ID={}", idServico);
    }

    public Servico buscarServicoById(Long idServico){
        return servicoRepository.findById(idServico)
                .orElseThrow(
                        () -> new EntityNotFoundException("Serviço com id = " + idServico + " não encontrado")
                );
    }
}
