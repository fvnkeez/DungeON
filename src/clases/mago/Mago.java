package clases.mago;
import static ansi.Ansi.*;

import partida.*;
import personajes.Enemigo;
import personajes.Personaje;

/**
 * FECHA: 10/04/2025
 * @version Final
 * @author Dani Fuente
 * Descripción: Clase Mago, es una de las tres "clases" base del juego. Se caracteriza por tener baja salud y daño alto.
 * Sus "subclases" por el momento son "Ocultista" y "Hechicero", aunque no están implementadas.
 */
public class Mago extends Personaje {

    /**
     * Número entero que se gasta al utilizar habilidades, una habilidad no se puede lanzar
     * si se tiene menos maná de lo que cuesta.
     */
    private int mana; 
    private int manaMaximo; 
    private double dañoBaseBolaFuego = 2;

    
    public Mago(String nombre, int salud, int arma, int mana, int manaMaximo, int nivel, int exp, int expMaxima) {
        super(nombre, salud, arma, nivel, exp, expMaxima);
        this.mana = mana;
        this.manaMaximo = manaMaximo;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getManaMaximo() {
        return manaMaximo;
    }

    public void setManaMaximo(int manaMaximo) {
        this.manaMaximo = manaMaximo;
    }

    /**
     * Habilidad del mago, utiliza maná para lanzar una bola de fuego mágica, de momento
     * hace el doble de daño que un ataque normal.
     */
    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) {

        if (this.mana >= 5) {
            int dañoTotal = (int) Math.round(dañoBaseBolaFuego * getArma());
            enemigo.recibirDaño(dañoTotal);
            System.out.println(MORADO + "¡Lanzas una bola de fuego e infliges "+ AZUL + dañoTotal + MORADO + " de daño!" + GREEN);
            System.out.println("Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud.");
            this.mana -= 5;
            System.out.println(GREEN + "Te queda : " + AZUL + getMana() + GREEN + " / " + GREEN + getManaMaximo() + " de maná." + RESET);
            partida.sumarDañoInfligido(dañoTotal); // Registra todo el daño infligido y lo suma
            return true;
        } else {
            System.out.println("Maná insuficiente para realizar la habilidad.");
            return false;
        }
    }

    @Override
    public void subirNivel() {
        super.subirNivel();
        this.mana += 5;
        dañoBaseBolaFuego += 0.1;
        System.out.println(GREEN + "Tu maná ha aumentado. Maná actual: " + getMana()  + GREEN);
        System.out.println(MORADO + "Tu habilidad ahora hace más daño." + GREEN);
    }

    public void recuperarMana(int mana) {
        setMana(getMana() + mana);
    }

}
