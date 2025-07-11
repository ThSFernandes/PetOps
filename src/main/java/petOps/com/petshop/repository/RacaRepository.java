package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long> {
}
