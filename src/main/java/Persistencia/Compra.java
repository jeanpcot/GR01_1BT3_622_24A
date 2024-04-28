package Persistencia;

import jakarta.persistence.*;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_videojuego", nullable = false)
    private Videojuego idVideojuego;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @Column(name = "precio_a_pagar", nullable = false)
    private Double precioAPagar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Videojuego getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Videojuego idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getPrecioAPagar() {
        return precioAPagar;
    }

    public void setPrecioAPagar(Double precioAPagar) {
        this.precioAPagar = precioAPagar;
    }

}