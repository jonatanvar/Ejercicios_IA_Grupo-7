package Ejercicio098_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 098 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #98: Matriz v2 con Totales Condicionales
 * * PROMPT:
 * Haga una matriz de 5x5 con números aleatorios (menores a 100) y muestre el
 * total de números pares en las filas en una columna extra y en una fila
 * adicional el total de números impares de cada columna.
 */
public class main {

    private static final int N = 5; // Tamaño de la matriz N x N

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo(N);

        // 2. Inicializar la matriz
        int[][] matriz = new int[N][N];

        // 3. Llenar la matriz con aleatorios
        operaciones.inicializarMatrizAleatoria(matriz);

        // 4. Calcular Total de Pares por Fila
        int[] totalParesPorFila = operaciones.calcularTotalParesPorFila(matriz);

        // 5. Calcular Total de Impares por Columna
        int[] totalImparesPorColumna = operaciones.calcularTotalImparesPorColumna(matriz);

        // 6. Imprimir la matriz extendida con los totales
        utilidades.imprimirMatrizExtendida(matriz, totalParesPorFila, totalImparesPorColumna);

        // 7. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}