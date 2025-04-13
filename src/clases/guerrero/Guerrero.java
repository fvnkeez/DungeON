package clases.guerrero;

import partida.*;
import personajes.Enemigo;
import personajes.Personaje;

import static ansi.Ansi.*;
import java.util.Random;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * Descripción: Clase Guerrero, es una de las tres "clases" base del juego. Se caracteriza por ser la que más salud tiene,
 * pero la que hace el daño más bajo. Sus "subclases" por el momento son "Caballero" y "Bárbaro".
 */
public class Guerrero extends Personaje{

    /**
     * String con el nombre de la habilidad
     */
    private String nombreHabilidad = "Ataque doble";

    /**
     * Cantidad de usos disponibles para la habilidad
     */
    private int usos; 

    /**
     * Usos máximos de la habilidad
     */
    private int usosMaximos; 


    public Guerrero (String nombre, int salud, int arma, int nivel, int exp, int expMaxima, int usos, int usosMaximos) {
        super(nombre, salud, arma, nivel, exp, expMaxima);
        this.usos = usos;
        this.usosMaximos = usosMaximos;

    }

    public int ataqueDoble(int saludEnemigo, int dañoRealArma) {
        return saludEnemigo - dañoRealArma * 2;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public int getUsosMaximos() {
        return usosMaximos;
    }

    public void setUsosMaximos(int usosMaximos) {
        this.usosMaximos = usosMaximos;
    }

    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) {

        if (usos > 0) {
            double[] MULTIPLICADOR_DAÑO = { 0, 0.5, 0.75, 1, 1, 1.25, 1.5, 1.75, 2 };
            Random random = new Random();

            int daño1 = (int) (getArma() * MULTIPLICADOR_DAÑO[random.nextInt(MULTIPLICADOR_DAÑO.length)]);
            int daño2 = (int) (getArma() * MULTIPLICADOR_DAÑO[random.nextInt(MULTIPLICADOR_DAÑO.length)]);
            int dañoTotal = daño1 + daño2;

            enemigo.recibirDaño(dañoTotal);
            partida.sumarDañoInfligido(dañoTotal);
            usos--;

            System.out.println(MORADO + "Has usado la habilidad: " + nombreHabilidad + GREEN);
            if (daño1 == 0 && daño2 == 0) {
                System.out.println(BOLD + BY + "¡Has fallado los dos golpes! Eso sí que es mala suerte." + RESET);
            } else if (daño1 == 0) {
                System.out.println(GREEN + "Has fallado el primer golpe, pero el segundo hace: " + AZUL + daño2 + GREEN + " de daño.");
            } else if (daño2 == 0) {
                System.out.println("El primer golpe hace: " + AZUL + daño1 + GREEN + " de daño, pero el segundo ha fallado.");
            } else if ((daño1 + daño2) == getArma() * 4) {
                System.out.println(BOLD + BY + "¡Doble golpe crítico! Eso sí que es buena suerte." + RESET);

            }
            System.out.println("Primer golpe: " + AZUL + daño1 + GREEN + " de daño.");
            System.out.println("Segundo golpe: " + AZUL + daño2 + GREEN + " de daño.");
            System.out.println("Total infligido: " + AZUL + dañoTotal + GREEN + ". Te quedan " + AZUL + usos + GREEN + " usos.");
            System.out.println("Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");

            return true;
        } else {
            System.out.println("Ya no te quedan usos de la habilidad " + nombreHabilidad + ".");
            return false;
        }
    }

    @Override
    public void subirNivel() {
        super.subirNivel(); // Sube nivel y ajusta exp
        this.usos = Math.min(this.usos + 1, 3); // Restaura hasta un máximo de 3 usos
        System.out.println("Se ha restaurado 1 uso de tu habilidad especial");
    }
}

