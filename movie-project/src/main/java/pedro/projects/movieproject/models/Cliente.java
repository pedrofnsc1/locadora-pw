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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String pnome;
    String unome;
    String email;
    Integer telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pedido> pedidos;

}
