package Ejercicio098_KevinLainez;

import java.util.Random;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 098 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene las funciones para inicializar y calcular los totales condicionales de la matriz.
 */
public class operaciones {

    private static final Random generador = new Random();

    /**
     * Inicializa una matriz cuadrada con números aleatorios menores a 100.
     * @param matriz La matriz a inicializar.
     */
    public static void inicializarMatrizAleatoria(int[][] matriz) {
        // Usamos nextInt(100) para generar números en el rango [0, 99]
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = generador.nextInt(100);
            }
        }
    }

    /**
     * Calcula el total de números pares en cada fila de la matriz.
     * @param matriz La matriz de entrada.
     * @return Un arreglo unidimensional con los totales de pares por fila.
     */
    public static int[] calcularTotalParesPorFila(int[][] matriz) {
        int filas = matriz.length;
        int[] totalPares = new int[filas];

        for (int i = 0; i < filas; i++) {
            int contador = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                // Si el número es par (residuo de la división por 2 es 0)
                if (matriz[i][j] % 2 == 0) {
                    contador++;
                }
            }
            totalPares[i] = contador;
        }
        return totalPares;
    }

    /**
     * Calcula el total de números impares en cada columna de la matriz.
     * @param matriz La matriz de entrada.
     * @return Un arreglo unidimensional con los totales de impares por columna.
     */
    public static int[] calcularTotalImparesPorColumna(int[][] matriz) {
        if (matriz.length == 0) return new int[0];

        int columnas = matriz[0].length;
        int[] totalImpares = new int[columnas];

        for (int j = 0; j < columnas; j++) {
            int contador = 0;
            for (int i = 0; i < matriz.length; i++) {
                // Si el número es impar (residuo de la división por 2 es diferente de 0)
                if (matriz[i][j] % 2 != 0) {
                    contador++;
                }
            }
            totalImpares[j] = contador;
        }
        return totalImpares;
    }
}