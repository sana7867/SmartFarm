package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.Parcelle;

@Repository
public interface ParcelleRepository extends JpaRepository<Parcelle, Long> {

}
