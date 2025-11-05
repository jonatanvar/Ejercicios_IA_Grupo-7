package Ejercicio094_KevinLainez;

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
 * Clase MiLibreria: Librería propia de utilidades estéticas, de formato y de manejo de ficheros.
 * Contiene métodos estáticos para crear bordes, centrar texto, mostrar el sello y funciones de I/O.
 */
public class MiLibreria {

    // --- CÓDIGO ESTÉTICO (Constantes) ---
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    // Getters para las constantes públicas
    public static int getANCHO() { return ANCHO; }
    public static char getBORDE_IZQ() { return BORDE_IZQ; }
    public static char getBORDE_DER() { return BORDE_DER; }

    // --- FUNCIONES DE FORMATO ---

    /**
     * Centra un texto dentro del ancho especificado (70 caracteres).
     */
    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    /**
     * Dibuja una línea horizontal para los bordes del cuadro.
     */
    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    // --- FUNCIONES DE PRESENTACIÓN ---

    /**
     * Muestra el cuadro de bienvenida general.
     */
    public static void mostrarSaludo(String titulo) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL PROGRAMA DE KEVIN LAINEZ!"));
        System.out.println(centrarTexto(titulo));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    /**
     * Muestra el sello personalizado (versión corta).
     * @param numEjercicio El número del ejercicio actual para incluir en el sello.
     */
    public static void mostrarSelloCorto(String numEjercicio) {
        String sello = "Kevin Lainez | klainezs@unah.hn | " + numEjercicio + " | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    // --- FUNCIONES DE MANEJO DE FICHEROS (Ej. 85) ---

    /**
     * Almacena línea por línea de un archivo en las posiciones de un arreglo String unidireccional.
     * La función asume que el arreglo tiene el tamaño suficiente para almacenar las líneas.
     * @param vector El arreglo de tipo String en el que se almacenarán las líneas.
     * @param nombreArchivo La ruta o nombre del archivo a leer.
     * @return true si la lectura fue exitosa, false si hubo un error de archivo o el vector es muy pequeño.
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

    /**
     * Crea un archivo de texto con contenido de prueba (Auxiliar).
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