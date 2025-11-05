package Ejercicio094_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 094 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades específicas para la salida del Ejercicio 94.
 */
public class utilidades {

    /**
     * Muestra el contenido completo de un arreglo de forma organizada.
     * @param arreglo El arreglo de enteros a imprimir.
     */
    public static void mostrarVectorOrdenado(int[] arreglo) {
        final int COLUMNAS = 10;
        final int ANCHO_COLUMNA = 6;

        System.out.println(MiLibreria.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(MiLibreria.centrarTexto("** ELEMENTOS ORDENADOS (" + arreglo.length + " en total) **"));
        System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));

        // Impresión en formato de cuadrícula
        for (int i = 0; i < arreglo.length; i++) {

            // Inicio de fila
            if (i % COLUMNAS == 0) {
                // Imprimimos el borde izquierdo y el padding inicial (ajustado para centrar la tabla)
                System.out.print(MiLibreria.getBORDE_IZQ() + "  ");
            }

            // Valor
            System.out.printf("%" + ANCHO_COLUMNA + "d", arreglo[i]);

            // Fin de fila
            if ((i + 1) % COLUMNAS == 0) {
                // Relleno final y borde derecho
                System.out.println("  " + MiLibreria.getBORDE_DER());
            }
        }

        System.out.println(MiLibreria.dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra el total de la suma de los elementos.
     * @param total La suma total de los elementos.
     */
    public static void mostrarTotal(long total) {
        System.out.println(MiLibreria.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(MiLibreria.centrarTexto("--- SUMA TOTAL ---"));
        System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));

        String totalStr = String.format("TOTAL ACUMULADO: %d", total);
        System.out.println(MiLibreria.centrarTexto(totalStr));

        System.out.println(MiLibreria.dibujarLineaHorizontal('└', '┘'));
    }
}