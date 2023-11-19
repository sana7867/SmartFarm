package ma.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.project.Entities.Limite;

@Repository
public interface LimiteRepository extends JpaRepository<Limite, Long> {

}
