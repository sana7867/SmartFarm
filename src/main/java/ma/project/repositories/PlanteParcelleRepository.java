package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.PlanteParcelle;

@Repository
public interface PlanteParcelleRepository extends JpaRepository<PlanteParcelle, Long>{

}
