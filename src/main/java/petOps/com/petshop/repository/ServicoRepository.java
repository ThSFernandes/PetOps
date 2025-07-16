package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
