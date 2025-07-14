package petOps.com.petshop.model.dtos.enderecoDto;

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

    private String numeroCasa;

    private String complemento;

    private String cidade;

    private String estado;
}
