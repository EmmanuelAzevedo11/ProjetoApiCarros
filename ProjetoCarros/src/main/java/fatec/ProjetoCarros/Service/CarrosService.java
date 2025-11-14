package fatec.ProjetoCarros.Service;

import fatec.ProjetoCarros.Models.Carros;
import fatec.ProjetoCarros.Repository.CarrosRepository;
import org.springframework.stereotype.Service;
import java.lang.*;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarrosService {

    private final CarrosRepository carrosRepository;

    public CarrosService(CarrosRepository carrosRepository){
        this.carrosRepository = carrosRepository;
    }

    //método de pegar carros ( por id, todos e por nome)

    private Carros buscarPorId(Long id){
        return carrosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esse carro não existe"));
    }

    private List<Carros> buscartTodos(){
        List<Carros> carros = carrosRepository.findAll();
        if(carros.isEmpty()){
            throw new NoSuchElementException("Não há carros cadastrados ainda");
        }

        return carros;
    }

    private List<Carros> buscarPorModelo(String modelo){
        List<Carros> carros = carrosRepository.findByModelo(modelo);

        if(carros.isEmpty()){
            throw new NoSuchElementException("Não há carros cadastrados ainda");
        }

        return carros;
    }

    //método de salvar carros
    private void salvarCarro(Carros carro){
        carrosRepository.save(carro);
    }

    //atualizando as informações sobre os novos carros
    private void atualizandoCarros(Carros carroNovo){
        Carros carro = carrosRepository.findById(carroNovo.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Esse carro não existe"));
        carro.setModelo(carroNovo.getModelo());
        carro.setAno(carroNovo.getAno());
        carro.setQuilometragem(carroNovo.getQuilometragem());
        carro.setImagemPath(carroNovo.getImagemPath());
        carrosRepository.save(carro);
    }

    //deletenado carro
    private void deletarCarro(Long id){
        Carros carro = carrosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carro não existe"));
        carrosRepository.delete(carro);
    }

}
