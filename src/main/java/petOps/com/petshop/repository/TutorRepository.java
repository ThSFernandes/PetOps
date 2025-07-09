package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
