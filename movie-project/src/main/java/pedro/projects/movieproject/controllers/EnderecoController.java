package pedro.projects.movieproject.controllers;

import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.projects.movieproject.models.Endereco;
import pedro.projects.movieproject.services.EnderecoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listAll(){
        return enderecoService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return enderecoService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Endereco insert(@RequestBody Endereco endereco){
        return enderecoService.save(endereco);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id){
        return enderecoService.findById(id)
                .map(record -> {
                    enderecoService.saveAndFlush(record);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /*@DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return enderecoService.findById(id)
                .map(record -> {
                  enderecoService.delete(record);
                  return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }*/
}
