package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.enums.FuncaoFuncionario;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FUNCIONARIO")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_funcionario")
    @SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funcionario", allocationSize = 1)
    @Column(name = "ID_FUNCIONARIO")
    private Long idFuncionario;

    @Column(name = "NOME_FUNCIONARIO", nullable = false)
    private String nomeFuncionario;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "FUNCAO")
    private FuncaoFuncionario funcao;

    @Column(name = "CRMV", nullable = true, unique = true)
    private String crmv;

}
