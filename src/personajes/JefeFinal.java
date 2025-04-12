package personajes;

import static ansi.Ansi.BOLD;
import static ansi.Ansi.GREEN;
import static ansi.Ansi.MORADO;
import static ansi.Ansi.RED;
import static ansi.Ansi.RESET;

import java.util.Random;

import clases.ladron.Fantasma;
import inventario.*;
import partida.Partida;

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
        super("XAL'THŸGOR", 200, 20);

        getInventario().agregarObjeto(new Bomba(2, 20), false);
        getInventario().agregarObjeto(new PocionCura(1, 40), false);
    }

     /**
     * Ejecuta el ataque del enemigo contra el jugador.
     * 
     * @param pj1 El personaje del jugador.
     * @param enemigo El enemigo actual.
     * @param partida El objeto partida.
     */
    public static void ejecutarAtaqueJefeFinal(Personaje pj1, Enemigo enemigo, Partida partida) {
        Random random = new Random();
        int tipoAtaque = random.nextInt(4);
        int dañoReal = 0;
    
        if (pj1 instanceof Fantasma && ((Fantasma) pj1).debeEsquivar()) {
            System.out.println(MORADO + "¡Te desvaneces en el aire y esquivas el ataque del jefe!" + GREEN);
            ((Fantasma) pj1).consumirEsquivar();
            return;
        }
    
        switch (tipoAtaque) {
            case 0:
                System.out.println(BOLD + RED + enemigo.getNombre() + " invoca una marea de fuego infernal." + RESET + GREEN);
                dañoReal = (int)(enemigo.getArma() * 1.2);
                break;
            case 1:
                System.out.println(BOLD + RED + enemigo.getNombre() + " lanza maldiciones susurradas al aire..." + RESET + GREEN);
                dañoReal = enemigo.getArma();
                break;
            case 2:
                System.out.println(BOLD + RED + enemigo.getNombre() + " golpea con un tentáculo etéreo y te desequilibra." + RESET + GREEN);
                dañoReal = (int)(enemigo.getArma() * 1.5);
                break;
            case 3:
                System.out.println(BOLD + RED + enemigo.getNombre() + " intenta un ritual prohibido y se hiere a sí mismo." + RESET + GREEN);
                int dañoAutoinfligido = 30;
                enemigo.recibirDaño(dañoAutoinfligido);
                System.out.println(RED + "El jefe pierde " + dañoAutoinfligido + " de salud por su locura." + GREEN);
                return;
        }
    
        pj1.recibirDañoJugador(dañoReal);
        partida.sumarDañoRecibido(dañoReal);
    
        System.out.println("El jefe te inflige " + RED + dañoReal + GREEN + " de daño.");
    }
    
}
