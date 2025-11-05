package Ejercicio060;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 060 | 2025-11-04
 */

public class Ejercicio060_Operaciones {

    public static void dibujarCuadrado(int lado, char caracter, int idioma) {
        String msg = (idioma == 2) ? "DRAWING SQUARE..." : "DIBUJANDO CUADRADO...";
        System.out.println("\n" + msg + "\n");

        // Fila superior
        for (int i = 0; i < lado; i++) System.out.print(caracter);
        System.out.println();

        // Filas intermedias (huecas)
        for (int i = 0; i < lado - 2; i++) {
            System.out.print(caracter);
            for (int j = 0; j < lado - 2; j++) System.out.print(" ");
            if (lado > 1) System.out.print(caracter);
            System.out.println();
        }

        // Fila inferior (si lado > 1)
        if (lado > 1) {
            for (int i = 0; i < lado; i++) System.out.print(caracter);
            System.out.println();
        }
        System.out.println();
    }
}