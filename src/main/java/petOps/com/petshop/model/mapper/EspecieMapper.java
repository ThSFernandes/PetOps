package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.especie.EspecieCreateDTO;
import petOps.com.petshop.model.dtos.especie.EspecieDTO;
import petOps.com.petshop.model.entity.Especie;

@Mapper(componentModel = "spring")
public interface EspecieMapper {

    EspecieDTO toDto(Especie especie);

    @Mapping(target = "idEspecie", ignore = true)
    Especie toEntity(EspecieCreateDTO especieCreateDTO);

}
