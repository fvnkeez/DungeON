package inventario;

import personajes.*;

public class ElixirMana extends Objeto {
    private int cantidad;

    public ElixirMana(int cantidad) {
        super(3,"Elixir de Maná", "Recupera " + cantidad + " puntos de maná.");
        this.cantidad = cantidad;
    }

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
