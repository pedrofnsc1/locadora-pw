package pedro.projects.movieproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.projects.movieproject.models.Cliente;
import pedro.projects.movieproject.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public Cliente save(Cliente cliente){ return clienteRepo.save(cliente); }

    public Cliente saveAndFlush(Cliente cliente){ return clienteRepo.saveAndFlush(cliente); }

    public void delete(Cliente cliente){ clienteRepo.delete(cliente); }

    public List<Cliente> getAll(){ return clienteRepo.findAll(); }

    public Cliente getOne(Long id){
        return clienteRepo
                .findById(id)
                .orElse(null);
    }

    public Optional<Cliente> findById(Long id){ return clienteRepo.findById(id); }


}
