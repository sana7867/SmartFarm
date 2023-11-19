package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.Mesure;


@Repository
public interface MesureRepository extends JpaRepository<Mesure, Long>{

}
