package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.ServicoCreateDTO;
import petOps.com.petshop.model.dtos.ServicoDTO;
import petOps.com.petshop.model.entity.Servico;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    ServicoDTO toDto(Servico servico);

    @Mapping(target = "id_servico", ignore = true)
    Servico toEntity(ServicoCreateDTO servicoCreateDTO);
}
