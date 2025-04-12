package personajes;

/**
 * Clase abstracta que representa una entidad en el juego.
 * Esta clase sirve como base para la creación de personajes y enemigos.
 * Contiene atributos y métodos comunes como salud, nombre, y manejo de daño.
 */
public abstract class Entidad {

    /**
     * Nombre de la entidad.
     */
    private String nombre;

    /**
     * Salud actual de la entidad.
     */
    private int salud;

    /**
     * Tipo de arma que utiliza la entidad.
     */
    private int arma;

    /**
     * Salud máxima que puede tener la entidad.
     */
    private int saludMaxima;

    /**
     * Constructor de la clase Entidad.
     *
     * @param nombre Nombre de la entidad.
     * @param salud Salud inicial de la entidad.
     * @param arma Tipo de arma que utiliza la entidad.
     */
    public Entidad(String nombre, int salud, int arma) {
        this.nombre = nombre;
        this.salud = salud;
        this.arma = arma;
        this.saludMaxima = salud;
    }

    /**
     * Obtiene el nombre de la entidad.
     *
     * @return El nombre de la entidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la entidad.
     *
     * @param nombre El nuevo nombre de la entidad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la salud actual de la entidad.
     *
     * @return La salud actual de la entidad.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Establece la salud actual de la entidad.
     *
     * @param salud La nueva salud de la entidad.
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Obtiene el tipo de arma que utiliza la entidad.
     *
     * @return El tipo de arma de la entidad.
     */
    public int getArma() {
        return arma;
    }

    /**
     * Establece el tipo de arma que utiliza la entidad.
     *
     * @param arma El nuevo tipo de arma de la entidad.
     */
    public void setArma(int arma) {
        this.arma = arma;
    }

    /**
     * Obtiene la salud máxima de la entidad.
     *
     * @return La salud máxima de la entidad.
     */
    public int getSaludMaxima() {
        return saludMaxima;
    }

    /**
     * Establece la salud máxima de la entidad.
     *
     * @param saludMaxima La nueva salud máxima de la entidad.
     */
    public void setSaludMaxima(int saludMaxima) {
        this.saludMaxima = saludMaxima;
    }

    /**
     * Reduce la salud de la entidad al recibir daño.
     *
     * @param daño La cantidad de daño recibido.
     */
    public void recibirDaño(int daño) {
        this.salud -= daño;
    }

    /**
     * Restaura la salud de la entidad a su valor máximo.
     */
    public void restaurarSalud() {
        this.salud = this.saludMaxima;
    }
}