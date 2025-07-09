package petOps.com.petshop.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioCreateDTO {

    private Long id_funcionario;

    private String nome_funcionario;

    private String telefone;

    private String funcao;

    private String crmv;
}
