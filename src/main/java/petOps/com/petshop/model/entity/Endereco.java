package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1)
    private Long idEndereco;

    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    @Column(name = "NUMERO_CASA", nullable = false)
    private String numero_casa;

    @Column(name = "COMPLEMENTO", nullable = true)
    private String complemento;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ID_TUTOR", referencedColumnName = "ID_TUTOR")
    private Tutor tutores;
}
