package petOps.com.petshop.model.dtos.funcionarioDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.enums.FuncaoFuncionario;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioCreateDTO {

    private Long idFuncionario;

    private String nomeFuncionario;

    private String telefone;

    private FuncaoFuncionario funcao;

    private String crmv;
}
