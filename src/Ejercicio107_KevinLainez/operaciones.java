package Ejercicio107_KevinLainez;

import java.util.Random;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 107 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para la inicialización, cálculo y análisis de la matriz de ventas.
 */
public class operaciones {

    private static final Random generador = new Random();
    public static final int FILAS_SEMANAS = 5;
    public static final int COLUMNAS_DIAS = 7;
    public static final int MAX_VENTA = 500; // Venta aleatoria máxima

    /**
     * Inicializa una matriz con ventas aleatorias.
     * @param matriz La matriz a inicializar.
     */
    public static void inicializarMatrizVentas(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // Genera ventas aleatorias entre 10.00 y 500.00
                matriz[i][j] = 10.0 + (MAX_VENTA - 10.0) * generador.nextDouble();
            }
        }
    }

    /**
     * Calcula la suma total de todas las ventas en la matriz.
     * @param matriz La matriz de ventas.
     * @return El total de las ventas.
     */
    public static double calcularVentasTotales(double[][] matriz) {
        double total = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                total += matriz[i][j];
            }
        }
        return total;
    }

    /**
     * Calcula el total de ventas por cada fila (semana/vendedor).
     * @param matriz La matriz de ventas.
     * @return Arreglo con la suma total por cada fila.
     */
    public static double[] calcularTotalVentasPorFila(double[][] matriz) {
        int filas = matriz.length;
        double[] totalFilas = new double[filas];

        for (int i = 0; i < filas; i++) {
            double suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            totalFilas[i] = suma;
        }
        return totalFilas;
    }

    // --- FUNCIÓN 1: VENTA SEMANAL MÁXIMA ---

    /**
     * Identifica la fila (semana/vendedor) con la venta total máxima y calcula su porcentaje.
     * El resultado se devuelve como un arreglo: [0] = Venta Máxima, [1] = Índice de la Fila, [2] = Porcentaje.
     * @param matriz La matriz de ventas.
     * @param totalGeneral La suma total de todas las ventas.
     * @return Un arreglo de tres elementos [VentaMax, IndiceFila, Porcentaje].
     */
    public static double[] identificarMaximoSemanal(double[][] matriz, double totalGeneral) {
        double[] totalFilas = calcularTotalVentasPorFila(matriz);
        double ventaMaxima = 0;
        int indiceMaximo = -1;

        for (int i = 0; i < totalFilas.length; i++) {
            if (totalFilas[i] > ventaMaxima) {
                ventaMaxima = totalFilas[i];
                indiceMaximo = i;
            }
        }

        double porcentaje = (totalGeneral > 0) ? (ventaMaxima / totalGeneral) * 100 : 0;

        // Retornamos el resultado: [Venta Max, Índice (Fila) + 1, Porcentaje]
        return new double[]{ventaMaxima, (double)indiceMaximo + 1, porcentaje};
    }

    // --- FUNCIÓN 2: DÍA DE VENTA MÁXIMA ---

    /**
     * Identifica el día (columna) con la venta total máxima y calcula su porcentaje.
     * El resultado se devuelve como un arreglo: [0] = Venta Máxima, [1] = Índice de la Columna, [2] = Porcentaje.
     * @param matriz La matriz de ventas.
     * @param totalGeneral La suma total de todas las ventas.
     * @return Un arreglo de tres elementos [VentaMaxDia, IndiceColumna, Porcentaje].
     */
    public static double[] identificarMaximoDiario(double[][] matriz, double totalGeneral) {
        double[] totalColumnas = new double[COLUMNAS_DIAS];
        double ventaMaximaDia = 0;
        int indiceMaximo = -1;

        // Calcular la suma de cada columna (día)
        for (int j = 0; j < COLUMNAS_DIAS; j++) {
            double suma = 0;
            for (int i = 0; i < FILAS_SEMANAS; i++) {
                suma += matriz[i][j];
            }
            totalColumnas[j] = suma;

            // Identificar el máximo mientras sumamos
            if (suma > ventaMaximaDia) {
                ventaMaximaDia = suma;
                indiceMaximo = j;
            }
        }

        double porcentaje = (totalGeneral > 0) ? (ventaMaximaDia / totalGeneral) * 100 : 0;

        // Retornamos el resultado: [Venta Max Día, Índice (Columna) + 1, Porcentaje]
        return new double[]{ventaMaximaDia, (double)indiceMaximo + 1, porcentaje};
    }
}