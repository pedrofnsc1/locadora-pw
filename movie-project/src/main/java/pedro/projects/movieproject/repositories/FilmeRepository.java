package pedro.projects.movieproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.projects.movieproject.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
