package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TUTOR")

public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tutor")
    @SequenceGenerator(name = "seq_tutor", sequenceName = "seq_tutor", allocationSize = 1)
    private Long idTutor;

    @Column(name = "NOME_TUTOR", nullable = false)
    private String nomeTutor;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "tutores", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Endereco> enderecos;


}
