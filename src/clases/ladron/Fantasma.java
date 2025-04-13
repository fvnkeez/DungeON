package clases.ladron;
import partida.Partida;
import personajes.Enemigo;

/**
 * FECHA: 13/04/2025
 * @version Final
 * @author Dani Fuente
 * Descripción: Clase Fantasma, subclase de la clase Ladrón. Su habilidad consiste en gastar un uso de su habilidad para
 * esquivar el próximo ataque del enemigo.
 */
public class Fantasma extends Ladron {

    /*
     * Boolean que se "activa" al usar la habilidad, se usa para determinar si está activada y
     * gastar un uso para esquivar el próximo ataque.
     */
    private boolean esquivarProximoAtaque = false;

    public Fantasma(String nombre, int salud, int arma, int nivel, int exp, int expMaxima, int usos) {
        super(nombre, salud, arma, nivel, exp, expMaxima, usos);
    }

    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) {

        if (getUsos() > 0) {
            if (!esquivarProximoAtaque) {
                esquivarProximoAtaque = true;
                System.out.println("\nTe preparas para desvanecerte... esquivarás el próximo ataque enemigo.");
                setUsos(getUsos() - 1);
                return false;
            } else {
                System.out.println("\nYa tienes activa la evasión. Espera a que se consuma antes de volver a usarla.");
                return false;
            }
        } else {
            System.out.println("Ya no te quedan usos de la habilidad.");
            return false;
        }
    }

    // Método público para saber si debe esquivar
    public boolean debeEsquivar() {
        return esquivarProximoAtaque;
    }

    // Método público para consumir la evasión una vez esquivado
    public void consumirEsquivar() {
        esquivarProximoAtaque = false;
    }
}
 