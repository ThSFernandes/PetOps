package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Agendamento;
import petOps.com.petshop.model.entity.Funcionario;

import java.util.Optional;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<Agendamento> findByNomePet(String nomePet);
}
