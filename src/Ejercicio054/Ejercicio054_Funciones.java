package Ejercicio054;

import java.util.Random;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 054 | 2025-10-15
 */
public class Ejercicio054_Funciones {

    private static Random generadorAleatorio = new Random(System.currentTimeMillis());

    /**
     * Simula la función rand() para obtener un número entre 1 y 15.
     * @return Número entero aleatorio entre 1 y 15, ambos inclusive.
     */
    public static int obtenerCantidadAleatoria() {
        // nextInt(15) genera [0, 14], al sumar 1, el rango es [1, 15]
        return generadorAleatorio.nextInt(15) + 1;
    }

    /**
     * Imprime un carácter 'Y' un número específico de veces, separado por un espacio.
     * @param caracterY El carácter a imprimir.
     * @param repeticiones El número de veces que se debe imprimir.
     */
    public static void imprimirCaracter(char caracterY, int repeticiones) {
        for (int i = 0; i < repeticiones; i++) {
            System.out.print(caracterY + " ");
        }
        System.out.println(); // Salto de línea al finalizar la fila
    }

    /**
     * Imprime el primer conjunto de X líneas con caracteres aleatorios y cuenta el total de caracteres.
     * @param numX El número de líneas a imprimir (5 a 20).
     * @param caracterY El carácter a imprimir.
     * @return El total de caracteres impresos en la primera salida.
     */
    public static int imprimirPrimerBloque(int numX, char caracterY) {
        int totalCaracteresImpresos = 0;
        System.out.println("\n--- PRIMERA IMPRESIÓN (Cantidad aleatoria) ---");

        for (int i = 1; i <= numX; i++) {
            int cantidadY = obtenerCantidadAleatoria();
            imprimirCaracter(caracterY, cantidadY);
            totalCaracteresImpresos += cantidadY;
        }
        return totalCaracteresImpresos;
    }

    /**
     * Imprime el segundo conjunto de X líneas basando la cantidad de caracteres en el total contado.
     * @param numX El número de líneas a imprimir.
     * @param caracterY El carácter a imprimir.
     * @param totalContado La cantidad total de caracteres de la primera salida.
     */
    public static void imprimirSegundoBloque(int numX, char caracterY, int totalContado) {
        System.out.println("\n--- SEGUNDA IMPRESIÓN (Cantidad basada en Total: " + totalContado + ") ---");

        // La cantidad de caracteres por línea es (Total Contado / X)
        // Usamos la división entera para mantener la coherencia si X no divide perfectamente al total
        int cantidadBase = totalContado / numX;

        for (int i = 1; i <= numX; i++) {
            imprimirCaracter(caracterY, cantidadBase);
        }
    }
}