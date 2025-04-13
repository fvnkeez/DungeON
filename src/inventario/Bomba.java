package inventario;

import static ansi.Ansi.*;

import personajes.Enemigo;
import personajes.Personaje;

public class Bomba extends Objeto {

    private int daño;

    public Bomba(int id, int daño) {
        super(id, "Bomba", "Inflige daño a un enemigo.");
        this.daño = daño;
    }

    @Override
    public boolean usar(Personaje pj, Enemigo enemigo) {
        enemigo.setSalud(enemigo.getSalud() - daño);
        System.out.println("Has lanzado una bomba que inflige " + AZUL + daño + " de daño al enemigo.");
        System.out.println(GREEN +"Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud." + RESET);
        return true;
    }
}
