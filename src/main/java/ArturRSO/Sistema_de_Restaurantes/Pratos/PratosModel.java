package ArturRSO.Sistema_de_Restaurantes.Pratos;

import ArturRSO.Sistema_de_Restaurantes.Restaurantes.RestaurantesModel;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PratosModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;

    private String nome;
    private double preco;

    @ManyToOne
    @JoinColumn(name = "restaurante")
    private RestaurantesModel restaurante;

    public PratosModel() {
        super();
    }

    public PratosModel(Long id, String nome, double preco, RestaurantesModel restaurante) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public RestaurantesModel getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestaurantesModel restaurante) {
        this.restaurante = restaurante;
    }
}
