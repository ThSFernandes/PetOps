package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RACA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Raca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_raca")
    @SequenceGenerator(name = "seq_raca", sequenceName = "seq_raca", allocationSize = 1)
    @Column(name = "ID_RACA")
    private Long idRaca;

    @Column(name = "NOME_RACA")
    private String nomeRaca;

    @ManyToOne
    @JoinColumn(name = "ID_ESPECIE", referencedColumnName = "ID_ESPECIE")
    private Especie especie;

}
