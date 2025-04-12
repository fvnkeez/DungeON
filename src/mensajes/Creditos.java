package mensajes;

/**
 * FECHA: 10/02/2025
 * @version 1.4
 * @author Dani Fuente
 * Descripción: Muestra los créditos del videojuego.
 */
public class Creditos {
    public static void mostrarCreditos() {

        String creditosJuego = """
         
        Desarrollador: Daniel Fuente
        Debugger: Samuel Díaz
        Diseñadores de personajes: Jean Pierre Haro y Daniel Fuente
        Testers: Consuelo Parra, Guillermo Sierra, Adrián Sánchez

        """;;
        
        System.out.println(creditosJuego);

    }
    
}
