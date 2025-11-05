package Ejercicio067_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 067 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato, cuadros y el sello personalizado.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSaludo(int lanzamientos) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #67!"));
        System.out.println(centrarTexto("SIMULACIÓN DE LANZAMIENTO DE MONEDAS"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("Simularemos %d lanzamientos...", lanzamientos)));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 067 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra el encabezado para el listado de lanzamientos.
     */
    public static void mostrarEncabezadoSimulacion() {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("RESULTADOS DE CADA LANZAMIENTO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
    }

    /**
     * Muestra el total de resultados en un formato tabular.
     */
    public static void mostrarTotales(int totalLanzamientos, int caras, int cruces) {
        // Ancho de la tabla interna para centrarla en el ANCHO total (70)
        final int ANCHO_TABLA = 40;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- CONTEO FINAL DE RESULTADOS ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Cabecera
        String cabecera = String.format("%-15s | %-15s", "LADO", "CONTEO");
        System.out.println(centrarTexto(cabecera));
        System.out.println(centrarTexto(String.format("%s", "-".repeat(ANCHO_TABLA)))); // Separador centrado

        // Caras
        String carasStr = String.format("%-15s | %-15d", "Cara", caras);
        System.out.println(centrarTexto(carasStr));

        // Cruces
        String crucesStr = String.format("%-15s | %-15d", "Cruz", cruces);
        System.out.println(centrarTexto(crucesStr));

        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("TOTAL DE LANZAMIENTOS: %d", totalLanzamientos)));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Imprime el resultado de un solo lanzamiento.
     */
    public static void imprimirLanzamiento(int numLanzamiento, String resultado) {
        // Imprimir en columnas para 100 lanzamientos sin saturar la consola
        String salida = String.format("[%03d: %s]", numLanzamiento, resultado);
        // Usamos print en lugar de println
        System.out.print(salida);

        // Salto de línea cada 6 lanzamientos para formato
        if (numLanzamiento % 6 == 0) {
            System.out.println();
            System.out.print(BORDE_IZQ + " "); // Ajuste para el borde del cuadro
        }
    }
}