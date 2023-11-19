package ma.projet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.entities.Limite;

@Repository
public interface LimiteRepository extends JpaRepository<Limite, Long> {

}
