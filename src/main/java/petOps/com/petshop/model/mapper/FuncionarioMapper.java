package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.FuncionarioCreateDTO;
import petOps.com.petshop.model.dtos.FuncionarioDTO;
import petOps.com.petshop.model.entity.Funcionario;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioDTO toDto(Funcionario funcionario);

    @Mapping(target = "id_funcionario", ignore = true)
    Funcionario toEntity(FuncionarioCreateDTO funcionarioCreateDTO);

}
