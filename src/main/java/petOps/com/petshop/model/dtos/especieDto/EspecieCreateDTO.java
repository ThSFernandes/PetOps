package petOps.com.petshop.model.dtos.especieDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspecieCreateDTO {
    private Long idEspecie;

    private String nomeEspecie;
}
