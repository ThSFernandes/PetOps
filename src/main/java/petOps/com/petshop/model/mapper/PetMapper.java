package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.PetCreateDTO;
import petOps.com.petshop.model.dtos.PetDTO;
import petOps.com.petshop.model.entity.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetDTO toDto(Pet pet);

    @Mapping(target = "id_pet", ignore = true)
    Pet toEntity(PetCreateDTO petCreateDTO);
}
