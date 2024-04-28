package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCompra;
    private int idCliente;
    private int valorAPagar;

    public Compra(int valorAPagar, int idCliente, int idCompra) {
        this.valorAPagar = valorAPagar;
        this.idCliente = idCliente;
        this.idCompra = idCompra;
    }

    public Compra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(int valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
