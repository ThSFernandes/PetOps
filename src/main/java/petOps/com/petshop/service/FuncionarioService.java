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

import javax.management.InstanceNotFoundException;
import javax.swing.text.html.parser.Entity;
import java.util.Optional;


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

        log.info("Funcionário criado com sucesso. ID={}", funcionario.getId_funcionario());

        return funcionarioMapper.toDto(funcionario);
    }

    public FuncionarioDTO buscarFuncionario(Long id_funcionario) {
        return funcionarioRepository.findById(id_funcionario)
                .map(funcionario -> {
                    log.info("Funcionário encontrado. ID = {}", id_funcionario);
                    return funcionarioMapper.toDto(funcionario);

                }).orElseThrow(() -> {
                    log.warn("Funcionário não encontrado. ID = {}", id_funcionario);
                    return new EntityNotFoundException("Funcionário com id = " + id_funcionario + " não encontrado");
                });
    }

    public void deletarFuncionario(Long id_funcionario){

        if(!funcionarioRepository.existsById(id_funcionario)){
            log.warn("Funcionário com ID = {}, não encontrado", id_funcionario);
            throw new EntityNotFoundException("Funcionário com id = " + id_funcionario + " não encontrado");
        }

        funcionarioRepository.deleteById(id_funcionario);
        log.info("Funcionário deletado com sucesso. ID = {}", id_funcionario);
    }

    public FuncionarioDTO atualizarFuncionario(Long id_funcionario,FuncionarioCreateDTO funcionarioCreateDTO ){
        Funcionario funcionarioAtualizar = getFuncionarioById(id_funcionario);

        funcionarioAtualizar.setNome_funcionario(funcionarioCreateDTO.getNome_funcionario());
        funcionarioAtualizar.setTelefone(funcionarioCreateDTO.getTelefone());
        funcionarioAtualizar.setFuncao(funcionarioCreateDTO.getFuncao());
        funcionarioAtualizar.setCrmv(funcionarioCreateDTO.getCrmv());

        funcionarioRepository.save(funcionarioAtualizar);

        return funcionarioMapper.toDto(funcionarioAtualizar);
    }

    public Funcionario getFuncionarioById(Long id_funcionario){
        return funcionarioRepository.findById(id_funcionario).orElseThrow(
                () -> new EntityNotFoundException("Funcionário com id = " + id_funcionario + " não encontrado")
        );
    }

}
