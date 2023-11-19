package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.BoitierParcelle;

@Repository
public interface BoitierParcelleRepository extends JpaRepository<BoitierParcelle, Long>{

}
