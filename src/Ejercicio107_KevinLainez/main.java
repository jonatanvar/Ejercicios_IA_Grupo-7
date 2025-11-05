package Ejercicio107_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 107 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #107: Toda una Empresa (Análisis de Ventas)
 * * PROMPT:
 * Agregar dos funciones a la matriz de ventas: 1. Identificar la venta que más
 * ha vendido semanalmente y su % sobre el total. 2. Determinar el día que más
 * se vendió y su % sobre el total. Mostrar todo lo del inciso 99 (Matriz y Totales).
 */
public class main {

    private static final int FILAS = operaciones.FILAS_SEMANAS;
    private static final int COLUMNAS = operaciones.COLUMNAS_DIAS;

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 2. Inicializar la matriz (5x7)
        double[][] matrizVentas = new double[FILAS][COLUMNAS];
        operaciones.inicializarMatrizVentas(matrizVentas);

        // 3. Cálculos Base
        double totalGeneral = operaciones.calcularVentasTotales(matrizVentas);
        double[] totalVentasPorFila = operaciones.calcularTotalVentasPorFila(matrizVentas);

        // 4. Mostrar Matriz Base (Inciso 99)
        utilidades.imprimirTablaVentas(matrizVentas, totalVentasPorFila, totalGeneral);

        // --- ANÁLISIS ADICIONAL (Funciones de este ejercicio) ---

        // 5. Función 1: Máximo Semanal
        double[] maxSemanal = operaciones.identificarMaximoSemanal(matrizVentas, totalGeneral);
        utilidades.mostrarMaximoSemanal(maxSemanal);

        // 6. Función 2: Máximo Diario
        double[] maxDiario = operaciones.identificarMaximoDiario(matrizVentas, totalGeneral);
        utilidades.mostrarMaximoDiario(maxDiario);

        // 7. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}