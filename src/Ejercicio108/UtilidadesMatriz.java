package Ejercicio108;

import java.util.Random;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 108 | 2025-10-21
 * Librería propia para manipulación de matrices y utilidades de control.
 */
public class UtilidadesMatriz {

    public static final int TAMANO = 5;
    private static final Random random = new Random();

    /**
     * Inicializa una matriz de tamaño 5x5 con el valor 0.
     * @return La matriz 5x5 inicializada.
     */
    public static int[][] inicializarMatriz() {
        // a. Una función que inicializa la matriz en 0.
        return new int[TAMANO][TAMANO];
    }

    /**
     * Genera un índice aleatorio válido para la matriz (0 a TAMANO-1).
     * @return Un entero aleatorio para el índice (i o j).
     */
    public static int generarIndiceAleatorio() {
        // c.ii. Los valores de i y de j se generan aleatoriamente (entre 0 y 4).
        return random.nextInt(TAMANO);
    }

    /**
     * Simula la limpieza de pantalla imprimiendo varias líneas vacías.
     */
    public static void limpiarPantalla() {
        // d. Cada vez que el usuario ingrese un valor se debe limpiar la pantalla
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Verifica si la matriz está completamente llena (no contiene ceros).
     * @param matriz La matriz 5x5.
     * @return true si todas las celdas son diferentes de cero.
     */
    public static boolean estaCompleta(int[][] matriz) {
        // e. Seguir hasta que la matriz esté completa.
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (matriz[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}