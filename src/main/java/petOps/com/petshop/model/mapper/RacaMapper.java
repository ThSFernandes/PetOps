package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.racaDto.RacaCreateDTO;
import petOps.com.petshop.model.dtos.racaDto.RacaDTO;
import petOps.com.petshop.model.entity.Raca;

@Mapper(componentModel = "spring")
public interface RacaMapper {
    RacaDTO toDto(Raca raca);

    @Mapping(target = "idRaca", ignore = true)
    Raca toEntity(RacaCreateDTO racaCreateDTO);
}
