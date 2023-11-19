package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.Entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
