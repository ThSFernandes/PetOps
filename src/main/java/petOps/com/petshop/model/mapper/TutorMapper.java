package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.tutorDto.TutorCreateDTO;
import petOps.com.petshop.model.dtos.tutorDto.TutorDTO;
import petOps.com.petshop.model.entity.Tutor;

@Mapper(componentModel = "spring")
public interface TutorMapper {

    TutorDTO toDto(Tutor tutor);

    @Mapping(target = "idTutor", ignore = true)
    Tutor toEntity(TutorCreateDTO TutorCreateDTO);

}
