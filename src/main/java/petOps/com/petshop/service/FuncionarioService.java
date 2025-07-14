package petOps.com.petshop.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import petOps.com.petshop.model.dtos.FuncionarioCreateDTO;
import petOps.com.petshop.model.dtos.FuncionarioDTO;
import petOps.com.petshop.model.entity.Funcionario;
import petOps.com.petshop.model.mapper.FuncionarioMapper;
import petOps.com.petshop.repository.FuncionarioRepository;


@Service
@RequiredArgsConstructor
@Slf4j
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioDTO criarFuncionario(FuncionarioCreateDTO funcionarioCreateDTO){
        log.info("Iniciando criação do funcionário");

        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioCreateDTO);
        funcionario = funcionarioRepository.save(funcionario);

        log.info("Funcionário criado com sucesso. ID={}", funcionario.getIdFuncionario());

        return funcionarioMapper.toDto(funcionario);
    }

    public FuncionarioDTO buscarFuncionarioPorNome(String nomeFuncionario) {
        log.info("Iniciando busca do funcionário por nome: {}", nomeFuncionario);
        Funcionario funcionario = funcionarioRepository
                .findByNomeFuncionario(nomeFuncionario)
                .orElseThrow(() -> {
                    log.warn("Funcionário não encontrado: {}", nomeFuncionario);
                    return new EntityNotFoundException("Funcionário com nome = " + nomeFuncionario + " não encontrado");
                });

        return funcionarioMapper.toDto(funcionario);
    }


    public FuncionarioDTO buscarFuncionario(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario)
                .map(funcionario -> {
                    log.info("Funcionário encontrado. ID = {}", idFuncionario);
                    return funcionarioMapper.toDto(funcionario);

                }).orElseThrow(() -> {
                    log.warn("Funcionário não encontrado. ID = {}", idFuncionario);
                    return new EntityNotFoundException("Funcionário com id = " + idFuncionario + " não encontrado");
                });
    }

    public void deletarFuncionario(Long idFuncionario){

        if(!funcionarioRepository.existsById(idFuncionario)){
            log.warn("Funcionário com ID = {}, não encontrado", idFuncionario);
            throw new EntityNotFoundException("Funcionário com id = " + idFuncionario + " não encontrado");
        }

        funcionarioRepository.deleteById(idFuncionario);
        log.info("Funcionário deletado com sucesso. ID = {}", idFuncionario);
    }

    public FuncionarioDTO atualizarFuncionario(Long idFuncionario, FuncionarioCreateDTO funcionarioCreateDTO ){
        Funcionario funcionarioAtualizar = buscarFuncionarioById(idFuncionario);

        funcionarioAtualizar.setNomeFuncionario(funcionarioCreateDTO.getNomeFuncionario());
        funcionarioAtualizar.setTelefone(funcionarioCreateDTO.getTelefone());
        funcionarioAtualizar.setFuncao(funcionarioCreateDTO.getFuncao());
        funcionarioAtualizar.setCrmv(funcionarioCreateDTO.getCrmv());

        funcionarioRepository.save(funcionarioAtualizar);

        return funcionarioMapper.toDto(funcionarioAtualizar);
    }

    public Funcionario buscarFuncionarioById(Long idFuncionario){
        return funcionarioRepository.findById(idFuncionario).orElseThrow(
                () -> new EntityNotFoundException("Funcionário com id = " + idFuncionario + " não encontrado")
        );
    }

}
