package Ejercicio113;

import java.util.Random;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 113 | 2025-10-21
 * Librería propia para inicialización de la matriz de distancias (Grafo).
 */
public class UtilidadesGrafo {

    public static final int NUM_CIUDADES = 10;
    private static final int MIN_DISTANCIA = 20;
    private static final int MAX_DISTANCIA = 600;
    private static final Random random = new Random();

    /**
     * Inicializa la matriz de distancias con valores aleatorios (20KM a 600KM) o 0.
     * @return La matriz de 10x10 de distancias.
     */
    public static int[][] inicializarMatrizDistancias() {
        int[][] distancias = new int[NUM_CIUDADES][NUM_CIUDADES];

        for (int i = 0; i < NUM_CIUDADES; i++) {
            for (int j = i; j < NUM_CIUDADES; j++) {
                if (i == j) {
                    distancias[i][j] = 0;
                } else {
                    if (random.nextBoolean()) {
                        int distancia = random.nextInt(MAX_DISTANCIA - MIN_DISTANCIA + 1) + MIN_DISTANCIA;
                        distancias[i][j] = distancia;
                        distancias[j][i] = distancia;
                    } else {
                        distancias[i][j] = 0;
                        distancias[j][i] = 0;
                    }
                }
            }
        }
        return distancias;
    }

    /**
     * Simula la limpieza de pantalla imprimiendo varias líneas vacías.
     */
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}