package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
