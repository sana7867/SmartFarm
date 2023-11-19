package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.Agriculture;

@Repository
public interface AgricultureRepository extends JpaRepository<Agriculture, Long> {

}
