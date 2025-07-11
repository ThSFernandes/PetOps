package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.enums.FuncaoFuncionario;
import petOps.com.petshop.model.enums.PortePet;

import java.time.LocalDate;
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
    private Long id_funcionario;

    @Column(name = "NOME_FUNCIONARIO", nullable = false)
    private String nome_funcionario;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "FUNCAO")
    private FuncaoFuncionario funcao;

    @Column(name = "CRMV", nullable = true, unique = true)
    private String crmv;

}
