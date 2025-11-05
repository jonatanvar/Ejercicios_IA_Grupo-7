package Ejercicio072_KevinLainez;

import java.lang.Math;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 072 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la función para calcular el área de un círculo.
 */
public class operaciones {

    /**
     * Calcula el área de un círculo usando la fórmula: Área = π * radio^2.
     * En el contexto de Java, esta es una función simple y eficiente.
     * @param radio El radio del círculo (double).
     * @return El área del círculo (double).
     */
    public static double areaCirculo(double radio) {
        // Utilizamos Math.PI para el valor de Pi y Math.pow(radio, 2) para el cuadrado.
        return Math.PI * Math.pow(radio, 2);
    }
}