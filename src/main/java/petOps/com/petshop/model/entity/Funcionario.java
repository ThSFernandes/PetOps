package petOps.com.petshop.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_funcionario")
    @SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funcionario", allocationSize = 1)
    private Long id_funcionario;

    @Column(name = "NOME_FUNCIONARIO", nullable = false)
    private String nome_funcionario;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "FUNCAO", nullable = false)
    private String funcao;

    @Column(name = "CRMV", nullable = true)
    private String crmv;

}
