package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Long> {
}
