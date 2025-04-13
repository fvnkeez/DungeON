package inventario;

import personajes.Enemigo;
import personajes.Personaje;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * 
 * Clase abstracta que representa un objeto dentro del juego.
 * Los objetos pueden ser usados por los personajes y pueden tener efectos sobre ellos mismos o sobre enemigos.
 * Cada objeto tiene un ID, un nombre y una descripción.
 */
public abstract class Objeto {

    /**
     * Identificador único del objeto.
     */
    private int id;

    /**
     * Nombre del objeto (ej. "Poción", "Bomba", etc.).
     */
    private String nombre;

    /**
     * Descripción breve del efecto o función del objeto.
     */
    private String descripcion;

    /**
     * Constructor de la clase Objeto.
     * 
     * @param id ID único del objeto.
     * @param nombre Nombre del objeto.
     * @param descripcion Descripción del objeto.
     */
    public Objeto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Método abstracto que define la acción del objeto cuando se utiliza.
     * Debe ser implementado por cada subclase (por ejemplo, Poción, Bomba, etc.).
     * 
     * @param pj El personaje que utiliza el objeto.
     * @param en El enemigo afectado por el objeto, si aplica.
     * @return true si el objeto se usó con éxito, false si no surtió efecto.
     */
    public abstract boolean usar(Personaje pj, Enemigo en);

    /**
     * Devuelve el nombre del objeto.
     * 
     * @return Nombre del objeto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la descripción del objeto.
     * 
     * @return Descripción del objeto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el ID del objeto.
     * 
     * @return ID numérico del objeto.
     */
    public int getId() {
        return id;
    }
}
