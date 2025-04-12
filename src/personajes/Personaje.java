package personajes;
import inventario.Bomba;
import inventario.Inventario;
import inventario.PocionCura;
import partida.*;

import static ansi.Ansi.*;

import java.io.IOException;


/**
 * FECHA: 12/03/2025
 * @version 1.7
 * @author Dani Fuente
 * Descripción: Clase base para el resto de "clases" del juego. Todas tendrán salud, daño de arma, el nombre
 * de su clase y salud máxima. Ahora hereda de la clase Entidad para reutilizar atributos y métodos comunes.
 */
public abstract class Personaje extends Entidad {

    private Inventario inventario = new Inventario();
    private boolean escudoActivo = false;

    // Nivel del jugador, va subiendo a medida que llegas a una cantidad determinada de experiencia.
    private int nivel;

    // Experiencia del jugador, va subiendo a medida que derrotas enemigos.
    private int exp;

    // Atributo para mostrar la experiencia maxima por nivel del jugador.
    private int expMaxima;

    /**
     * Constructor de la clase Personaje.
     * @param nombre Nombre del personaje.
     * @param salud Salud inicial del personaje.
     * @param arma Daño del arma del personaje.
     */
    public Personaje(String nombre, int salud, int arma, int nivel, int exp, int expMaxima) {
        super(nombre, salud, arma); // Llama al constructor de la clase base (Entidad)
        this.nivel = nivel;
        this.exp = exp;
        this.expMaxima = expMaxima;
    }

    /**
     * Método abstracto para que las subclases implementen habilidades especiales.
     * @param enemigo El enemigo sobre el cual se usa la habilidad.
     */
    public abstract boolean usarHabilidad(Enemigo enemigo, Partida partida)throws IOException;

    /**
     * Reduce la salud del personaje según el daño recibido.
     * @param dañoEnemigo El daño que recibe el personaje.
     */
    public void recibirDañoJugador(int dañoEnemigo) {
        if (escudoActivo) {
            System.out.println("¡El escudo temporal bloquea el daño!");
            escudoActivo = false;
        }else {
            setSalud(getSalud() - dañoEnemigo);
        }
    }

    /**
     * Restaura la salud del personaje a su valor máximo.
     */
    @Override
    public void restaurarSalud() {
        setSalud(getSaludMaxima()); // Usa los métodos de Entidad para restaurar la salud
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public int getExpMaxima() {
        return expMaxima;
    }

    public void setExpMaxima(int expMaxima) {
        this.expMaxima = expMaxima;
    }

    public void ganarExp(int cantidad) {
        this.exp += cantidad;
        System.out.println("Has ganado " + cantidad + " de experiencia.");
    
        while (this.exp >= this.expMaxima) {
            this.exp -= this.expMaxima;
            subirNivel();
        }
    
        System.out.println("EXP actual: " + this.exp + " / " + this.expMaxima);
    }
    
    public void subirNivel() {
        this.nivel++;
        this.expMaxima *= 1.3;
    
        // Escalado por multiplicación
        int nuevaSalud = (int) (getSalud() * 1.2);
        int nuevaSaludMax = (int) (getSaludMaxima() * 1.2);
        int nuevoDaño = (int) (getArma() * 1.3);
        
        setSalud(nuevaSalud);;
        setSaludMaxima(nuevaSaludMax);
        setArma(nuevoDaño);
    
        System.out.println("¡Has subido al nivel " + AZUL + this.nivel  + GREEN + "!");
        System.out.println("Salud actual: " + AZUL + getSalud() + GREEN + " / " + AZUL + getSaludMaxima() + GREEN);
        System.out.println("Tu daño de arma ahora es: " + AZUL + getArma() + GREEN);
        this.inventario.agregarObjeto(new PocionCura(1,30 ), false);
        this.inventario.agregarObjeto(new Bomba(2, 15), false);
    }
    
    public void restaurarExp() {
        this.exp = 0;
    }

    public void curar(int cura) {
        setSalud(getSalud() + cura);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void mostrarEstado() {
        System.out.println(GREEN + "\n╔═════════════════ ESTADO DEL PERSONAJE ═════════════════");
        System.out.println("║ Salud: " + AZUL + getSalud() + "/" + getSaludMaxima() + GREEN);
        System.out.println("║ EXP: " + AZUL + getExp() + "/" + getExpMaxima() + GREEN);
    
        if (this instanceof clases.mago.Mago) {
            clases.mago.Mago mago = (clases.mago.Mago) this;
    
            if (this instanceof clases.mago.Hechicero) {
                System.out.println("║ Maná: " + AZUL + "∞" + GREEN + " - Usos: ILIMITADOS");
            } else {
                System.out.println("║ Maná: " + AZUL + mago.getMana() + "/" + mago.getManaMaximo() + GREEN + " - Coste habilidad: 5 de maná");
            }
        }
    
        if (this instanceof clases.guerrero.Guerrero) {
            clases.guerrero.Guerrero g = (clases.guerrero.Guerrero) this;
            System.out.println("║ Usos habilidad: " + AZUL + g.getUsos() + "/" + g.getUsosMaximos() + GREEN);
        }
    
        if (this instanceof clases.ladron.Ladron) {
            clases.ladron.Ladron l = (clases.ladron.Ladron) this;
            System.out.println("║ Usos habilidad: " + AZUL + l.getUsos() + GREEN);
        }
    
        if (this instanceof clases.guerrero.Barbaro) {
            clases.guerrero.Barbaro b = (clases.guerrero.Barbaro) this;
            System.out.println("║ Furia acumulada: " + AZUL + b.getFuria() + GREEN);
        }
    
        if (this instanceof clases.guerrero.Caballero) {
            clases.guerrero.Caballero c = (clases.guerrero.Caballero) this;
            System.out.println("║ Escudo acumulado: " + AZUL + c.getEscudo() + GREEN);
        }
    
        if (isEscudoActivo()) {
            System.out.println("║ Escudo temporal: " + AZUL + "ACTIVO" + GREEN);
        }
    
        System.out.println("╚════════════════════════════════════════════════════════");
    }
    

    public boolean isEscudoActivo() { 
        return escudoActivo;
    }
    public void setEscudoActivo(boolean valor) {
        escudoActivo = valor; 
    }
    
}