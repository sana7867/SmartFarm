package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.Boitier;
@Repository
public interface BoitierRepository extends JpaRepository<Boitier, Long>{

}
