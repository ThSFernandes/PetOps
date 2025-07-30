package petOps.com.petshop.model.dtos.petDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.dtos.especieDto.EspecieDTO;
import petOps.com.petshop.model.dtos.racaDto.RacaDTO;
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
public class PetDTO {

    private String nomePet;

    private PortePet porte;

    private SexoPet sexoPet;

    private LocalDate dataNascimento;

    private Set<TutorDTO> tutores;

    private EspecieDTO especie;

    private RacaDTO raca;
}
