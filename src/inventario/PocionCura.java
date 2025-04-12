package inventario;

import static ansi.Ansi.*;

import personajes.Enemigo;
import personajes.Personaje;


public class PocionCura extends Objeto {

    private int cantidadCuracion;

    public PocionCura(int id, int cantidadCuracion) {
        super(id, "Poción de Curación", "Restaura salud al personaje.");
        this.cantidadCuracion = cantidadCuracion;
    }

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
