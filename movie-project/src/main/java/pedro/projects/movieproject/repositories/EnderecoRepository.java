package pedro.projects.movieproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.projects.movieproject.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
