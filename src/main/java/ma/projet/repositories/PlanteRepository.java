package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.Plante;


@Repository
public interface PlanteRepository extends JpaRepository<Plante, Long>{

}
