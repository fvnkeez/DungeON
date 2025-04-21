package clases.ladron;

import static ansi.Ansi.*;
import java.io.IOException;
import java.util.Random;
import partida.Partida;
import personajes.Enemigo;
import utilidades.*;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * Descripción: Clase Pícaro, subclase de la clase Ladrón. Su habilidad se activa automáticamente al empezar un
 * combate. 
 */
public class Picaro extends Ladron {

    /**
     * Random para elegir un número aleatorio entre el rango decidido
     */
    private Random random = new Random();

    /**
     * Marca si ya se ha activado la habilidad este turno
     */
    private boolean habilidadUsada = false;

    /**
     * Número base de rango máximo, se va sumando con cada enemigo asesinado.
     */
    private int numSumar = 6;

    public Picaro(String nombre, int salud, int arma, int nivel, int exp, int expMaxima, int usos) {
        super(nombre, salud, arma, nivel, exp, expMaxima, usos);
    }

    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) throws IOException {
        if (habilidadUsada) {
            System.out.println("Ya has intentado el asesinato sorpresa en este combate." + GREEN);
            return false;
        }

        habilidadUsada = true;
        
        // Si es el enemigo final, el rango máximo se cambia a 666 para que sea casi imposible matarle de un golpe.
        int numeroMax = (enemigo instanceof personajes.JefeFinal) ? 666 : numSumar;
        int numeroCorrecto = random.nextInt(numeroMax) + 1;

        if (enemigo instanceof personajes.JefeFinal) {
            System.out.println(MORADO + "SUSURROS ANTIGUOS INUNDAN TU MENTE...");
            System.out.println("Parece que será más difícil asesinar a este enemigo...");
            System.out.println("Elige un número entre 1 y " + numeroMax);
        } else {
            System.out.println(MORADO + "\nIntentas asesinar al enemigo de un solo golpe..." + GREEN);
            System.out.println("Elige un número del 1 al " + numeroMax);
        }

        int numeroJugador = Utils.leerNumeroEntre(1, numeroMax);

        // Animación textual
        try {
            System.out.print("Te deslizas entre las sombras");
            Thread.sleep(200); System.out.print(".");
            Thread.sleep(200); System.out.print(".");
            Thread.sleep(200); System.out.println("." + GREEN);

            System.out.print("Levantas tu daga con precisión");
            Thread.sleep(350); System.out.print(".");
            Thread.sleep(350); System.out.print(".");
            Thread.sleep(350); System.out.println("." + GREEN);

            System.out.print("Apuntas directo al corazón del enemigo");
            Thread.sleep(500); System.out.print(".");
            Thread.sleep(500); System.out.print(".");
            Thread.sleep(500); System.out.println("." + GREEN);

            System.out.println("¡Lanzas el golpe!" + GREEN);
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (numeroJugador == numeroCorrecto) {
            enemigo.setSalud(0);
            if (enemigo instanceof personajes.JefeFinal) {
                System.out.println(BOLD +"\nHas derrotado al enemigo final de un solo golpe." + RESET + GREEN);
            } else {
                System.out.println(BOLD +"\n¡ÉXITO!" + RESET + GREEN + " Has asesinado al enemigo de forma fulminante." + GREEN);
                // Aumenta el número de rango máximo si se acierta
                numSumar++;
                System.out.println(MORADO + "El rango máximo aumenta..." + GREEN);
            }
        } else {
            System.out.println(BOLD + RED + "\nFallaste..." + RESET + GREEN + " el enemigo ha esquivado el golpe letal." + GREEN);
            System.out.println("El número objetivo era: " + AZUL + numeroCorrecto + GREEN);
            System.out.println("\nTu número fue: " + AZUL + numeroJugador + GREEN);
        }
        return true;    
    }
    

    // Método para reiniciar la habilidad al iniciar un nuevo combate
    public void reiniciarHabilidad() {
        this.habilidadUsada = false;
    }
}
