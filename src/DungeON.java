import static ansi.Ansi.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import clases.guerrero.*;
import clases.ladron.*;
import clases.mago.*;
import inventario.*;
import mensajes.*;
import partida.*;
import personajes.*;
import resources.ReproductorMusica;
import utilidades.*;


/**
 * @author Dani Fuente
 * @version 1.8
 * @date 13/04/2025
 * Programa principal del videojuego DungeON
 */
public class DungeON {
    /**
     * Variable para crear luego el objeto partida
     */
    private static Partida partida;
    private static ReproductorMusica reproductor = new ReproductorMusica();
    private static ArrayList<Partida> historialPartidas = new ArrayList<>();


    /**
     * Muestra el menú principal del juego y maneja las opciones seleccionadas por el usuario.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void menuPrincipal() throws IOException {
        
        reproductor.reproducirMusica("/Resources/musicaMenu.wav");
        MensajeBienvenida.mostrarBienvenida();

        boolean salidaMenu = false;
        int eleccionMenu;

        do {
            try {
                mostrarMenuPrincipal();
                eleccionMenu = Utils.leerNumeroEntre(1,4);

                switch (eleccionMenu) {
                    case 1:
                        System.out.println("\nEntrando a partida...\n");
                        salidaMenu = true;
                        break;
                    case 2:
                        Instrucciones.mostrarInstrucciones();
                        break;
                    case 3:
                        Creditos.mostrarCreditos();
                        break;
                    case 4:
                        Partida.mostrarHistorialDesdeFichero();
                        break;
                    case 5:
                        System.out.println(RED + "\nSaliendo del juego...\n" + GREEN);
                        System.exit(0);
                    default:
                        System.out.println("Número no válido, introduce 1, 2 o 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Sólo se pueden introducir números. Introduce 1 / 2 / 3 / 4");
            }
        } while (!salidaMenu);
    }

    /**
     * Muestra el menú principal del juego con las opciones disponibles.
     */
    public static void mostrarMenuPrincipal() {

        System.out.println(GREEN + "╔════════════════════════════════════════════════╗");
        System.out.println("║              ELIGE OPCIÓN DE MENÚ              ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║ 1) JUGAR                                       ║");
        System.out.println("║ 2) INSTRUCCIONES                               ║");
        System.out.println("║ 3) CRÉDITOS                                    ║");
        System.out.println("║ 4) MOSTRAR HISTORIAL PARTIDAS                  ║");
        System.out.println("║ 5) SALIR                                       ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    /**
     * Maneja el combate entre el personaje del jugador y los enemigos.
     * 
     * @param pj1 El personaje del jugador.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void menuCombate(Partida partida) throws IOException {

        boolean salirJuego;
        partida = new Partida();

        do {

            Personaje pj1 = menuClase();
            String nombreJugador = Utils.leerCadena("Introduce tu nombre o apodo:");
            partida.setNombreJugador(nombreJugador);
            partida.setPersonaje(pj1);
            iniciarCombate(pj1, partida);
            partida.finalizarPartida(); // Registrar la hora de finalización de la partida
            partida.guardarEnFichero();
            partida.mostrarEstadisticas();
            historialPartidas.add(partida); // Guardar la partida en el historial
            salirJuego = !preguntarContinuar();

        } while (!salirJuego);

        System.out.println(RED + "Saliendo del juego..." + GREEN);
    }

    /**
     * Muestra el menú para elegir la clase del personaje y crea una instancia del personaje seleccionado.
     * En el caso del Mago, empieza con una cantidad base de 20 de maná, es un atributo específico de Clase.
     * 
     * @return Personaje creado según la clase seleccionada.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static Personaje menuClase() throws IOException {

        final int SALUD_GUERRERO = 200, SALUD_MAGO = 150, SALUD_LADRON = 175;
        int dañoGuerrero = 7, dañoMago = 9, dañoLadron = 8;
        boolean salidaClase = false;
        Personaje pj1 = null;

        do {
            System.out.println(GREEN + "╔══════════════════════════════════╗");
            System.out.println("║        ELIGE UNA CLASE           ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║ CLASES PRINCIPALES               ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("║ 1) GUERRERO                      ║");
            System.out.println("║ 2) LADRÓN                        ║");
            System.out.println("║ 3) MAGO                          ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║ SUBCLASES                        ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("║ 4) CABALLERO          (GUERRERO) ║");
            System.out.println("║ 5) BÁRBARO            (GUERRERO) ║");
            System.out.println("║ 6) FANTASMA            (LADRÓN)  ║");
            System.out.println("║ 7) PÍCARO              (LADRÓN)  ║");
            System.out.println("║ 8) HECHICERO            (MAGO)   ║");
            System.out.println("║ 9) OCULTISTA            (MAGO)   ║");
            System.out.println("╚══════════════════════════════════╝");

            int claseJugador = Utils.leerNumeroEntre(1, 9);

            switch (claseJugador) {
                case 1:
                    pj1 = new Guerrero( "GUERRERO",SALUD_GUERRERO, dañoGuerrero,1, 0, 10, 3, 3);
                    salidaClase = true;
                    break;
                case 2:
                    pj1 = new Ladron( "LADRÓN", SALUD_LADRON, dañoLadron,1, 0, 10, 3);
                    salidaClase = true;
                    break;  
                case 3:
                    pj1 = new Mago("MAGO", SALUD_MAGO, dañoMago, 20, 50, 1, 0, 10);
                    salidaClase = true;
                    pj1.getInventario().agregarObjeto(new ElixirMana(10), false);

                    break;
                case 4:
                    pj1 = new Caballero("CABALLERO", SALUD_GUERRERO, dañoGuerrero, 1, 0, 0, 10, 3, 3);
                    salidaClase = true;
                    break;
                case 5:
                    pj1 = new Barbaro("BARBARO", SALUD_GUERRERO, dañoGuerrero, 1, 0, 10, 3,3 );
                    salidaClase = true;
                    break;
                case 6:
                    pj1 = new Fantasma( "FANTASMA", SALUD_LADRON, dañoLadron,1, 0, 10, 3);
                    salidaClase = true;
                    break;
                case 7:
                    pj1 = new Picaro( "PICARO", SALUD_LADRON, dañoLadron,1, 0, 10, 0);
                    salidaClase = true;
                    break;
                case 8:
                    pj1 = new Hechicero("HECHICERO", SALUD_MAGO, dañoMago, 20, 50, 1, 0, 10);
                    salidaClase = true;
                    pj1.getInventario().agregarObjeto(new ElixirMana(10), false);
                    break;
                case 9:
                    pj1 = new Ocultista("OCULTISTA", SALUD_MAGO, dañoMago, 20, 50, 1, 0, 10);
                    salidaClase = true;
                    pj1.getInventario().agregarObjeto(new ElixirMana(10), false);
                    break;
     
                default:
                    System.out.println("Número no válido, introduce un número dentro del rango.");
            }

        } while (!salidaClase);

        // Se agrega una poción y una bomba por defecto al crear el personaje
        if (pj1 != null) {
            pj1.getInventario().agregarObjeto(new PocionCura(1, 25), false);
            pj1.getInventario().agregarObjeto(new Bomba(2, 15), false);
        }

        return pj1;
    }

    /**
     * Inicia un combate entre el personaje del jugador y un enemigo generado.
     * 
     * @param pj1 El personaje del jugador.
     * @param partida El objeto partida de la clase Partida.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void iniciarCombate(Personaje pj1, Partida partida) throws IOException {
        reproductor.detenerMusica();
        reproductor.reproducirMusica("/Resources/musicaCombate.wav");
        pj1.restaurarSalud();
        pj1.restaurarExp();
        pj1.setNivel(1);

        mostrarInicioCombate(pj1);
    
        int sala = 1;
        boolean jugadorDerrotado = false;

        if (pj1 instanceof Picaro) {
            ((Picaro) pj1).reiniciarHabilidad();
        }
        
        while (!jugadorDerrotado) {

            if (sala == 6) {

                reproductor.reproducirMusica("/Resources/musicaBossFinal.wav");
                SalaFinal.mostrarSalaFinal();
                Enemigo jefeFinal = new JefeFinal();
                lucharContraJefeFinal(pj1, jefeFinal, partida);
                jugadorDerrotado = pj1.getSalud() <= 0;
                break; // Cambiar esto
                
            }else {

                System.out.println(GREEN + "\n╔════════════════════════════════╗");
                System.out.println("║        SALA ACTUAL: " + AZUL + sala + GREEN + "          ║");
                System.out.println("╚════════════════════════════════╝");
        
                Enemigo enemigo = generarEnemigo();
    
                if (pj1 instanceof Picaro) {
                    System.out.println(BOLD + BY +"\n¡El pícaro actúa antes de que el combate comience!" + RESET + GREEN);
                    ((Picaro) pj1).usarHabilidad(enemigo, partida);
                }
        
                while (enemigo.getSalud() > 0 && pj1.getSalud() > 0) {
                    pj1.mostrarEstado();
                    int eleccion = obtenerAccionJugador();
                    ejecutarAccion(eleccion, pj1, enemigo, partida);
        
                    if (enemigo.getSalud() > 0) {
                        ejecutarAtaqueEnemigo(pj1, enemigo, partida);
                    }
                }
        
                if (pj1.getSalud() <= 0) {
                    MensajeDerrota.mostrarDerrota();
                    jugadorDerrotado = true;
                } else {
                    comprobarFinCombate(enemigo, partida, pj1);
                    if (pj1 instanceof Picaro) {
                        ((Picaro) pj1).reiniciarHabilidad();
                    }
                    sala++;
                }
            }
        }
    }
    

    /**
     * Método que muestra la salud restante del enemigo si está por debajo de 0, o mensaje de derrota
     * del Enemigo si le hemos vencido.
     * @param enemigo
    */
    public static void comprobarFinCombate(Enemigo enemigo, Partida partida, Personaje pj1)throws IOException {
        if (enemigo.getSalud() > 0) {
            System.out.println("PRUEBA AQUI DEPURACION");
        } else {
            partida.aumentarSalas();
            partida.aumentarEnemigosDerrotados();
            System.out.println(BY + "El enemigo ha sido derrotado.");
            pj1.ganarExp(enemigo.getExpConcedida());
    
            // Posibilidad de ganar objeto del enemigo
            if (!enemigo.getInventario().estaVacio()) {
                Random r = new Random();
                if (r.nextDouble() < 0.5) {
                    int index = r.nextInt(enemigo.getInventario().getSize());
                    Objeto objetoGanado = enemigo.getInventario().getObjeto(index);
                    pj1.getInventario().agregarObjeto(objetoGanado, true);
                    System.out.println(GREEN + "¡Has obtenido un objeto del enemigo derrotado!" + GREEN);
                }
            }
    
            System.out.println(GREEN + "\n¡Has avanzado a la siguiente sala!" + GREEN);
        }
    }
    

    /**
     * Genera un enemigo aleatorio para el combate.
     * 
     * @return Enemigo generado.
     */
    public static Enemigo generarEnemigo() {

        Enemigo enemigo = new Enemigo();
        System.out.println(GREEN + "Ha aparecido el enemigo: " + RED + enemigo.getNombre() + GREEN);
        System.out.println("Salud del enemigo: " + RED + enemigo.getSalud() + GREEN);
        System.out.println("Daño del enemigo: " + RED + enemigo.getArma() + GREEN);
        
        if (enemigo != null) {
            enemigo.getInventario().agregarObjeto(new PocionCura(1, 25), false);
            enemigo.getInventario().agregarObjeto(new PocionCura(1, 25), false);
            enemigo.getInventario().agregarObjeto(new Bomba(2, 15), false);
            enemigo.getInventario().agregarObjeto(new Bomba(2, 15), false);
            enemigo.getInventario().agregarObjeto(new ElixirMana(10), false);
            enemigo.getInventario().agregarObjeto(new ElixirMana(10), false);
            enemigo.getInventario().agregarObjeto(new EscudoTemporal(), false);
            enemigo.getInventario().agregarObjeto(new EscudoTemporal(), false);
        }

        return enemigo;
    }

    /**
     * Muestra la información inicial del combate, incluyendo la clase, salud y daño del personaje.
     * 
     * @param pj1 El personaje del jugador.
     */
    public static void mostrarInicioCombate(Personaje pj1) {

        System.out.println(GREEN + "Has elegido la clase: " + AZUL + pj1.getNombre() + GREEN);
        System.out.println("Tienes: " + AZUL + pj1.getSalud() + GREEN + " de salud");
        System.out.println("Haces: " + AZUL + pj1.getArma() + GREEN + " de daño con tu arma");
        System.out.println(GREEN + "Tu nivel actual es: " + AZUL + pj1.getNivel());
    }

    /**
     * Obtiene la acción que el jugador desea realizar durante el combate.
     * 
     * @return La acción seleccionada por el jugador.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static int obtenerAccionJugador() throws IOException {

        System.out.println(GREEN + "╔══════════════════════════════════╗");
        System.out.println("║        ELIGE UNA ACCIÓN          ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║ 1) ATACAR                        ║");
        System.out.println("║ 2) HABILIDADES                   ║");
        System.out.println("║ 3) INVENTARIO                    ║");
        System.out.println("╚══════════════════════════════════╝");

        return Utils.leerNumeroEntre(1, 3);
    }

    /**
     * Ejecuta la acción seleccionada por el jugador durante el combate.
     * 
     * @param eleccion La acción seleccionada por el jugador.
     * @param pj1 El personaje del jugador.
     * @param enemigo El enemigo actual.
     */
    public static void ejecutarAccion(int eleccion, Personaje pj1, Enemigo enemigo, Partida partida) throws IOException {
        boolean turnoTerminado = false;
    
        while (!turnoTerminado) {
            switch (eleccion) {
                case 1:
                    ejecutarAtaqueJugador(pj1, enemigo, partida);
                    turnoTerminado = true; // Se gastó el turno
                break;
    
                case 2:
                    boolean habilidadUsada = pj1.usarHabilidad(enemigo, partida);
                    if (habilidadUsada) {
                        partida.aumentarHabilidadesUsadas(); // Registrar habilidad usada
                        turnoTerminado = true; // Solo termina el turno si la habilidad se usó con éxito
                    } else {
                        System.out.println("Elige otra acción."); // Permitir volver a elegir
                        eleccion = obtenerAccionJugador();
                    }
                break;
    
                case 3:
                    if (!pj1.getInventario().estaVacio()) {
                        pj1.getInventario().mostrarInventario();
                        System.out.println("Elige el ID del objeto que quieres usar:");
                        int opcion = Utils.leerNumeroEntre(0, pj1.getInventario().getSize());

                        if (opcion == 0) {
                            eleccion = obtenerAccionJugador();
                            continue;
                        }

                        Objeto obj = pj1.getInventario().getObjeto(opcion - 1);
                        boolean usado = obj.usar(pj1, enemigo);
                
                        if (usado) {
                            pj1.getInventario().eliminarObjeto(opcion - 1);
                            partida.aumentarObjetosUsados();
                        } else {
                            System.out.println(GREEN + "El objeto no se ha consumido." + GREEN);
                        }
                
                        eleccion = obtenerAccionJugador(); // Volver al menú de acción
                    } else {
                        System.out.println("No tienes objetos en el inventario.");
                        eleccion = obtenerAccionJugador();
                    }
                break;
            }
        }
    }
    
    /**
     * Ejecuta el ataque del jugador contra el enemigo.
     * 
     * @param pj1 El personaje del jugador.
     * @param enemigo El enemigo actual.
     * @param partida El objeto partida.
     */
    public static void ejecutarAtaqueJugador(Personaje pj1, Enemigo enemigo, Partida partida) {

        Random random = new Random();
        double[] MULTIPLICADOR_DAÑO = { 0, 0.5, 0.75, 1, 1, 1.25, 1.5, 1.75, 2 };

        int dañoReal = (int) (pj1.getArma() * MULTIPLICADOR_DAÑO[random.nextInt(MULTIPLICADOR_DAÑO.length)]);
        enemigo.recibirDaño(dañoReal);
        partida.sumarDañoInfligido(dañoReal); // Registra todo el daño infligido y lo suma

        if (dañoReal == (pj1.getArma() * 2)) {
            System.out.println(BOLD + BY + "¡Golpe crítico por valor de: " + dañoReal + "!" + RESET + GREEN);

        } else if (dañoReal == 0) {
            System.out.println(BOLD + BY + "Has fallado el ataque" + RESET + GREEN);

        }else {
            System.out.println("Has realizado un ataque de " + AZUL + dañoReal + GREEN);
        }
        
        if (enemigo.getSalud() > 0) {
            System.out.println(GREEN +"Al enemigo le queda: " + RED + enemigo.getSalud() + "/" + enemigo.getSaludMaxima() + GREEN + " de salud." + GREEN);
        }
    }


    /**
     * Ejecuta el ataque del enemigo contra el jugador.
     * 
     * @param pj1 El personaje del jugador.
     * @param enemigo El enemigo actual.
     * @param partida El objeto partida.
     */
    public static void ejecutarAtaqueEnemigo(Personaje pj1, Enemigo enemigo, Partida partida) {
        Random random = new Random();
        double[] MULTIPLICADOR_DAÑO = { 0, 0, 0.5, 0.5, 0.75, 0.75, 1, 1, 1, 1, 1.25, 1.5, 2 };
    
        int dañoReal = (int) (enemigo.getArma() * MULTIPLICADOR_DAÑO[random.nextInt(MULTIPLICADOR_DAÑO.length)]);

        // Si el jugador es un Fantasma y tiene la evasión activa
        if (pj1 instanceof Fantasma) {
            Fantasma fantasma = (Fantasma) pj1;
            if (fantasma.debeEsquivar()) {
                System.out.println(MORADO + "¡Te desvaneces en el aire y esquivas el ataque enemigo!" + GREEN);
                fantasma.consumirEsquivar();
                return; // Termina el ataque enemigo sin hacer daño
            }
        }

        pj1.recibirDañoJugador(dañoReal);
        partida.sumarDañoRecibido(dañoReal); // Registrar daño recibido
    
        if (dañoReal == (enemigo.getArma() * 2)) {
            System.out.println(BOLD + RED + enemigo.getNombre() + " te hace un GOLPE CRÍTICO de " + dañoReal + RESET + GREEN);
        } else if (dañoReal == 0) {
            System.out.println(BOLD + RED + enemigo.getNombre() + " ha fallado el ataque" + RESET + GREEN);
        } else {
            System.out.println(GREEN + "¡" + RED + enemigo.getNombre() + GREEN + " te ataca por " + RED + dañoReal + GREEN + "!" + GREEN);
        }
    }

    public static void lucharContraJefeFinal(Personaje pj1, Enemigo jefeFinal, Partida partida) throws IOException {

        if (pj1 instanceof Picaro) {
            System.out.println(BOLD + BY +"\n¡El pícaro actúa antes de que el combate comience!" + RESET + GREEN);
            ((Picaro) pj1).usarHabilidad(jefeFinal, partida);
        }
    
        while (jefeFinal.getSalud() > 0 && pj1.getSalud() > 0) {
            pj1.mostrarEstado();
            int eleccion = obtenerAccionJugador();
            ejecutarAccion(eleccion, pj1, jefeFinal, partida);
    
            if (jefeFinal.getSalud() > 0) {
                ejecutarAtaqueEnemigo(pj1, jefeFinal, partida);
            }
        }
    
        if (pj1.getSalud() <= 0) {
            MensajeDerrota.mostrarDerrotaFinal();
        } else {
            reproductor.reproducirMusica("/Resources/musicaVictoria.wav");
            System.out.println(BY + "\n¡HAS VENCIDO AL JEFE FINAL!" + RESET);
            System.out.println(GREEN + "La oscuridad ha sido derrotada, y la luz vuelve a brillar sobre el reino...");
            System.out.println(BOLD + BY + "\n¡Eres una leyenda, campeón de DungeON!" + RESET);
            partida.aumentarEnemigosDerrotados();
        }
    }
    
    /**
     * Pregunta al jugador si desea continuar jugando después de un combate.
     * 
     * @return true si el jugador desea continuar, false en caso contrario.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static boolean preguntarContinuar() throws IOException {

        System.out.println("¿Quieres seguir jugando? 1. Sí / Otro número. No");
        return Utils.leerNumero() == 1;
    }

    /**
     * Método principal que inicia el juego.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan).
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void main(String[] args) throws IOException {
        
        menuPrincipal();
        menuCombate(partida);

    }
}