package petOps.com.petshop.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.dtos.servicoDto.ServicoCreateDTO;
import petOps.com.petshop.model.enums.StatusAgendamento;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AGENDAMENTO")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_agendamento")
    @SequenceGenerator(name = "seq_agendamento", sequenceName = "seq_agendamento", allocationSize = 1)
    @Column(name = "ID_AGENDAMENTO")
    private Long idAgendamento;

    @Column(name = "DATA_MARCADA", nullable = false)
    private LocalDate dataMarcada;

    @Column(name = "STATUS", nullable = false)
    private StatusAgendamento status;

    @Column(name = "OBSERVACOES", nullable = true)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "ID_PET", referencedColumnName = "ID_PET")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_VETERINARIO", referencedColumnName = "ID_FUNCIONARIO")
    private Funcionario funcionarioVeterinario;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_GROOMER", referencedColumnName = "ID_FUNCIONARIO")
    private Funcionario funcionarioGroomer;

    @ManyToMany
    @JoinTable(
            name = "AGENDAMENTO_SERVICO_ADICIONAL",
            joinColumns = @JoinColumn(name = "ID_AGENDAMENTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_SERVICO")
    )
    private Set<Servico> servicosAdicionais;

}
