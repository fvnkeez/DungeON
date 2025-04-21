package partida;

import java.time.LocalDateTime;
import java.io.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import personajes.Personaje;
import static ansi.Ansi.*;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * 
 * Clase que representa una partida del jugador.
 * Almacena estadísticas clave como enemigos derrotados, daño causado/recibido, duración,
 * y permite guardar o mostrar el historial de partidas.
 */
public class Partida {

    private Personaje personaje;
    private String nombreJugador;
    private String clasePersonaje;
    private int enemigosDerrotados;
    private int dañoTotalInfligido;
    private int dañoRecibido;
    private int habilidadesUsadas;
    private int objetosUsados;
    private int ultimaSala;
    private LocalDateTime fechaInicio;
    private LocalDateTime horaFin;

    /**
     * Constructor que inicializa una nueva partida con las estadísticas a cero
     * y registra la fecha/hora de inicio.
     */
    public Partida() {
        this.enemigosDerrotados = 0;
        this.dañoTotalInfligido = 0;
        this.dañoRecibido = 0;
        this.habilidadesUsadas = 0;
        this.objetosUsados = 0;
        this.ultimaSala = 1;
        this.fechaInicio = LocalDateTime.now();
    }

    /**
     * Marca la hora de finalización de la partida.
     */
    public void finalizarPartida() {
        this.horaFin = LocalDateTime.now();
    }

    /**
     * Aumenta el contador de enemigos derrotados.
     */
    public void aumentarEnemigosDerrotados() {
        this.enemigosDerrotados++;
    }

    /**
     * Suma el daño infligido al total.
     * @param daño Cantidad de daño causado.
     */
    public void sumarDañoInfligido(int daño) {
        this.dañoTotalInfligido += daño;
    }

    /**
     * Suma el daño recibido al total.
     * @param daño Cantidad de daño recibido.
     */
    public void sumarDañoRecibido(int daño) {
        this.dañoRecibido += daño;
    }

    /**
     * Aumenta el contador de habilidades usadas.
     */
    public void aumentarHabilidadesUsadas() {
        this.habilidadesUsadas++;
    }

    /**
     * Aumenta el contador de objetos usados.
     */
    public void aumentarObjetosUsados() {
        this.objetosUsados++;
    }

    /**
     * Aumenta el número de la última sala alcanzada.
     */
    public void aumentarSalas() {
        this.ultimaSala++;
    }

    /**
     * Muestra por consola todas las estadísticas de la partida actual.
     */
    public void mostrarEstadisticas() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println(GREEN + "\n═══════════════════════════");
        System.out.println("   RESUMEN DE LA PARTIDA");
        System.out.println("═══════════════════════════");
        System.out.println("Fecha y hora de inicio: " + AZUL + fechaInicio.format(formatter) + GREEN);
        System.out.println("Fecha y hora de fin: " + AZUL + (horaFin != null ? horaFin.format(formatter) : "Partida en curso") + GREEN);
        System.out.println("Última sala alcanzada: " + AZUL + this.ultimaSala);

        getDuracionPartida();

        System.out.println("Nombre del jugador: " + AZUL + nombreJugador + GREEN);
        System.out.println("Clase del personaje: " + AZUL + personaje.getNombre() + GREEN);
        System.out.println("Enemigos derrotados: " + AZUL + enemigosDerrotados + GREEN);
        System.out.println("Daño total infligido: " + AZUL + dañoTotalInfligido + GREEN);
        System.out.println("Daño total recibido: " + AZUL + dañoRecibido + GREEN);
        System.out.println("Habilidades usadas: " + AZUL + habilidadesUsadas + GREEN);
        System.out.println("Objetos usados: " + AZUL + objetosUsados + GREEN);
        System.out.println("═══════════════════════════\n");
    }

    /**
     * Muestra por consola la duración total de la partida.
     */
    public void getDuracionPartida() {
        if (horaFin != null) {
            Duration duracion = Duration.between(fechaInicio, horaFin);
            long minutos = duracion.toMinutes();
            long segundos = duracion.getSeconds() % 60;
            System.out.println(GREEN + "Tiempo total jugado: " + AZUL + minutos + GREEN + " minutos y " + AZUL + segundos + GREEN + " segundos");
        }
    }

    /**
     * Asigna el personaje que jugó la partida.
     * @param personaje Objeto personaje.
     */
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
        // También se puede hacer con getNombre pero quería probar con este método que
        // elige directamente el nombre de la Clase de Java.
        this.clasePersonaje = personaje.getClass().getSimpleName();
    }

    /**
     * Asigna el nombre o apodo del jugador.
     * @param nombre Nombre del jugador.
     */
    public void setNombreJugador(String nombre) {
        this.nombreJugador = nombre;
    }

    /**
     * Muestra el historial de partidas almacenado en una lista en memoria.
     * @param historialPartidas Lista de partidas jugadas.
     */
    public static void mostrarHistorialPartidas(ArrayList<Partida> historialPartidas) {
        if (historialPartidas.isEmpty()) {
            System.out.println("No hay partidas jugadas aún.");
        } else {
            System.out.println("\n" + BOLD + "========= HISTORIAL DE PARTIDAS =========" + RESET + GREEN);
            for (int i = 0; i < historialPartidas.size(); i++) {
                System.out.println("\n" + BOLD + "PARTIDA #" + (i + 1) + RESET + GREEN);
                historialPartidas.get(i).mostrarEstadisticas();
            }
        }
    }

    /**
     * Guarda los datos de la partida actual en un archivo de texto plano llamado "partidas.txt".
     */
    public void guardarEnFichero() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Duration duracion = Duration.between(fechaInicio, horaFin);
        long horas = duracion.toHours();
        long minutos = duracion.toMinutes() % 60;
        long segundos = duracion.getSeconds() % 60;

        String resultado = personaje.getSalud() > 0 ? "VICTORIA" : "DERROTA";

        String linea = String.format(
            "Nombre jugador: %s | Clase: %s |Fecha: %s | Duración: %02d:%02d:%02d | Resultado: %s | Sala: %d | Enemigos derrotados: %d | Daño infligido: %d | Daño recibido: %d | Habilidades usadas: %d | Objetos usados: %d\n",
            nombreJugador != null ? nombreJugador : personaje.getNombre(),
            clasePersonaje,
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

    /**
     * Lee y muestra el historial de partidas guardadas desde el archivo "partidas.txt".
     */
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
