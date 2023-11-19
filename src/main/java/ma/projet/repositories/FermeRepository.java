package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.Ferme;




@Repository
public interface FermeRepository extends JpaRepository<Ferme, Long> {

}
