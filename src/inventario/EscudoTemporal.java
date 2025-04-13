package inventario;

import personajes.Personaje;
import personajes.Enemigo;

/**
 * @date 13/04/2025
 * @version 1.8
 * 
 * Clase que representa un escudo temporal.
 * Al usarse, protege al personaje del siguiente ataque recibido.
 */
public class EscudoTemporal extends Objeto {

    /**
     * Constructor del escudo temporal.
     * No requiere parámetros, el efecto es siempre el mismo.
     */
    public EscudoTemporal() {
        super(4, "Escudo Temporal", "Bloquea el siguiente ataque recibido.");
    }

    /**
     * Activa un estado especial en el personaje que anula el siguiente ataque recibido.
     * 
     * @param pj El personaje que activa el escudo.
     * @param enemigo No se utiliza para este objeto.
     * @return true siempre que se use.
     */
    @Override
    public boolean usar(Personaje pj, Enemigo enemigo) {
        pj.setEscudoActivo(true);
        System.out.println("Te rodea un campo de fuerza mágico.");
        return true;
    }
}
