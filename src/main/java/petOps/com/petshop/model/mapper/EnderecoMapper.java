package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.EnderecoCreateDTO;
import petOps.com.petshop.model.dtos.EnderecoDTO;
import petOps.com.petshop.model.entity.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoDTO toDto(Endereco endereco);

    @Mapping(target = "id_endereco", ignore = true)
    Endereco toEntity(EnderecoCreateDTO enderecoCreateDTO);
}
