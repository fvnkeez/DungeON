package inventario;

import personajes.Enemigo;
import personajes.Personaje;


public abstract class Objeto {
    private int id;
    private String nombre;
    private String descripcion;

    public Objeto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract boolean usar(Personaje pj, Enemigo en);

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }
}
