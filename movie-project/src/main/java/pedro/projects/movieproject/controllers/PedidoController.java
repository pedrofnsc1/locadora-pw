package pedro.projects.movieproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.projects.movieproject.models.Pedido;
import pedro.projects.movieproject.services.PedidoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listAll(){
        return pedidoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return pedidoService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido insert(@RequestBody Pedido pedido){
        return pedidoService.save(pedido);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Pedido pedido){
        return pedidoService.findById(id)
                .map(record -> {
                    pedidoService.saveAndFlush(pedido);
                    return ResponseEntity.ok().body(pedido);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /*@DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return pedidoService.findById(id)
                .map(record -> {
                    pedidoService.delete(record);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }*/
}
