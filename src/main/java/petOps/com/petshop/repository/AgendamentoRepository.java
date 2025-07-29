package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Agendamento;


import java.util.List;



public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByPet_NomePet(String nomePet);

}
