package petOps.com.petshop.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petOps.com.petshop.model.entity.Funcionario;
import petOps.com.petshop.model.entity.Pet;
import petOps.com.petshop.model.entity.Servico;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoCreateDTO {

    private Long id_agendamento;

    private LocalDate data_marcada;

    private String status;

    private String observacoes;

    private Pet pet;

    private Funcionario funcionario_veterinario;

    private Funcionario funcionario_groomer;

    private Set<ServicoDTO> servicos_adicionais;
}
