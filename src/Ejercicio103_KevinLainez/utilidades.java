package Ejercicio103_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 103 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato y presentación de la tabla de resultados.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();

        // --- CORRECCIÓN APLICADA AQUÍ ---
        if (espaciosTotales < 0) {
            // Si el texto es demasiado largo, lo devolvemos ajustado a los bordes
            return String.valueOf(BORDE_IZQ) + " " + texto.substring(0, ANCHO - 4) + " " + String.valueOf(BORDE_DER);
        }

        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;

        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSaludo(int tiros) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #103!"));
        System.out.println(centrarTexto("SIMULACIÓN DE TIRO DE DOS DADOS"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("Se simularán %d lanzamientos.", tiros)));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 103 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Imprime la tabla de frecuencias y porcentajes.
     * @param frecuencias Arreglo con el conteo de cada suma (índices 2 a 12).
     * @param totalTiros El número total de tiros (36,000).
     */
    public static void imprimirTablaResultados(int[] frecuencias, int totalTiros) {

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- RESULTADOS TABULARES ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Encabezados
        String encabezado = String.format("%-10s | %-15s | %-15s | %-10s", "SUMA", "FRECUENCIA", "PROB. TEÓRICA", "PORCENTAJE");
        System.out.println(centrarTexto(encabezado));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Probabilidades teóricas de 36 combinaciones
        int[] conteoTeorico = {0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};

        // Filas de datos (Sumas de 2 a 12)
        for (int suma = 2; suma <= 12; suma++) {

            int conteo = frecuencias[suma];
            double porcentaje = (double) conteo / totalTiros * 100.0;

            // Cálculo de la frecuencia esperada (teórica)
            double probTeorica = (double) conteoTeorico[suma] / 36.0 * totalTiros;

            String fila = String.format("%-10d | %-15d | %-15.0f | %-10.2f%%",
                    suma, conteo, probTeorica, porcentaje);
            System.out.println(centrarTexto(fila));
        }

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Realiza una validación simple de la razonabilidad de los resultados.
     */
    public static void validarRazonabilidad(int[] frecuencias) {
        int totalTiros = operaciones.TIROS;

        // El 7 es la suma más frecuente (6/36 = 1/6)
        double porcentajeSiete = (double) frecuencias[7] / totalTiros;
        double esperadoSiete = 1.0 / 6.0; // 16.666...%

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- ANÁLISIS DE RAZONABILIDAD (Suma 7) ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        String actualStr = String.format("Frecuencia de 7 (Actual): %.2f%%", porcentajeSiete * 100);
        String esperadoStr = String.format("Frecuencia de 7 (Teórica): %.2f%% (1/6)", esperadoSiete * 100);

        System.out.println(centrarTexto(actualStr));
        System.out.println(centrarTexto(esperadoStr));

        // Si el resultado está cerca (ej: dentro del 1% del valor teórico)
        if (Math.abs(porcentajeSiete - esperadoSiete) < 0.01) {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            System.out.println(centrarTexto("CONCLUSIÓN: Los resultados son razonables, cercanos al valor teórico."));
        } else {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            System.out.println(centrarTexto("CONCLUSIÓN: Los resultados muestran una desviación significativa."));
        }

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}