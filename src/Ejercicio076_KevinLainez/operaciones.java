package Ejercicio076_KevinLainez;

import java.lang.Math;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 076 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para calcular e imprimir la tabla de funciones trigonométricas.
 */
public class operaciones {

    // --- CÁLCULOS TRIGONOMÉTRICOS ---

    /**
     * Calcula la función seno.
     */
    public static double seno(double grados) {
        // Math.toRadians() convierte grados a radianes
        return Math.sin(Math.toRadians(grados));
    }

    /**
     * Calcula la función coseno.
     */
    public static double coseno(double grados) {
        return Math.cos(Math.toRadians(grados));
    }

    /**
     * Calcula la función tangente.
     */
    public static double tangente(double grados) {
        // La tangente tiene asíntotas a 90, 270, etc. Si el coseno es ~0, es infinito.
        double cos = coseno(grados);
        if (Math.abs(cos) < 1e-9) { // Cerca de cero
            return Double.NaN;
        }
        return Math.tan(Math.toRadians(grados));
    }

    /**
     * Calcula la función cosecante (1/seno).
     */
    public static double cosecante(double grados) {
        double sen = seno(grados);
        if (Math.abs(sen) < 1e-9) { // Cerca de cero (0, 180, 360)
            return Double.NaN;
        }
        return 1.0 / sen;
    }

    /**
     * Calcula la función secante (1/coseno).
     */
    public static double secante(double grados) {
        double cos = coseno(grados);
        if (Math.abs(cos) < 1e-9) { // Cerca de cero (90, 270)
            return Double.NaN;
        }
        return 1.0 / cos;
    }

    /**
     * Calcula la función cotangente (1/tangente o coseno/seno).
     */
    public static double cotangente(double grados) {
        double sen = seno(grados);
        if (Math.abs(sen) < 1e-9) { // Cerca de cero (0, 180, 360)
            return Double.NaN;
        }
        return coseno(grados) / sen;
    }

    // --- IMPRESIÓN DE TABLA ---

    /**
     * Imprime una tabla que compara las funciones trigonométricas de dos ángulos.
     * @param angulo1 El primer ángulo (grados).
     * @param angulo2 El segundo ángulo (grados).
     */
    public static void imprimirTablaTrigonometrica(double angulo1, double angulo2) {

        // El ancho de la utilidad se utiliza como guía, pero la impresión es directa aquí.
        // Utilidades.dibujarLineaHorizontal('┌', '┐') podría usarse para los bordes externos.

        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("--- TABLA DE VALORES TRIGONOMÉTRICOS ---"));
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));

        // Formato: Función | Ángulo 1 | Ángulo 2
        String encabezado = String.format("%-15s | %18.2f° | %18.2f°", "FUNCIÓN", angulo1, angulo2);
        System.out.println(utilidades.centrarTexto(encabezado));
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));

        // Fila de función
        imprimirFila("Seno", seno(angulo1), seno(angulo2));
        imprimirFila("Coseno", coseno(angulo1), coseno(angulo2));
        imprimirFila("Tangente", tangente(angulo1), tangente(angulo2));
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
        imprimirFila("Cosecante", cosecante(angulo1), cosecante(angulo2));
        imprimirFila("Secante", secante(angulo1), secante(angulo2));
        imprimirFila("Cotangente", cotangente(angulo1), cotangente(angulo2));

        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Auxiliar para imprimir una sola fila de la tabla.
     */
    private static void imprimirFila(String funcion, double val1, double val2) {
        String str1 = (Double.isNaN(val1)) ? "INF" : String.format("%.4f", val1);
        String str2 = (Double.isNaN(val2)) ? "INF" : String.format("%.4f", val2);

        String fila = String.format("%-15s | %18s | %18s", funcion, str1, str2);
        System.out.println(utilidades.centrarTexto(fila));
    }
}