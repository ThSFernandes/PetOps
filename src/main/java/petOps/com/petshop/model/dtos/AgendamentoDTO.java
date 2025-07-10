package petOps.com.petshop.model.dtos;

import jakarta.persistence.*;
import petOps.com.petshop.model.entity.Funcionario;
import petOps.com.petshop.model.entity.Pet;
import petOps.com.petshop.model.entity.Servico;

import java.time.LocalDate;
import java.util.Set;

public class AgendamentoDTO {

    private LocalDate data_marcada;

    private String status;

    private String observacoes;

    private Pet pet;

    private Funcionario funcionario_veterinario;

    private Funcionario funcionario_groomer;

    private Set<Servico> servicos_adicionais;

}
