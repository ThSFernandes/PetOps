package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.tutorDto.TutorCreateDTO;
import petOps.com.petshop.model.dtos.tutorDto.TutorDTO;
import petOps.com.petshop.model.entity.Tutor;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class})
public interface TutorMapper {

    @Mapping(target = "enderecos", source = "enderecos")
    TutorDTO toDto(Tutor tutor);

    @Mapping(target = "idTutor", ignore = true)
    @Mapping(target = "enderecos", source = "enderecos")
    Tutor toEntity(TutorCreateDTO tutorCreateDTO);
}
