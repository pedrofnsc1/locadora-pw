package pedro.projects.movieproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.projects.movieproject.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
