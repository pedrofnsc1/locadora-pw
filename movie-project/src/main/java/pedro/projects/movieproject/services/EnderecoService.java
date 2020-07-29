package pedro.projects.movieproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.projects.movieproject.models.Endereco;
import pedro.projects.movieproject.repositories.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    EnderecoRepository enderecoRepo;

    public EnderecoService(EnderecoRepository enderecoRepo) {
        this.enderecoRepo = enderecoRepo;
    }

    public Endereco save(Endereco endereco){
        return enderecoRepo.save(endereco);
    }

    public Endereco saveAndFlush(Endereco endereco){ return enderecoRepo.saveAndFlush(endereco); }

    public void delete(Endereco endereco){
        enderecoRepo.delete(endereco);
    }

    public List<Endereco> getAll(){
        return enderecoRepo.findAll();
    }

    public Endereco getOne(Long id){
        return enderecoRepo
                .findById(id)
                .orElse(null);
    }

    public Optional<Endereco> findById(Long id){
        return enderecoRepo.findById(id);
    }
}
