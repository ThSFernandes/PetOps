package petOps.com.petshop.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoCreateDTO {

    private Long idEndereco;

    private String logradouro;

    private String bairro;

    private String numero_casa;

    private String complemento;

    private String cidade;

    private String estado;
}
