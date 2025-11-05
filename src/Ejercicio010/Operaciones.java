/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn. | 010 | 2025-10-22
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que lee el lado de un cuadrado e imprime su área y perímetro, incluyendo las fórmulas de cálculo.
 */

package Ejercicio_010;

/**
 * Clase que encapsula los cálculos geométricos de un cuadrado.
 */
public class Operaciones {

    public double calcularArea(double lado) {
        return lado * lado;
    }

    public double calcularPerimetro(double lado) {
        return 4.0 * lado;
    }
}
