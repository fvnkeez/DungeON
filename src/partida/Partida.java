package partida;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

import personajes.Personaje;

/**
 * Clase para almacenar las estadísticas de una partida.
 */
public class Partida {

    private static final String ANSI_GREEN = "\033[38;2;0;255;85m";
    private static final String ANSI_LG = "\u001B[36m";

    private int enemigosDerrotados;
    private int dañoTotalInfligido;
    private int dañoRecibido;
    private int habilidadesUsadas;  
    private int ultimaSala;
    private LocalDateTime fechaInicio;
    private LocalDateTime horaFin;

    public Partida() {
        this.enemigosDerrotados = 0;
        this.dañoTotalInfligido = 0;
        this.dañoRecibido = 0;
        this.habilidadesUsadas = 0;
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
    
    public void aumentarSalas() {
        this.ultimaSala++;
    }

    public void mostrarEstadisticas(Personaje pj1) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println(ANSI_GREEN + "\n═══════════════════════════");
        System.out.println("   RESUMEN DE LA PARTIDA");
        System.out.println("═══════════════════════════");
        System.out.println("Fecha y hora de inicio: " + ANSI_LG + fechaInicio.format(formatter) + ANSI_GREEN);
        System.out.println("Fecha y hora de fin: " + ANSI_LG + (horaFin != null ? horaFin.format(formatter) : "Partida en curso") + ANSI_GREEN);
        System.out.println("Última sala alcanzada: " +  ANSI_LG + this.ultimaSala);
        
        if (horaFin != null) {
            Duration duracion = Duration.between(fechaInicio, horaFin);
            long minutos = duracion.toMinutes();
            long segundos = duracion.getSeconds() % 60;
            System.out.println("Tiempo total jugado: " + ANSI_LG + minutos + " minutos y " + segundos + " segundos" + ANSI_GREEN);
        }

        System.out.println("Clase del personaje: " + ANSI_LG + pj1.getNombre() + ANSI_GREEN);
        System.out.println("Enemigos derrotados: " + ANSI_LG + enemigosDerrotados + ANSI_GREEN);
        System.out.println("Daño total infligido: " + ANSI_LG + dañoTotalInfligido + ANSI_GREEN);
        System.out.println("Daño total recibido: " + ANSI_LG + dañoRecibido + ANSI_GREEN);
        System.out.println("Habilidades usadas: " + ANSI_LG + habilidadesUsadas + ANSI_GREEN);
        System.out.println("═══════════════════════════\n");
    }
}
