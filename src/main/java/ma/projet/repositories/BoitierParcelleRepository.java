package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.BoitierParcelle;


@Repository
public interface BoitierParcelleRepository extends JpaRepository<BoitierParcelle, Long>{

}
