package pedro.projects.movieproject.services;

import org.apache.catalina.startup.Catalina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.projects.movieproject.models.Categoria;
import pedro.projects.movieproject.models.Cliente;
import pedro.projects.movieproject.models.Endereco;
import pedro.projects.movieproject.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    CategoriaRepository categoriaRepo;

    public CategoriaService(CategoriaRepository categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    public Categoria save(Categoria categoria){
        return categoriaRepo.save(categoria);
    }

    public Categoria saveAndFlush(Categoria categoria){ return categoriaRepo.saveAndFlush(categoria); }

    public void delete(Categoria categoria){ categoriaRepo.delete(categoria); }

    public List<Categoria> getAll(){ return categoriaRepo.findAll(); }

    public Categoria geOne(Long id){
        return categoriaRepo
                .findById(id)
                .orElse(null);
    }

    public Optional<Categoria> findById(Long id){ return categoriaRepo.findById(id); }




}
