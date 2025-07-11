package petOps.com.petshop.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.AgendamentoCreateDTO;
import petOps.com.petshop.model.dtos.AgendamentoDTO;
import petOps.com.petshop.model.entity.Agendamento;
import petOps.com.petshop.model.mapper.AgendamentoMapper;
import petOps.com.petshop.repository.AgendamentoRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoMapper agendamentoMapper;

    public AgendamentoDTO criarAgendamento(AgendamentoCreateDTO agendamentoCreateDTO){
        log.info("Iniciando criação do agendamento");

        Agendamento agendamento = agendamentoMapper.toEntity(agendamentoCreateDTO);
        agendamento = agendamentoRepository.save(agendamento);

        log.info("Agendamento criado com sucesso. ID={}", agendamento.getIdAgendamento());

        return agendamentoMapper.toDto(agendamento);
    }

    public AgendamentoDTO buscarAgendamento(Long idAgendamento){
        return agendamentoRepository.findById(idAgendamento)
                .map( agendamento -> {
                    log.info("Agendamento encontrado. ID = {}", idAgendamento);
                    return agendamentoMapper.toDto(agendamento);
                }).orElseThrow(() -> {
                    log.warn("Agendamento não encontrado. ID = {}", idAgendamento);
                    return new EntityNotFoundException("Agendamento com id = " + idAgendamento + " não encontrado");
                });
    }

    public AgendamentoDTO buscarAgendamentoPorNomePet(String nomePet){
        log.info("Inciando busca do agendamento por nome do pet: {}", nomePet);
        Agendamento agendamento = agendamentoRepository
                .findByNomePet(nomePet)
                .orElseThrow(() -> {
                    log.warn("Agendamento não encontrado: {}", nomePet);
                    return new EntityNotFoundException("Agendamento com nome do pet = " + nomePet + " , não encontrado");
                });
        return agendamentoMapper.toDto(agendamento);
    }

    public AgendamentoDTO atualizarAgendamento(Long idAgendamento, AgendamentoCreateDTO agendamentoCreateDTO){
        Agendamento agendamentoAtualizar = buscarAgendamentoById(idAgendamento);

        agendamentoAtualizar.setDataMarcada(agendamentoCreateDTO.getDataMarcada());
        agendamentoAtualizar.setStatus(agendamentoCreateDTO.getStatus());
        agendamentoAtualizar.setObservacoes(agendamentoCreateDTO.getObservacoes());
        agendamentoAtualizar.setPet(agendamentoCreateDTO.getPet());
        agendamentoAtualizar.setFuncionarioVeterinario(agendamentoCreateDTO.getFuncionarioVeterinario());
        agendamentoAtualizar.setFuncionarioGroomer(agendamentoCreateDTO.getFuncionarioGroomer());

        agendamentoRepository.save(agendamentoAtualizar);

        return agendamentoMapper.toDto(agendamentoAtualizar);
    }

    public void deletarAgendamento(Long idAgendamento){
        if(!agendamentoRepository.existsById(idAgendamento)){
            log.warn("Agendamento com ID = {}, não encontrado", idAgendamento);
            throw new EntityNotFoundException("Agendamento com id = " + idAgendamento + " não encontrado");
        }

        agendamentoRepository.deleteById(idAgendamento);
        log.info("Agendamento deletado com sucesso. ID = {}", idAgendamento);
    }

    public Agendamento buscarAgendamentoById(Long idAgendamento){
        return agendamentoRepository.findById(idAgendamento)
                .orElseThrow(
                        () -> new EntityNotFoundException("Agendamento com id = " + idAgendamento + " não encontrado")
                );
    }



}
