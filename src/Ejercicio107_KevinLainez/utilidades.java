package Ejercicio107_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 107 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato y presentación de la matriz de ventas y resultados.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';
    private static final int ANCHO_CELDA = 8; // Ancho para valores de venta

    // Nombres de los días para la presentación
    private static final String[] DIAS = {"LUN", "MAR", "MIÉ", "JUE", "VIE", "SÁB", "DOM"};

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;

        if (espaciosTotales < 0) {
            return String.valueOf(BORDE_IZQ) + " " + texto.substring(0, ANCHO - 4) + " " + String.valueOf(BORDE_DER);
        }
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSaludo() {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #107!"));
        System.out.println(centrarTexto("ANÁLISIS DE VENTAS EMPRESARIALES"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 107 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Imprime la matriz de ventas y la columna de totales por fila. (Inciso 99)
     * @param matriz La matriz de ventas.
     * @param totalFila Arreglo con la suma total por cada fila.
     * @param totalGeneral La suma total de todas las ventas.
     */
    public static void imprimirTablaVentas(double[][] matriz, double[] totalFila, double totalGeneral) {

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- MATRIZ DE VENTAS SEMANALES ---"));

        // Encabezado de la tabla (Días y Total)
        StringBuilder sbHeader = new StringBuilder();
        sbHeader.append(String.format("%-10s", "SEMANA"));
        for (String dia : DIAS) {
            sbHeader.append(String.format("%" + ANCHO_CELDA + "s", dia));
        }
        sbHeader.append(String.format("%" + ANCHO_CELDA + "s", "TOTAL"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sbHeader.toString()));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Filas de datos
        for (int i = 0; i < matriz.length; i++) {
            StringBuilder sbFila = new StringBuilder();

            // Índice de Fila (Semana 1, 2, 3...)
            sbFila.append(String.format("%-10s", "Vendedor " + (i + 1)));

            // Datos de la Matriz [i][j]
            for (int j = 0; j < matriz[i].length; j++) {
                sbFila.append(String.format("%" + ANCHO_CELDA + ".2f", matriz[i][j]));
            }

            // Total por Fila
            sbFila.append(String.format("%" + ANCHO_CELDA + ".2f", totalFila[i]));

            System.out.println(centrarTexto(sbFila.toString()));
        }

        // Pie de página con Total General y Promedio (asumiendo parte del inciso 99)
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        int totalCeldas = operaciones.FILAS_SEMANAS * operaciones.COLUMNAS_DIAS;
        double promedioGeneral = totalGeneral / totalCeldas;

        System.out.println(centrarTexto(String.format("VENTA TOTAL GENERAL: $%.2f", totalGeneral)));
        System.out.println(centrarTexto(String.format("PROMEDIO GENERAL: $%.2f", promedioGeneral)));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra el resultado de la función 1: Venta Semanal Máxima.
     * @param resultado Arreglo [VentaMax, IndiceFila, Porcentaje].
     */
    public static void mostrarMaximoSemanal(double[] resultado) {
        double ventaMaxima = resultado[0];
        int vendedor = (int) resultado[1];
        double porcentaje = resultado[2];

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- ANÁLISIS 1: MÁXIMA VENTA SEMANAL ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        String ventaStr = String.format("Venta Semanal Máxima: $%.2f", ventaMaxima);
        String vendStr = String.format("Realizada por: Vendedor %d", vendedor);
        String porcStr = String.format("Representación Porcentual: %.2f%%", porcentaje);

        System.out.println(centrarTexto(ventaStr));
        System.out.println(centrarTexto(vendStr));
        System.out.println(centrarTexto(porcStr));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra el resultado de la función 2: Día de Venta Máxima.
     * @param resultado Arreglo [VentaMaxDia, IndiceColumna, Porcentaje].
     */
    public static void mostrarMaximoDiario(double[] resultado) {
        double ventaMaximaDia = resultado[0];
        int diaIndex = (int) resultado[1] - 1; // Convertir índice 1-7 a 0-6
        String nombreDia = DIAS[diaIndex];
        double porcentaje = resultado[2];

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- ANÁLISIS 2: DÍA DE MÁXIMA VENTA ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        String ventaStr = String.format("Venta Diaria Máxima (Acumulada): $%.2f", ventaMaximaDia);
        String diaStr = String.format("Día con Máxima Venta: %s", nombreDia);
        String porcStr = String.format("Representación Porcentual: %.2f%%", porcentaje);

        System.out.println(centrarTexto(ventaStr));
        System.out.println(centrarTexto(diaStr));
        System.out.println(centrarTexto(porcStr));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}