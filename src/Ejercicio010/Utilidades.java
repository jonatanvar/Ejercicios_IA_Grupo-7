/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 010 | 2025-10-22
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que lee el lado de un cuadrado e imprime su área y perímetro, incluyendo las fórmulas de cálculo.
 */

package Ejercicio_010;

/**
 * Clase de utilidad para mostrar resultados y mensajes.
 */
public class Utilidades {

    public static void mostrarResultado(String titulo, String formula, double lado, double resultado) {
        System.out.println("\n--- " + titulo.toUpperCase() + " ---");
        System.out.println("Fórmula utilizada: " + formula);
        System.out.printf("El %s del cuadrado de lado %.2f es: %.2f%n", titulo.toLowerCase(), lado, resultado);
    }

    public static String getMensajeBienvenida() {
        return "--- CÁLCULO DE ÁREA Y PERÍMETRO DE UN CUADRADO ---";
    }
}
