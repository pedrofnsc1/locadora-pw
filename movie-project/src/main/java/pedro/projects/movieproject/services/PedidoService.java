package pedro.projects.movieproject.services;

import org.apache.tomcat.jni.Error;
import org.springframework.stereotype.Service;
import pedro.projects.movieproject.models.Pedido;
import pedro.projects.movieproject.repositories.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    PedidoRepository pedidoRepo;

    public PedidoService(PedidoRepository pedidoRepo) {
        this.pedidoRepo = pedidoRepo;
    }

    public Pedido save(Pedido pedido){ return pedidoRepo.save(pedido); }

    public Pedido saveAndFlush(Pedido pedido){ return pedidoRepo.saveAndFlush(pedido); }

    public void delete(Pedido pedido){ pedidoRepo.delete(pedido); }

    public List<Pedido> getAll(){ return pedidoRepo.findAll(); }

    public Pedido getOne(Long id){
        return pedidoRepo
                .findById(id)
                .orElse(null);
    }

    public Optional<Pedido>   findById(Long id){
        return pedidoRepo.findById(id);
    }



}
