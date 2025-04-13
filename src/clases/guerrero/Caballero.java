package clases.guerrero;
import static ansi.Ansi.*;

import partida.*;
import personajes.Enemigo;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * Descripción: Clase Caballero, es "subclase" de la "clase" Guerrero, y añade un atributo llamado escudo, que añade
 * vida extra.
 */
public class Caballero extends Guerrero {
    /**
     * String con el nombre de la habilidad
     */
    private String nombreHabilidad = "Protección";
    /**
     * Número entero con la cantidad de escudo (salud adicional)
     */
    private int escudo;

    public Caballero (String nombre, int salud, int arma, int nivel, int escudo, int exp, int expMaxima, int usos, int usosMaximos) {
        super(nombre, salud, arma, nivel, exp, expMaxima, usos, usosMaximos);
        this.escudo = 0;
    }

    @Override
    public void recibirDañoJugador(int daño) {
        super.recibirDañoJugador(daño);
        escudo += daño;
    }

    /**
     * La habilidad del Caballero es utilizar su escudo para añadirse salud adicional, esta habilidad
     * está relacionada con el Guerrero porque esta rama de clases se caracteriza por tener mucha salud.
     */
    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) {
   
        if (escudo > 0) {
            if (getUsos() > 0) {
                int nuevaSalud = getSalud() + escudo;
                setSalud(nuevaSalud);
                System.out.println(MORADO + "Has usado la habilidad: " + nombreHabilidad + GREEN);
                System.out.println("¡Has gastado " + AZUL + escudo + GREEN + " de escudo y ahora tienes " + AZUL + getSalud() + GREEN +" de salud!");
                escudo = 0;
                setUsos(getUsos() - 1);
                System.out.println("Te quedan: " + AZUL + getUsos() + GREEN + " usos de la habilidad." + GREEN);
                return true;
            } else {
                System.out.println("Tienes escudo para usar, pero no te quedan usos de la habilidad.");
                return false;
            }

        } else {
            System.out.println("Escudo insuficiente para realizar la habilidad.");
            return false;
        }
    }

    public int getEscudo() {
        return escudo;
    }
}
