package partida;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

import personajes.Personaje;
import static ansi.Ansi.*;

/**
 * Clase para almacenar las estadísticas de una partida.
 */
public class Partida {

    private int enemigosDerrotados;
    private int dañoTotalInfligido;
    private int dañoRecibido;
    private int habilidadesUsadas;  
    private int objetosUsados;  
    private int ultimaSala;
    private LocalDateTime fechaInicio;
    private LocalDateTime horaFin;

    public Partida() {
        this.enemigosDerrotados = 0;
        this.dañoTotalInfligido = 0;
        this.dañoRecibido = 0;
        this.habilidadesUsadas = 0;
        this.objetosUsados = 0;
        this.ultimaSala = 1;
        this.fechaInicio = LocalDateTime.now(); // Guarda la fecha y hora al inicio
    }

    public void finalizarPartida() {
        this.horaFin = LocalDateTime.now(); // Guarda la hora cuando termina la partida
    }

    public void aumentarEnemigosDerrotados() {
        this.enemigosDerrotados++;
    }

    public void sumarDañoInfligido(int daño) {
        this.dañoTotalInfligido += daño;
    }

    public void sumarDañoRecibido(int daño) {
        this.dañoRecibido += daño;
    }

    public void aumentarHabilidadesUsadas() {
        this.habilidadesUsadas++;
    }

    public void aumentarObjetosUsados() {
        this.objetosUsados++;
    }
    
    public void aumentarSalas() {
        this.ultimaSala++;
    }

    public void mostrarEstadisticas(Personaje pj1) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println(GREEN + "\n═══════════════════════════");
        System.out.println("   RESUMEN DE LA PARTIDA");
        System.out.println("═══════════════════════════");
        System.out.println("Fecha y hora de inicio: " + AZUL + fechaInicio.format(formatter) + GREEN);
        System.out.println("Fecha y hora de fin: " + AZUL + (horaFin != null ? horaFin.format(formatter) : "Partida en curso") + GREEN);
        System.out.println("Última sala alcanzada: " +  AZUL + this.ultimaSala);
        
        getDuracionPartida();

        System.out.println("Clase del personaje: " + AZUL + pj1.getNombre() + GREEN);
        System.out.println("Enemigos derrotados: " + AZUL + enemigosDerrotados + GREEN);
        System.out.println("Daño total infligido: " + AZUL + dañoTotalInfligido + GREEN);
        System.out.println("Daño total recibido: " + AZUL + dañoRecibido + GREEN);
        System.out.println("Habilidades usadas: " + AZUL + habilidadesUsadas + GREEN);
        System.out.println("Objetos usados: " + AZUL + objetosUsados + GREEN);
        System.out.println("═══════════════════════════\n");
    }

    public void getDuracionPartida() {
        if (horaFin != null) {
            Duration duracion = Duration.between(fechaInicio, horaFin);
            long minutos = duracion.toMinutes();
            long segundos = duracion.getSeconds() % 60;
            System.out.println(GREEN + "Tiempo total jugado: " + AZUL + minutos + GREEN + " minutos y " + AZUL + segundos + GREEN + " segundos");
        }

    }
}
