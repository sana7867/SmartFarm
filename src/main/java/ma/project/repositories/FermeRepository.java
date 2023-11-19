package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.Ferme;

@Repository
public interface FermeRepository extends JpaRepository<Ferme, Long> {

}
