package inventario;

import static ansi.Ansi.*;

import personajes.Enemigo;
import personajes.Personaje;

/**
 * @date 13/04/2025
 * @version 1.8
 * 
 * Clase que representa una poción de curación.
 * Restaura una cantidad fija de salud al personaje que la utiliza.
 */
public class PocionCura extends Objeto {

    /**
     * Cantidad de salud que se recupera al usar la poción.
     */
    private int cantidadCuracion;

    /**
     * Constructor de la poción de curación.
     * 
     * @param id ID único del objeto.
     * @param cantidadCuracion Cantidad de salud que restaura.
     */
    public PocionCura(int id, int cantidadCuracion) {
        super(id, "Poción de Curación", "Restaura salud al personaje.");
        this.cantidadCuracion = cantidadCuracion;
    }

    /**
     * Usa la poción para curar al personaje si no está ya al máximo de salud.
     * 
     * @param pj El personaje que la usa.
     * @param en Enemigo (no se utiliza en este objeto).
     * @return true si la curación fue aplicada, false si no hacía falta curarse.
     */
    @Override
    public boolean usar(Personaje pj, Enemigo en) {
        if (pj.getSalud() == pj.getSaludMaxima()) {
            System.out.println("Tu salud está al máximo, no puedes curarte");
            return false;
        } else {
            pj.curar(cantidadCuracion);
            System.out.println("Has usado " +  AZUL + getNombre() + ". Salud restaurada: " + AZUL + cantidadCuracion + GREEN);
            return true;
        }
    }
}
