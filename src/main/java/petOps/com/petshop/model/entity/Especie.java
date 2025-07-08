package petOps.com.petshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "ESPECIE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_especie")
    @SequenceGenerator(name = "seq_especie", sequenceName = "seq_especie", allocationSize = 1)
    private Long id;

    @Column(name = "NOME_ESPECIE")
    private String nomeEspecie;

}
