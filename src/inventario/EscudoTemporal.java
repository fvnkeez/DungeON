package inventario;

import personajes.Personaje;
import personajes.Enemigo;

public class EscudoTemporal extends Objeto {

    public EscudoTemporal() {
        super(4, "Escudo Temporal", "Bloquea el siguiente ataque recibido.");
    }

    @Override
    public boolean usar(Personaje pj, Enemigo enemigo) {
        pj.setEscudoActivo(true); // debes crear este campo booleano en `Personaje` y comprobarlo en recibirDañoJugador
        System.out.println("Te rodea un campo de fuerza mágico.");
        return true;
    }
}
