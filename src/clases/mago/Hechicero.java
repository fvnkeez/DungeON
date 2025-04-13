package clases.mago;

import partida.Partida;
import personajes.Enemigo;

import static ansi.Ansi.*;
import java.util.Random;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * Descripción: Clase Hechicero, subclase de la clase Mago. Su habilidad es ilimitada, y consiste en elegir un hechizo
 * aleatorio de su repertorio. Unos tienen resultados buenos y otros malos.
 */
public class Hechicero extends Mago {

    /**
     * Random para elegir el hechizo a usar
     */
    private Random random = new Random();

    public Hechicero(String nombre, int salud, int arma, int mana, int manaMaximo, int nivel, int exp, int expMaxima) {
        super(nombre, salud, arma, mana, manaMaximo, nivel, exp, expMaxima);
    }

    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) {
        System.out.println(MORADO + "\nInvocas el caos arcano... un hechizo aleatorio toma forma:" + GREEN);

        int hechizo = random.nextInt(6); // 0 a 5
        switch (hechizo) {
            case 0:
                System.out.println(GREEN + "Hechizo: Explosión Arcana - Doble daño al enemigo!" + RESET);
                int daño1 = getArma() * 2;
                enemigo.recibirDaño(daño1);
                partida.sumarDañoInfligido(daño1);
                System.out.println("→ Has infligido " + RED + daño1 + RESET + " de daño.");
                System.out.println("Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");

            break;

            case 1:
                System.out.println(GREEN + "Hechizo: Tormenta Elemental - Daño aleatorio masivo!" + RESET);
                int daño2 = 20 + random.nextInt(21); // 20 a 40
                enemigo.recibirDaño(daño2);
                partida.sumarDañoInfligido(daño2);
                System.out.println("→ Has infligido " + RED + daño2 + RESET + " de daño.");
                System.out.println("Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");

            break;

            case 2:
                System.out.println(GREEN + "Hechizo: Rayo de Energía - Daño decente y seguro." + RESET);
                int daño3 = 15 + random.nextInt(6); // 12-17
                enemigo.recibirDaño(daño3);
                partida.sumarDañoInfligido(daño3);
                System.out.println("→ Has infligido " + RED + daño3 + RESET + " de daño.");
                System.out.println("Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");

            break;

            case 3:
                System.out.println(MORADO + "Hechizo: Tentáculos del Vacío - Golpeas dos veces con daño impredecible..." + RESET);
                for (int i = 1; i <= 2; i++) {
                    int daño = 8 + random.nextInt(6); // 8–13
                    System.out.println("→ Tentáculo " + i + " inflige " + daño + " de daño.");
                    enemigo.recibirDaño(daño);
                    partida.sumarDañoInfligido(daño);
                }
                System.out.println(GREEN + "Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");
            break;
        
            case 4:
                System.out.println(RED + "Hechizo: Retroceso Mágico - Te haces 10 de daño." + RESET);
                recibirDañoJugador(10);
                partida.sumarDañoRecibido(10);
            break;

            case 5:
                System.out.println(RED + "Hechizo: Transformación Fallida - Pierdes tu turno sin efecto." + RESET);
                // Nada ocurre
            break;
        }

        return true;
    }
}
