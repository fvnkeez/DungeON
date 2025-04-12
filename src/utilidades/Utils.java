package utilidades;
import java.io.*;
import java.util.InputMismatchException;

/**
 * Clase con la finalidad de leer valores introducidos por el usuario, en este caso
 * sólo contiene métodos para leer números enteros porque el videojuego no 
 * contiene valores decimales. Tampoco se leen datos por cadena o caracteres.
 */
public class Utils {

    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public static int leerNumero(String mensaje) throws IOException  {
        int numero = 0;
        boolean numeroCorrecto = false;
        do{
            System.out.println(mensaje);
            try {
                numero = Integer.parseInt(buffer.readLine());
                numeroCorrecto = true; 
            } catch (InputMismatchException e) {
                System.out.println("Escribe un número");
            } catch (NumberFormatException e) {
                System.out.println("Tienes que escribir un número");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida.");
            }
 
        } while (!numeroCorrecto);

        return numero;
    }

    public static int leerNumero() throws IOException  {
        int numero = 0;
        boolean numeroCorrecto = false;
        do{
            try {
                numero = Integer.parseInt(buffer.readLine());
                numeroCorrecto = true; 
            } catch (InputMismatchException e) {
                System.out.println("Escribe un número");
            } catch (NumberFormatException e) {
                System.out.println("Tienes que escribir un número");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida.");
            }

        } while (!numeroCorrecto);

        return numero;
    }

    public static int leerNumeroEntre(int numeroMin, int numeroMax)throws IOException{
        int numeroDevolver = 0;
        boolean numeroCorrecto = false;

        do {
            try {
                numeroDevolver = Integer.parseInt(buffer.readLine());
                if (numeroDevolver >= numeroMin && numeroDevolver <= numeroMax) {
                    numeroCorrecto = true;
                } else {
                    System.out.println("Por favor escriba un numero entre " + numeroMin + " y " + numeroMax + " incluidos");
                }



            } catch (InputMismatchException e) {
                System.out.println("Escriba un numero.");
            } catch (NumberFormatException e) {
                System.out.println("Tienes que escribir un número");
            }

        } while (!numeroCorrecto);

        return numeroDevolver;
    }

    public static int leerNumeroEntre(int numeroMin, int numeroMax, String mensaje)throws IOException{
        int numeroDevolver = 0;
        boolean numeroCorrecto = false;

        do {
            System.out.println(mensaje);
            try {
                numeroDevolver = Integer.parseInt(buffer.readLine());
                if (numeroDevolver >= numeroMin && numeroDevolver <= numeroMax) {
                    numeroCorrecto = true;
                } else {
                    System.out.println("Por favor escriba un numero entre " + numeroMin + " y " + numeroMax + " incluidos");
                }
            } catch (InputMismatchException e) {
                System.out.println("Escriba un numero.");
            }

        } while (!numeroCorrecto);

        return numeroDevolver;
    }

    

  


}