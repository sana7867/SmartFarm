package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.Parcelle;


@Repository
public interface ParcelleRepository extends JpaRepository<Parcelle, Long> {

}
