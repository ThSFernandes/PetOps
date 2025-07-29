package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.petDto.PetCreateDTO;
import petOps.com.petshop.model.dtos.petDto.PetDTO;
import petOps.com.petshop.model.entity.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetDTO toDto(Pet pet);

    @Mapping(target = "tutores", ignore = true)
    @Mapping(target = "idPet", ignore = true)
    Pet toEntity(PetCreateDTO petCreateDTO);
}
