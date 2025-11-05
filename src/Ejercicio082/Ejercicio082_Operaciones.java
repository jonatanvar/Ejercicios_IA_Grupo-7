package Ejercicio082;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 082 | 2025-11-04
 */

public class Ejercicio082_Operaciones {

    /**
     * Usa la librería propia para dibujar el cuadrado.
     */
    public static void dibujarCuadradoConLibreria(int lado, char caracter, int idioma) {
        String msg = (idioma == 2) ? "DRAWING SQUARE WITH LIBRARY..." : "DIBUJANDO CUADRADO CON LIBRERÍA...";
        System.out.println("\n" + msg + "\n");
        Ejercicio082_LibreriaFiguras.dibujarCuadrado(lado, caracter);
        System.out.println();
    }
}