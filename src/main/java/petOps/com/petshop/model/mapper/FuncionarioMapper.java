package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.funcionarioDto.FuncionarioCreateDTO;
import petOps.com.petshop.model.dtos.funcionarioDto.FuncionarioDTO;
import petOps.com.petshop.model.entity.Funcionario;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioDTO toDto(Funcionario funcionario);

    @Mapping(target = "idFuncionario", ignore = true)
    Funcionario toEntity(FuncionarioCreateDTO funcionarioCreateDTO);

}
