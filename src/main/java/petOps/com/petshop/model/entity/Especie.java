package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ESPECIE")
public class Especie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_especie")
    @SequenceGenerator(name = "seq_especie", sequenceName = "seq_especie", allocationSize = 1)
    private Long idEspecie;

    @Column(name = "NOME_ESPECIE")
    private String nomeEspecie;

}
