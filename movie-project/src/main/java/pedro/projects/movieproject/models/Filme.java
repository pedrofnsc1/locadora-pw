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
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   String titulo;
   String diretor;
   String perfilImdb;
   String anoLancamento;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "filme_id")
   List<Categoria> categorias;
}
