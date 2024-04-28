package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Biblioteca {
    @Id
    @GeneratedValue
    private int id;
    private ArrayList<Videojuego> videojuegos;
    private String dueño;
    public Biblioteca() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
}
