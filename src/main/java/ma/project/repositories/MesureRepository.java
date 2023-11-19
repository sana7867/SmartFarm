package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.Mesure;

@Repository
public interface MesureRepository extends JpaRepository<Mesure, Long>{

}
