package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.especieDto.EspecieCreateDTO;
import petOps.com.petshop.model.dtos.especieDto.EspecieDTO;
import petOps.com.petshop.model.entity.Especie;

@Mapper(componentModel = "spring")
public interface EspecieMapper {

    EspecieDTO toDto(Especie especie);

    @Mapping(target = "idEspecie", ignore = true)
    Especie toEntity(EspecieCreateDTO especieCreateDTO);

}
