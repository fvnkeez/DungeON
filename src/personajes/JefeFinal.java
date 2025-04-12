package personajes;

import inventario.*;

/**
 * JefeFinal representa al jefe de la sala final del juego.
 * Es un enemigo especial con estadísticas superiores y un nombre único.
 */
public class JefeFinal extends Enemigo {

    /**
     * Constructor del Jefe Final, llamado "XAL'THŸGOR".
     * Tiene salud, daño y experiencia personalizados.
     */
    public JefeFinal() {
        super("XAL'THŸGOR", 250, 30);

        getInventario().agregarObjeto(new Bomba(2, 20), false);
        getInventario().agregarObjeto(new PocionCura(1, 40), false);
    }
}
