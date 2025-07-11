package petOps.com.petshop.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.entity.Funcionario;
import petOps.com.petshop.model.entity.Pet;
import petOps.com.petshop.model.entity.Servico;
import petOps.com.petshop.model.enums.StatusAgendamento;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoCreateDTO {

    private Long idAgendamento;

    private LocalDate dataMarcada;

    private StatusAgendamento status;

    private String observacoes;

    private Pet pet;

    private Funcionario funcionarioVeterinario;

    private Funcionario funcionarioGroomer;

    private Set<ServicoDTO> servicosAdicionais;
}
