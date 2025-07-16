package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.servicoDto.ServicoCreateDTO;
import petOps.com.petshop.model.dtos.servicoDto.ServicoDTO;
import petOps.com.petshop.model.entity.Servico;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    ServicoDTO toDto(Servico servico);

    @Mapping(target = "idServico", ignore = true)
    Servico toEntity(ServicoCreateDTO servicoCreateDTO);
}
