package inventario;

import personajes.*;

/**
 * @date 13/04/2025
 * @version 1.8
 * 
 * Clase que representa un elixir de maná.
 * Solo puede ser usado por personajes de tipo mago, y recupera una cantidad fija de maná.
 */
public class ElixirMana extends Objeto {

    /**
     * Cantidad de maná que se recupera al usar el objeto.
     */
    private int cantidad;

    /**
     * Constructor del elixir de maná.
     * 
     * @param cantidad Cantidad de maná que recupera.
     */
    public ElixirMana(int cantidad) {
        super(3, "Elixir de Maná", "Recupera " + cantidad + " puntos de maná.");
        this.cantidad = cantidad;
    }

    /**
     * Recupera maná si el personaje es de tipo mago.
     * 
     * @param pj El personaje que intenta usar el elixir.
     * @param enemigo No se utiliza en este objeto.
     * @return true si se usó correctamente, false si el personaje no es mago.
     */
    @Override
    public boolean usar(Personaje pj, Enemigo enemigo) {
        if (pj instanceof clases.mago.Mago) {
            ((clases.mago.Mago) pj).recuperarMana(cantidad);
            System.out.println("Has recuperado " + cantidad + " de maná.");
            return true;
        } else {
            System.out.println("Solo los magos pueden usar esto.");
            return false;
        }
    }
}
