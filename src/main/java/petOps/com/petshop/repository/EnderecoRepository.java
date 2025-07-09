package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
