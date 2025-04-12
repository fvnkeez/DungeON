package partida;

import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import personajes.Personaje;
import static ansi.Ansi.*;


/**
 * Clase para almacenar las estadísticas de una partida.
 */
public class Partida {
    private Personaje personaje;
    private String nombreJugador;
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

    public void mostrarEstadisticas() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println(GREEN + "\n═══════════════════════════");
        System.out.println("   RESUMEN DE LA PARTIDA");
        System.out.println("═══════════════════════════");
        System.out.println("Fecha y hora de inicio: " + AZUL + fechaInicio.format(formatter) + GREEN);
        System.out.println("Fecha y hora de fin: " + AZUL + (horaFin != null ? horaFin.format(formatter) : "Partida en curso") + GREEN);
        System.out.println("Última sala alcanzada: " +  AZUL + this.ultimaSala);
        
        getDuracionPartida();

        System.out.println("Clase del personaje: " + AZUL + (personaje != null ? personaje.getNombre() : "Desconocido") + GREEN);
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

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void setNombreJugador (String nombre) {
        this.nombreJugador = nombre;
    }
    
    public static void mostrarHistorialPartidas(ArrayList<Partida> historialPartidas) {
        if (historialPartidas.isEmpty()) {
            System.out.println("No hay partidas jugadas aún.");
        } else {
            System.out.println("\n" + BOLD + "========= HISTORIAL DE PARTIDAS =========" + RESET +GREEN);
            for (int i = 0; i < historialPartidas.size(); i++) {
                System.out.println("\n" + BOLD + "PARTIDA #" + (i + 1) + RESET + GREEN);
                historialPartidas.get(i).mostrarEstadisticas();
            }
        }
    }

    public void guardarEnFichero() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Duration duracion = Duration.between(fechaInicio, horaFin);
        long horas = duracion.toHours();
        long minutos = duracion.toMinutes() % 60;
        long segundos = duracion.getSeconds() % 60;
        
        String resultado = personaje.getSalud() > 0 ? "VICTORIA" : "DERROTA";

        String linea = String.format(
            "Jugador: %s | Fecha: %s | Duración: %02d:%02d:%02d | Resultado: %s | Sala: %d | Enemigos derrotados: %d | Daño infligido: %d | Daño recibido: %d | Habilidades usadas: %d | Objetos usados: %d\n",
            nombreJugador != null ? nombreJugador : personaje.getNombre(),
            fechaInicio.format(formatter),
            horas, minutos, segundos,
            resultado,
            ultimaSala,
            enemigosDerrotados,
            dañoTotalInfligido,
            dañoRecibido,
            habilidadesUsadas,
            objetosUsados
        );
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("partidas.txt", true))) {
            writer.write(linea);
        } catch (IOException e) {
            System.out.println("Error al guardar la partida en el fichero.");
        }   
    }

    public static void mostrarHistorialDesdeFichero() {
        File archivo = new File("partidas.txt");
        if (!archivo.exists()) {
            System.out.println("No hay partidas guardadas en el fichero.");
            return;
        }
    
        System.out.println(BOLD + "\n═══════════════════════════════════════════════════════════════════════" + RESET + GREEN);
        System.out.println("                  HISTORIAL DE PARTIDAS GUARDADAS");
        System.out.println("═══════════════════════════════════════════════════════════════════════" + GREEN);
    
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 1;
            while ((linea = reader.readLine()) != null) {
                System.out.println(GREEN + "\n┌─────────────────────────────── PARTIDA #" + contador + " ───────────────────────────────┐" + GREEN);
    
                String[] datos = linea.split("\\|");
                for (String dato : datos) {
                    String[] partes = dato.trim().split(":", 2);
                    if (partes.length == 2) {
                        System.out.printf("│ %-20s : %s\n", AZUL + partes[0].trim() + GREEN, partes[1].trim());
                    }
                }
    
                System.out.println(GREEN + "└────────────────────────────────────────────────────────────────────┘" + GREEN);
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el historial de partidas.");
        }
    }
    


}
