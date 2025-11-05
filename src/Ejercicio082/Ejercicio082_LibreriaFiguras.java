package Ejercicio082;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 082 | 2025-11-04
 */

/**
 * Librería propia para dibujar figuras básicas con ciclos.
 * No utiliza arreglos ni entrada/salida directa.
 */
public class Ejercicio082_LibreriaFiguras {

    /**
     * Dibuja un cuadrado hueco usando el carácter especificado.
     * @param lado tamaño del lado (1 a 20)
     * @param caracter carácter para los bordes
     */
    public static void dibujarCuadrado(int lado, char caracter) {
        // Fila superior
        for (int i = 0; i < lado; i++) System.out.print(caracter);
        System.out.println();

        // Filas intermedias
        for (int i = 0; i < lado - 2; i++) {
            System.out.print(caracter);
            for (int j = 0; j < lado - 2; j++) System.out.print(" ");
            if (lado > 1) System.out.print(caracter);
            System.out.println();
        }

        // Fila inferior
        if (lado > 1) {
            for (int i = 0; i < lado; i++) System.out.print(caracter);
            System.out.println();
        }
    }
}