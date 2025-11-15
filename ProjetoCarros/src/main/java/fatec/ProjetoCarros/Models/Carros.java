package fatec.ProjetoCarros.Models;

import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Carros")
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Modelo", length = 150)
    @NotBlank(message = "O Carro não pode ter nome nulo")
    private String modelo;

    @Column(name = "Marca", length = 100)
    @NotBlank(message = "A marca do Carro não pode Nulo")
    private String marca;

    @Column(name = "Ano")
    @NotNull(message = "Ano não pode ser nula")
    private Integer ano;

    @Column(name = "Quilometragem")
    @NotNull(message = "Quilometragem não pode ser nula")
    private Short quilometragem;

    public Carros(){

    };

    public Long getId() {
        return id;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Short getQuilometragem() {
        return quilometragem;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setQuilometragem(Short quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Modelo: " + getModelo() + " Marca:" + getMarca() + " Ano: " + getAno()
         + " Quilometragem: " + getQuilometragem();
    }
}
