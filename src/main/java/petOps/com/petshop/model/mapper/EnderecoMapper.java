package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.enderecoDto.EnderecoCreateDTO;
import petOps.com.petshop.model.dtos.enderecoDto.EnderecoDTO;
import petOps.com.petshop.model.entity.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "idTutor", ignore = true)
    EnderecoDTO toDto(Endereco endereco);

    @Mapping(target = "idEndereco", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    Endereco toEntity(EnderecoCreateDTO enderecoCreateDTO);
}
