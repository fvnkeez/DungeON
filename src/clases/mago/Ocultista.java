package clases.mago;

import static ansi.Ansi.*;

import partida.Partida;
import personajes.Enemigo;
/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * Descripción: Clase Ocultista, subclase de la clase Ladrón. Su habilidad consiste en robar vida al enemigo.
 */
public class Ocultista extends Mago {

    public Ocultista(String nombre, int salud, int arma, int mana, int manaMaximo, int nivel, int exp, int expMaxima) {
        super(nombre, salud, arma, mana, manaMaximo, nivel, exp, expMaxima);
    }

    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida){
        if (getMana() <= 0) {
            System.out.println(RED + "Ya no puedes invocar más el poder oscuro... (No te queda maná)." + RESET);
            return false;
        }

        System.out.println(MORADO + "\nCanalizas energía oscura... ¡y drenas la vida del enemigo!" + RESET);
        
        int daño;
        if (getNivel() == 1) {
            daño = 15;
        } else {
            daño = 15 + (int)Math.round(getNivel() * 2.5);
        }
        enemigo.recibirDaño(daño);
        partida.sumarDañoInfligido(daño);

        setSalud(getSalud() + daño);
        if (getSalud() > getSaludMaxima()) setSalud(getSaludMaxima());

        System.out.println(GREEN + "Has absorbido " + daño + " de vida. Salud actual: " + AZUL + getSalud() + GREEN + RESET);
        System.out.println(GREEN + "Te queda : " + AZUL + getMana() + GREEN + " / " + GREEN + getManaMaximo() + " de maná." + RESET);
        System.out.println("Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");

        setMana(getMana() -5);

        return true;
    }

    @Override
    public void subirNivel() {
        super.subirNivel(); // Sube nivel y ajusta exp
    }
}
