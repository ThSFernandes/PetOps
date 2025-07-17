package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.petDto.PetCreateDTO;
import petOps.com.petshop.model.dtos.raca.RacaCreateDTO;
import petOps.com.petshop.model.dtos.raca.RacaDTO;
import petOps.com.petshop.model.entity.Pet;
import petOps.com.petshop.model.entity.Raca;

@Mapper(componentModel = "spring")
public interface RacaMapper {
    RacaDTO toDto(Raca raca);

    @Mapping(target = "idRaca", ignore = true)
    Raca toEntity(RacaCreateDTO racaCreateDTO);
}
