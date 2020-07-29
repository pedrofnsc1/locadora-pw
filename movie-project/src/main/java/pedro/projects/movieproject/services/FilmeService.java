package pedro.projects.movieproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.projects.movieproject.models.Cliente;
import pedro.projects.movieproject.models.Filme;
import pedro.projects.movieproject.repositories.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    FilmeRepository filmeRepo;


    public FilmeService(FilmeRepository filmeRepo) {
        this.filmeRepo = filmeRepo;
    }

    public Filme save(Filme filme){ return filmeRepo.save(filme); }

    public Filme saveAndFlush(Filme filme){ return filmeRepo.saveAndFlush(filme); }

    public void delete(Filme filme){ filmeRepo.delete(filme); }

    public List<Filme> getAll(){ return filmeRepo.findAll(); }

    public Filme getOne(Long id){
        return filmeRepo
                .findById(id)
                .orElse(null);
    }

    public Optional<Filme> findById(Long id){ return filmeRepo.findById(id); }



}