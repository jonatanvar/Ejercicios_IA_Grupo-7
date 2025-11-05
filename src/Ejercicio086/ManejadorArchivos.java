package Ejercicio086;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 086 | 2025-10-16
 * Librería propia para manejar operaciones de archivo.
 */
public class ManejadorArchivos {

    private static final String NOMBRE_ARCHIVO = "mensaje_guardado.txt";

    /**
     * Escribe una línea de texto en un archivo, sobrescribiendo el contenido anterior.
     * @param mensaje El texto que se va a escribir en el archivo.
     * @return true si la operación fue exitosa, false en caso de error.
     */
    public static boolean escribirLinea(String mensaje) {
        // Usamos try-with-resources para asegurar que FileWriter y PrintWriter se cierren automáticamente
        try (FileWriter fileWriter = new FileWriter(NOMBRE_ARCHIVO, false); // false = Sobrescribir
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(mensaje);
            return true;
        } catch (IOException e) {
            System.err.println("ERROR al escribir en el archivo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene el nombre del archivo utilizado.
     */
    public static String getNombreArchivo() {
        return NOMBRE_ARCHIVO;
    }
}