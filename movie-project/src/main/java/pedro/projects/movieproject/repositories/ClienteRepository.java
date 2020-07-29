package pedro.projects.movieproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.projects.movieproject.models.Cliente;

import javax.persistence.criteria.CriteriaBuilder;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
