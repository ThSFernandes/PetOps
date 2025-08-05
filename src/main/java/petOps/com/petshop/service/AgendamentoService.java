package petOps.com.petshop.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoCreateDTO;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoDTO;
import petOps.com.petshop.model.entity.Agendamento;
import petOps.com.petshop.model.entity.Funcionario;
import petOps.com.petshop.model.entity.Pet;
import petOps.com.petshop.model.entity.Servico;
import petOps.com.petshop.model.mapper.AgendamentoMapper;
import petOps.com.petshop.repository.AgendamentoRepository;
import petOps.com.petshop.repository.FuncionarioRepository;
import petOps.com.petshop.repository.PetRepository;
import petOps.com.petshop.repository.ServicoRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoMapper agendamentoMapper;
    private final PetRepository petRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ServicoRepository servicoRepository;

    public AgendamentoDTO criarAgendamento(AgendamentoCreateDTO dto) {
        log.info("Iniciando criação do agendamento");

        Pet pet = petRepository.findById(dto.getIdPet())
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        log.info("ID do pet no agendamento: {}", pet.getIdPet());

        Funcionario vet = funcionarioRepository.findById(dto.getIdVeterinario())
                .orElseThrow(() -> new RuntimeException("Veterinário não encontrado"));

        Funcionario groomer = funcionarioRepository.findById(dto.getIdGroomer())
                .orElseThrow(() -> new RuntimeException("Groomer não encontrado"));

        Set<Servico> servicos = dto.getIdsServicosAdicionais().stream()
                .map(id -> servicoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Serviço não encontrado: " + id)))
                .collect(Collectors.toSet());

        Agendamento agendamento = new Agendamento();
        agendamento.setDataMarcada(dto.getDataMarcada());
        agendamento.setStatus(dto.getStatus());
        agendamento.setObservacoes(dto.getObservacoes());
        agendamento.setPet(pet);
        agendamento.setFuncionarioVeterinario(vet);
        agendamento.setFuncionarioGroomer(groomer);
        agendamento.setServicosAdicionais(servicos);

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

    public List<AgendamentoDTO> buscarTodosAgendamentos(){
        return agendamentoRepository.findAll()
                .stream()
                .map(agendamentoMapper::toDto)
                .toList();
    }

    public List<AgendamentoDTO> buscarAgendamentoPorPet(String nomePet){
        log.info("Inciando busca do agendamento por nome do pet: {}", nomePet);
        List<Agendamento> agendamento = agendamentoRepository.findByPet_NomePet(nomePet);

        if(agendamento.isEmpty()){
            log.warn("Nenhum agendamento encontrado para o pet: {}", nomePet);
            throw new EntityNotFoundException("Nenhum agendamento encontrado para o pet com nome = " + nomePet);
        }

        return agendamento.stream()
                .map(agendamentoMapper::toDto)
                .toList();
    }

    public AgendamentoDTO atualizarAgendamento(Long idAgendamento, AgendamentoCreateDTO dto) {
        Agendamento agendamentoAtualizar = buscarAgendamentoById(idAgendamento);

        Pet pet = petRepository.findById(dto.getIdPet())
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        Funcionario vet = funcionarioRepository.findById(dto.getIdVeterinario())
                .orElseThrow(() -> new RuntimeException("Veterinário não encontrado"));

        Funcionario groomer = funcionarioRepository.findById(dto.getIdGroomer())
                .orElseThrow(() -> new RuntimeException("Groomer não encontrado"));

        Set<Servico> servicos = dto.getIdsServicosAdicionais().stream()
                .map(id -> servicoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Serviço não encontrado: " + id)))
                .collect(Collectors.toSet());

        agendamentoAtualizar.setDataMarcada(dto.getDataMarcada());
        agendamentoAtualizar.setStatus(dto.getStatus());
        agendamentoAtualizar.setObservacoes(dto.getObservacoes());
        agendamentoAtualizar.setPet(pet);
        agendamentoAtualizar.setFuncionarioVeterinario(vet);
        agendamentoAtualizar.setFuncionarioGroomer(groomer);
        agendamentoAtualizar.setServicosAdicionais(servicos);

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
