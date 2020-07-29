package pedro.projects.movieproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.projects.movieproject.models.Categoria;
import pedro.projects.movieproject.services.CategoriaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> getAll(){
        return categoriaService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return categoriaService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.findById(id)
                .map(record -> {
                    categoriaService.saveAndFlush(categoria);
                    return ResponseEntity.ok().body(categoria);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return categoriaService.findById(id)
                .map(record ->{
                    categoriaService.delete(record);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
