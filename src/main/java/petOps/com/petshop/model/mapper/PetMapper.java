package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.petDto.PetCreateDTO;
import petOps.com.petshop.model.dtos.petDto.PetDTO;
import petOps.com.petshop.model.entity.Especie;
import petOps.com.petshop.model.entity.Pet;
import petOps.com.petshop.model.entity.Raca;
import petOps.com.petshop.model.entity.Tutor;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetDTO toDto(Pet pet);

    @Mapping(target = "idPet", ignore = true)
    @Mapping(target = "especie", source = "idEspecie")
    @Mapping(target = "raca", source = "idRaca")
    @Mapping(target = "tutores", source = "idTutores")
    Pet toEntity(PetCreateDTO petCreateDTO);

    default Especie map(Long idEspecie) {
        if (idEspecie == null) return null;
        Especie especie = new Especie();
        especie.setIdEspecie(idEspecie);
        return especie;
    }

    default Raca mapRaca(Long idRaca) {
        if (idRaca == null) return null;
        Raca raca = new Raca();
        raca.setIdRaca(idRaca);
        return raca;
    }

    default Set<Tutor> mapTutores(Set<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            Tutor tutor = new Tutor();
            tutor.setIdTutor(id);
            return tutor;
        }).collect(java.util.stream.Collectors.toSet());
    }
}
