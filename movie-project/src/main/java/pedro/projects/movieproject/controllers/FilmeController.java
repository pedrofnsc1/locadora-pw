package pedro.projects.movieproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.projects.movieproject.models.Filme;
import pedro.projects.movieproject.services.FilmeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/filme")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public List<Filme> listAll(){
        return filmeService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return filmeService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Filme insert(@RequestBody Filme filme){
        return filmeService.save(filme);
    }

    @PutMapping(path = "/{id}")
     public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Filme filme){
        return filmeService.findById(id)
                .map(record -> {
                    filmeService.saveAndFlush(filme);
                    return ResponseEntity.ok().body(filme);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return filmeService.findById(id)
                .map(record -> {
                    filmeService.delete(record);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
