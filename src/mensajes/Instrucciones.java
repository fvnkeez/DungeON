package mensajes;

/**
 * FECHA: 10/02/2025
 * @version 1.4
 * @author Dani Fuente
 * Descripción: String con las instrucciones del juego.
 */
public class Instrucciones {

    public static void mostrarInstrucciones() {
    String instruccionesJuego = """

    dungeON es un RPG por turnos en el que tendrás que combatir enemigos hasta llegar al jefe final. 
    Podrás elegir una clase seleccionándola desde el menú de Clase. Para ello debes elegir el número de la clase ( 1) En el caso del guerrero ) y dar a Enter. 
    Desde ahí tendrás la clase GUERRERO asignada, la cual tendrá 200 de HP y un arma inicial.
    A partir de ahora deberás derrotar enemigos, los cuáles tendrán un determinado nivel de vida, que tendrás que bajar por debajo de 0 para avanzar a la siguiente sala.
    Puedes restarle vida a los enemigos mediante los comando 1) ATACAR, 2) HABILIDADES o 3) OBJETO
    ¡Pero cuidado! Ellos también te atacarán despues de tu turno, pudiendo bajar también tu vida por debajo de 0.
    Tu salud se mantendrá así hasta que la consigas curar mediante objetos o habilidades, y si llega por debajo de 0 terminará tu partida.
            
    """;;

    System.out.println(instruccionesJuego);
    }
}
