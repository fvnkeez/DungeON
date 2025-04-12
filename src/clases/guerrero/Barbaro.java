package clases.guerrero;

import partida.Partida;
import personajes.Enemigo;

import static ansi.Ansi.*;

import java.util.Random;

public class Barbaro extends Guerrero {

    private int furia;

    public Barbaro(String nombre, int salud, int arma, int nivel, int exp, int expMaxima, int usos, int usosMaximos) {
        super(nombre, salud, arma, nivel, exp, expMaxima, usos, usosMaximos);
        this.furia = 0;
    }

    @Override
    public void recibirDañoJugador(int daño) {
        super.recibirDañoJugador(daño);
        furia += daño;
    }

    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) {

        if (getUsos() > 0) {
            Random random = new Random();
            double[] MULTIPLICADOR_DAÑO = { 0.5, 0.75, 1, 1.25, 1.5 };
            int dañoBase = (int) (getArma() * MULTIPLICADOR_DAÑO[random.nextInt(MULTIPLICADOR_DAÑO.length)]);
            int dañoTotal = dañoBase + furia;

            enemigo.recibirDaño(dañoTotal);
            partida.sumarDañoInfligido(dañoTotal);

            System.out.println(MORADO +"\nHas usado la habilidad: Furia Desatada"+ GREEN);
            System.out.println("Daño base del ataque: " + AZUL + dañoBase);
            System.out.println("Furia acumulada añadida: " + AZUL + furia);
            System.out.println("Daño total infligido: " + AZUL + dañoTotal);

            System.out.println("Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");

            furia = 0;
            setUsos(getUsos() - 1);
            System.out.println("Te quedan " + AZUL + getUsos() + " usos.");
            return true;
        } else {
            System.out.println("Ya no te quedan usos de la habilidad Furia Desatada.");
            return false;
        }
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("║ Furia: " + AZUL + furia + GREEN);
    }

}
