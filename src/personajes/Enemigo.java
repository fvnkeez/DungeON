package personajes;

import java.util.Random;

import inventario.Inventario;

/**
 * FECHA: 12/03/2025
 * @version 1.7
 * @author Dani Fuente
 * Descripción: Clase Enemigo, se utiliza para guardar sus atributos y para llamarla cada vez que se reinicia el bucle
 * de combate, creando un enemigo aleatorio nuevo. Ahora hereda de la clase Entidad para reutilizar atributos y métodos comunes.
 */
public class Enemigo extends Entidad {

    private Random random = new Random();
    private Inventario inventario = new Inventario();


    /**
     * Array con el nombre de los enemigos.
     */
    private static final String[] nombreEnemigos = {"ESQUELETO", "NECROMANTE", "ZOMBIE", "ARAÑA", "DEMONIO"};
    /**
     * Array con la salud de los enemigos.
     */
    private static final int[] saludEnemigos = {50, 40, 35, 30, 60};
    /**
     * Array con el daño de los enemigos.
     */
    private static final int[] dañoEnemigos = {10, 15, 8, 5, 20};

    /**
     * Array con la experiencia que da cada enemigo al derrotarlo.
     */
    private static final int[] expConcedidaArray = {7, 8, 5, 4, 10};

     /**
     * Atributo individual que guarda la experiencia que este enemigo concede.
     */
    private int expConcedida;


    /**
     * Constructor de la clase Enemigo. Crea un enemigo aleatorio con atributos basados en los arrays definidos.
     */
    public Enemigo() {
        super("", 0, 0); // Llama al constructor de la clase base (Entidad) con valores iniciales
        int indiceEnemigos = seleccionarEnemigo();
        setNombre(nombreEnemigos[indiceEnemigos]); // Usa el método setNombre de Entidad
        setSalud(saludEnemigos[indiceEnemigos]); // Usa el método setSalud de Entidad
        setArma(dañoEnemigos[indiceEnemigos]); // Usa el método setArma de Entidad
        setSaludMaxima(saludEnemigos[indiceEnemigos]); // Usa el método setSaludMaxima de Entidad
        this.expConcedida = expConcedidaArray[indiceEnemigos]; // Guarda la experiencia correspondiente
    }

    public Enemigo(String nombre, int salud, int daño) {
        super(nombre, salud, daño);
        setSaludMaxima(salud);
    }    

    /**
     * Método para seleccionar un enemigo aleatorio.
     * @return El índice del enemigo seleccionado.
     */
    private int seleccionarEnemigo() {
        return random.nextInt(nombreEnemigos.length);
    }

     /**
     * Devuelve la experiencia que este enemigo concede al ser derrotado.
     * @return experiencia concedida
     */
    public int getExpConcedida() {
        return expConcedida;
    }

    public Inventario getInventario() {
        return inventario;
    }
}