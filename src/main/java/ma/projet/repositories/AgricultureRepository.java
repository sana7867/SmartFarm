package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.Agriculture;


@Repository
public interface AgricultureRepository extends JpaRepository<Agriculture, Long> {

}
