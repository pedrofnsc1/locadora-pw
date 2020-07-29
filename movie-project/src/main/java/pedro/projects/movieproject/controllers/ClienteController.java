package pedro.projects.movieproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.projects.movieproject.models.Cliente;
import pedro.projects.movieproject.services.ClienteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) { this.clienteService = clienteService; }

    @GetMapping
    public List<Cliente> listAll(){
        return clienteService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return clienteService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente cliente){

        return clienteService.findById(id)
                .map( record -> {
                    clienteService.saveAndFlush(cliente);
                    return ResponseEntity.ok().body(cliente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return clienteService.findById(id)
                .map(record -> {
                    clienteService.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
