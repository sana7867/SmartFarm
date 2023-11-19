package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.Plante;

@Repository
public interface PlanteRepository extends JpaRepository<Plante, Long>{

}
