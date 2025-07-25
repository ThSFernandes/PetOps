package petOps.com.petshop.model.dtos.racaDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.entity.Especie;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RacaCreateDTO {
    private Long idRaca;

    private String nomeRaca;

    private Especie especie;
}
