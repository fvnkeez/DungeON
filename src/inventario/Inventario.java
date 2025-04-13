package inventario;

import static ansi.Ansi.*;

import java.util.ArrayList;

/**
 * @date 13/04/2025
 * @version 1.8
 * @author Dani Fuente
 * 
 * Clase que representa el inventario de un personaje en el juego. 
 * Permite añadir, eliminar, mostrar y utilizar objetos durante el combate.
 */
public class Inventario {

    /**
     * Lista de objetos que contiene el inventario.
     */
    private ArrayList<Objeto> objetos;

    /**
     * Constructor de la clase Inventario. 
     * Inicializa la lista de objetos como un ArrayList vacío.
     */
    public Inventario() {
        objetos = new ArrayList<>();
    }

    /**
     * Agrega un objeto al inventario.
     * 
     * @param obj El objeto a añadir.
     * @param mostrarObtenido Si es true, muestra un mensaje indicando que el objeto ha sido obtenido.
     */
    public void agregarObjeto(Objeto obj, boolean mostrarObtenido) {
        objetos.add(obj);
        if (mostrarObtenido) {
            System.out.println("Has obtenido: " + AZUL + obj.getNombre() + GREEN);
        }
    }

    /**
     * Elimina un objeto del inventario por su índice.
     * 
     * @param indice Índice del objeto a eliminar (basado en la posición en la lista).
     */
    public void eliminarObjeto(int indice) {
        objetos.remove(indice);
    }

    /**
     * Devuelve un objeto del inventario dado su índice.
     * 
     * @param indice Índice del objeto a recuperar.
     * @return El objeto ubicado en esa posición de la lista.
     */
    public Objeto getObjeto(int indice) {
        return objetos.get(indice);
    }

    /**
     * Usa un objeto del inventario sobre un personaje o enemigo.
     * 
     * @param indice Índice del objeto a usar.
     * @param pj El personaje que usará el objeto.
     * @param en El enemigo sobre el cual se puede aplicar el objeto (si aplica).
     */
    public void usarObjeto(int indice, personajes.Personaje pj, personajes.Enemigo en) {
        if (indice >= 0 && indice < objetos.size()) {
            objetos.get(indice).usar(pj, en);
            objetos.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    /**
     * Muestra todos los objetos del inventario en formato tabla.
     * Distingue los objetos por tipo: curación, daño o indefinido.
     */
    public void mostrarInventario() {
        if (objetos.isEmpty()) {
            System.out.println(RED + "Tu inventario está vacío." + RESET);
            return;
        }
    
        System.out.println(GREEN + BOLD);
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      INVENTARIO DEL JUGADOR                                            ║");
        System.out.println("╠════╦════════════════════════╦════════════╦═════════════════════════════════════════════╣");
        System.out.println("║ ID ║ OBJETO                 ║ TIPO       ║ DESCRIPCIÓN                                 ║");
        System.out.println("╠════╬════════════════════════╬════════════╬═════════════════════════════════════════════╣");
    
        for (int i = 0; i < objetos.size(); i++) {
            Objeto obj = objetos.get(i);
            String tipoTextoPlano = "? OTRO";
        
            if (obj instanceof PocionCura) {
                tipoTextoPlano = "+ CURA";
            } else if (obj instanceof Bomba) {
                tipoTextoPlano = "- DAÑO";
            }
        
            System.out.printf("║ %-2d ║ %-22s ║ %-10s ║ %-43s ║\n",
                i + 1,
                obj.getNombre(),
                tipoTextoPlano,
                obj.getDescripcion()
            );
        }
    
        System.out.println("╠════╩════════════════════════╩════════════╩═════════════════════════════════════════════╣");
        System.out.println("║ 0) Volver                                                                              ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════╝" + RESET + GREEN);
    }

    /**
     * Comprueba si el inventario está vacío.
     * 
     * @return true si no hay objetos, false si contiene al menos uno.
     */
    public boolean estaVacio() {
        return objetos.isEmpty();
    }

    /**
     * Devuelve la cantidad de objetos actuales en el inventario.
     * 
     * @return Número total de objetos en la lista.
     */
    public int getSize() {
        return objetos.size();
    }
}
