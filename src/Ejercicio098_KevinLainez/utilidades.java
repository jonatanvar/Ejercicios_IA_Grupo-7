package Ejercicio098_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 098 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato y presentación de la matriz extendida.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';
    private static final int ANCHO_CELDA = 6; // Ancho para números hasta 99

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSaludo(int tamaño) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #98!"));
        System.out.println(centrarTexto(String.format("MATRIZ %dx%d CON TOTALES CONDICIONALES", tamaño, tamaño)));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 098 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Imprime la matriz completa junto con la columna de totales pares por fila
     * y la fila de totales impares por columna.
     * @param matriz La matriz 5x5.
     * @param totalParesPorFila El arreglo de totales pares.
     * @param totalImparesPorColumna El arreglo de totales impares.
     */
    public static void imprimirMatrizExtendida(int[][] matriz, int[] totalParesPorFila, int[] totalImparesPorColumna) {

        int N = matriz.length; // 5

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- MATRIZ CON CÁLCULOS CONDICIONALES ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // 1. IMPRESIÓN DE ENCABEZADO DE COLUMNAS
        StringBuilder sbHeader = new StringBuilder();

        // Esquina superior izquierda (N/A)
        sbHeader.append(String.format("%" + ANCHO_CELDA + "s", "N/A"));

        // Encabezados de Columna (1, 2, 3, 4, 5)
        for (int j = 0; j < N; j++) {
            sbHeader.append(String.format("%" + ANCHO_CELDA + "d", j + 1));
        }

        // Encabezado de Columna de Pares
        sbHeader.append(String.format("%" + (ANCHO_CELDA * 2) + "s", "Total Pares"));

        System.out.println(centrarTexto(sbHeader.toString()));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // 2. IMPRESIÓN DE DATOS DE LA MATRIZ Y TOTALES PARES POR FILA
        for (int i = 0; i < N; i++) {
            StringBuilder sbFila = new StringBuilder();

            // Índice de Fila (1, 2, 3, 4, 5)
            sbFila.append(String.format("%" + ANCHO_CELDA + "d", i + 1));

            // Datos de la Matriz [i][j]
            for (int j = 0; j < N; j++) {
                sbFila.append(String.format("%" + ANCHO_CELDA + "d", matriz[i][j]));
            }

            // Total Pares por Fila
            sbFila.append(String.format("%" + (ANCHO_CELDA * 2) + "d", totalParesPorFila[i]));

            System.out.println(centrarTexto(sbFila.toString()));
        }

        // 3. IMPRESIÓN DE FILA DE TOTALES IMPARES POR COLUMNA
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        StringBuilder sbTotales = new StringBuilder();

        // Encabezado de la Fila de Totales Impares
        sbTotales.append(String.format("%" + ANCHO_CELDA + "s", "Total Imp."));

        // Totales Impares por Columna
        for (int j = 0; j < N; j++) {
            sbTotales.append(String.format("%" + ANCHO_CELDA + "d", totalImparesPorColumna[j]));
        }

        // Esquina inferior derecha (N/A)
        sbTotales.append(String.format("%" + (ANCHO_CELDA * 2) + "s", "N/A"));

        System.out.println(centrarTexto(sbTotales.toString()));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}