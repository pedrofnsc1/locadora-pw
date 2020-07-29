package pedro.projects.movieproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pedro.projects.movieproject.models.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
