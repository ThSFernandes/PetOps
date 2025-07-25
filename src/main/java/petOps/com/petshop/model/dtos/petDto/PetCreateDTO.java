package petOps.com.petshop.model.dtos.petDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.dtos.tutorDto.TutorDTO;
import petOps.com.petshop.model.entity.Especie;
import petOps.com.petshop.model.entity.Raca;
import petOps.com.petshop.model.enums.PortePet;
import petOps.com.petshop.model.enums.SexoPet;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDTO{

    private Long idPet;

    private String nomePet;

    private PortePet porte;

    private SexoPet sexoPet;

    private LocalDate dataNascimento;

    private Set<Long> idTutores;

    private Especie idEspecie;

    private Raca idRaca;

}
