package petOps.com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petOps.com.petshop.model.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
