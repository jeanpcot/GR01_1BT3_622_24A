package Persistencia;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "videojuego")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videojuego", nullable = false)
    private Integer id;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "copias_disponibles", nullable = false)
    private Integer copiasDisponibles;

    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;

    @OneToMany(mappedBy = "idVideojuego")
    private Set<Biblioteca> bibliotecas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idVideojuego")
    private Set<Compra> compras = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(Integer copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(Set<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }

}