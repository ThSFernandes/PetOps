package petOps.com.petshop.model.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO {
    private Long id_servico;

    private String nome_servico;

    private Double valor;

}
