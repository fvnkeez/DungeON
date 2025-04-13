package ansi;

/*
 * Clase ANSI con colores para mostrar por consola, llamándolos mediante static y nombre de variable
 */
public class Ansi {
    public static final String RESET = "\u001B[0m";

    // Colores vivos
    public static final String RED = "\u001B[38;5;196m";
    public static final String GREEN = "\033[38;2;0;255;85m";       // Verde brillante
    public static final String AZUL = "\u001B[36m";                  // Cian claro
    public static final String BY = "\u001B[93m";                    // Amarillo brillante
    public static final String BOLD = "\u001B[1m";
    public static final String MORADO = "\u001B[95m";


    // Nuevos colores
    public static final String DARK_GREEN = "\033[38;2;0;100;0m";    // Verde oscuro
    public static final String DARK_BLUE = "\033[38;2;0;0;139m";     // Azul oscuro
    public static final String LIGHT_GRAY = "\033[38;2;211;211;211m"; // Gris claro
    public static final String ORANGE = "\033[38;2;255;165;0m";      // Naranja

    // Fondo para destacar líneas completas
    public static final String BG_DARK = "\033[48;2;30;30;30m";      // Fondo gris oscuro
}
