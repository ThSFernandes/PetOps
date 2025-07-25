package petOps.com.petshop.model.dtos.servicoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoCreateDTO{

    private Long idServico;

    private String nomeServico;

    private Double valor;
}
