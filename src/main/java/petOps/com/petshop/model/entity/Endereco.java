package petOps.com.petshop.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1)
    private Long id_endereco;

    @Column(name = "LONGRADOURO", nullable = false)
    private String longradouro;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    @Column(name = "NUMERO_CASA", nullable = false)
    private String numero_casa;

    @Column(name = "COMPLEMENTO", nullable = false)
    private String complemento;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ID_TUTOR", referencedColumnName = "ID_TUTOR")
    private Tutor tutor;
}
