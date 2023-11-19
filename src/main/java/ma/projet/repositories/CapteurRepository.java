package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.Capteur;

@Repository
public interface CapteurRepository extends  JpaRepository<Capteur, Long>{

}
