package pedro.projects.movieproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String dataPedido;
    private String horaPedido;
    private String descricao;


    @ManyToMany
    @JoinTable(
            name = "pedido_filme",
            joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "filme_id")
    )
    List<Filme> filmes;
}
