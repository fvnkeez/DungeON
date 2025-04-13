package clases.ladron;

import inventario.Objeto;
import partida.*;
import personajes.Enemigo;
import personajes.Personaje;

import static ansi.Ansi.*;

import java.io.IOException;
import java.util.Random;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * Descripción: Clase Ladrón, es una de las tres "clases" base del juego. Se caracteriza por tener salud media y daño medio.
 * Sus "subclases" por el momento son "Pícaro" y "Fantasma", aunque no están implementadas.
 */
public class Ladron extends Personaje {

    /**
     * Random para elegir qué objeto robar del enemigo.
     */
    private Random random = new Random();

    /**
     * Nombre de la habilidad
     */
    private String nombreHabilidad = "Robo";
    
    /**
     * Número de usos de la habilidad
     */
    private int usos;

    public Ladron(String nombre, int salud, int arma, int nivel, int exp, int expMaxima, int usos) {
        super(nombre, salud, arma, nivel, exp, expMaxima);
        this.usos = usos;
    }

    public int atacar() {
        return getArma();
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    @Override
    public boolean usarHabilidad(Enemigo enemigo, Partida partida) throws IOException {
        if (this.usos > 0) {
            if (!enemigo.getInventario().estaVacio()) {
                System.out.println(MORADO + "Has usado la habilidad: " + this.nombreHabilidad + GREEN);
    
                // Elegir un objeto aleatorio del inventario del enemigo
                int indexObjeto = random.nextInt(enemigo.getInventario().getSize());
                Objeto robado = enemigo.getInventario().getObjeto(indexObjeto);
    
                // Eliminarlo del inventario del enemigo y añadirlo al del jugador
                enemigo.getInventario().eliminarObjeto(indexObjeto);
                this.getInventario().agregarObjeto(robado, false);
    
                System.out.println("Has robado: " + AZUL + robado.getNombre() + GREEN);
                this.usos--;
                return false;
            } else {
                System.out.println("El enemigo no tiene objetos que robar.");
                return false;
            }
        } else {
            System.out.println("No te quedan usos de la habilidad.");
            return false;
        }
    }
}

