package inventario;

import static ansi.Ansi.*;

import personajes.Enemigo;
import personajes.Personaje;

/**
 * @date 13/04/2025
 * @version 1.8
 * 
 * Clase que representa una bomba.
 * Al usarse, inflige daño directamente a un enemigo.
 */
public class Bomba extends Objeto {

    /**
     * Cantidad de daño que la bomba inflige al enemigo.
     */
    private int daño;

    /**
     * Constructor de la bomba.
     * 
     * @param id ID del objeto.
     * @param daño Daño que inflige al enemigo.
     */
    public Bomba(int id, int daño) {
        super(id, "Bomba", "Inflige daño a un enemigo.");
        this.daño = daño;
    }

    /**
     * Lanza la bomba sobre un enemigo, reduciendo su salud.
     * 
     * @param pj El personaje que lanza la bomba.
     * @param enemigo El enemigo objetivo del daño.
     * @return true siempre que se use.
     */
    @Override
    public boolean usar(Personaje pj, Enemigo enemigo) {
        enemigo.setSalud(enemigo.getSalud() - daño);
        System.out.println("Has lanzado una bomba que inflige " + AZUL + daño + " de daño al enemigo.");
        System.out.println(GREEN + "Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud." + RESET);
        return true;
    }
}
