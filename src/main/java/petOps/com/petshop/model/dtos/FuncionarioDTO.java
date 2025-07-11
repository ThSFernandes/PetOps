package petOps.com.petshop.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private String nome_funcionario;

    private String telefone;

    private String funcao;

    private String crmv;

}
