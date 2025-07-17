package petOps.com.petshop.model.dtos.raca;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.entity.Especie;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RacaDTO {
    private String nomeRaca;

    private Especie especie;
}
