package fatec.ProjetoCarros.controller;

import fatec.ProjetoCarros.Models.Carros;
import fatec.ProjetoCarros.Service.CarrosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")

public class CarrosController {

    private CarrosService carrosService;

    public CarrosController(CarrosService carrosService){
        this.carrosService = carrosService;
    }
    @GetMapping
    public List<Carros> retornaCarros(){
        return carrosService.buscartTodos();
    }
    @GetMapping("/id/{id}")
    public Carros retornaCarrosId(@PathVariable Long id){
        return carrosService.buscarPorId(id);
    }
    @GetMapping("/modelo/{modelo}")
    public List<Carros> retornaModelo(@PathVariable String modelo){
        return carrosService.buscarPorModelo(modelo);
    }
    @PostMapping
    public void salvarCarros(@RequestBody Carros carro){
        carrosService.salvarCarro(carro);
    }
    @PutMapping
    public void attCarros(@RequestBody Carros carro){
        carrosService.atualizandoCarros(carro);
    }
    @DeleteMapping("/id/{id}")
    public void deletaCarros(@PathVariable Long id){
        carrosService.deletarCarro(id);
    }





}
