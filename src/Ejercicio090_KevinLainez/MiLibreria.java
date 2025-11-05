package Ejercicio090_KevinLainez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | LIBRERIA | 2025-11-03             │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase MiLibreria: Contiene utilidades estéticas (Ej. 81) y la función
 * de manejo de ficheros (Ej. 85).
 */
public class MiLibreria {

    // --- CÓDIGO ESTÉTICO (Reutilizado del Ej. 81) ---
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static int getANCHO() { return ANCHO; }
    public static char getBORDE_IZQ() { return BORDE_IZQ; }
    public static char getBORDE_DER() { return BORDE_DER; }

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSaludo(String titulo) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO!"));
        System.out.println(centrarTexto(titulo));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto(String numEjercicio) {
        String sello = "Kevin Lainez | klainezs@unah.hn | " + numEjercicio + " | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    // --- FUNCIÓN CENTRAL DEL EJERCICIO 85 (Ficheros) ---

    /**
     * Almacena línea por línea de un archivo en las posiciones de un arreglo String.
     * @param vector El arreglo de tipo String en el que se almacenarán las líneas.
     * @param nombreArchivo La ruta o nombre del archivo a leer.
     * @return true si la lectura fue exitosa, false si hubo un error.
     */
    public static boolean leerFicheroAVector(String[] vector, String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            System.out.println(centrarTexto("ERROR: El archivo no existe o la ruta es incorrecta."));
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int i = 0;

            while ((linea = br.readLine()) != null) {
                if (i < vector.length) {
                    vector[i] = linea;
                    i++;
                } else {
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("ADVERTENCIA: Vector lleno. Se detuvo la lectura."));
                    return true;
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            System.out.println(centrarTexto("ERROR de lectura/escritura del fichero: " + e.getMessage()));
            return false;
        }
    }

    // --- FUNCIÓN AUXILIAR DE PRUEBA ---

    /**
     * Crea un archivo de texto con contenido de prueba.
     * @param nombreArchivo Nombre del archivo a crear.
     * @param numLineas Número de líneas de contenido.
     */
    public static void crearArchivoPrueba(String nombreArchivo, int numLineas) {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            for (int i = 1; i <= numLineas; i++) {
                fw.write("Esta es la línea de prueba número " + i + "\n");
            }
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo de prueba: " + e.getMessage());
        }
    }
}