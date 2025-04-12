package inventario;

import static ansi.Ansi.*;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Objeto> objetos;

    public Inventario() {
        objetos = new ArrayList<>();
    }

    public void agregarObjeto(Objeto obj, boolean mostrarObtenido) {
        objetos.add(obj);
        if (mostrarObtenido) {
            System.out.println("Has obtenido: " + AZUL + obj.getNombre() + GREEN);
        }
    }

    public void eliminarObjeto(int indice) {
        objetos.remove(indice);
    }

    public Objeto getObjeto(int indice) {
        return objetos.get(indice);
    }

    public void usarObjeto(int indice, personajes.Personaje pj, personajes.Enemigo en) {
        if (indice >= 0 && indice < objetos.size()) {
            objetos.get(indice).usar(pj, en);
            objetos.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

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
    

    public boolean estaVacio() {
        return objetos.isEmpty();
    }

    public int getSize() {
        return objetos.size();
    }
}
