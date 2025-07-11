package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.enums.PortePet;
import petOps.com.petshop.model.enums.SexoPet;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "PET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pet")
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet", allocationSize = 1)
    private Long idPet;

    @Column(name = "NOME_PET")
    private String nomePet;

    @Enumerated(EnumType.STRING)
    @Column(name = "PORTE")
    private PortePet porte;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private SexoPet sexoPet;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @ManyToMany
    @JoinTable(name = "PET_TUTOR",
            joinColumns        = @JoinColumn(name = "ID_PET"),
            inverseJoinColumns = @JoinColumn(name = "ID_TUTOR"))
    private Set<Tutor> tutores;

    @ManyToOne
    @JoinColumn(name = "ID_ESPECIE", referencedColumnName = "ID_ESPECIE")
    private Especie idEspecie;

    @ManyToOne
    @JoinColumn(name = "ID_RACA", referencedColumnName = "ID_RACA")
    private Raca idRaca;

}
