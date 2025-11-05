package Ejercicio067_KevinLainez;

import java.util.Random;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 067 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para simular el lanzamiento de una moneda.
 */
public class operaciones {

    // Constantes para el resultado del lanzamiento
    public static final int CARA = 0;
    public static final int CRUZ = 1;
    private static final Random generador = new Random();

    /**
     * Simula el lanzamiento de una moneda.
     * @return 0 para Cara, 1 para Cruz.
     */
    public static int tirar() {
        // nextInt(2) genera un entero aleatorio entre 0 (incluido) y 2 (excluido).
        // Resultados posibles: 0 o 1 (50% de probabilidad para cada uno).
        return generador.nextInt(2);
    }

    /**
     * Convierte el código numérico del resultado en su representación en texto.
     * @param resultado El código numérico (0 o 1).
     * @return "Cara" o "Cruz".
     */
    public static String obtenerNombreLado(int resultado) {
        if (resultado == CARA) {
            return "Cara";
        } else if (resultado == CRUZ) {
            return "Cruz";
        } else {
            return "Indefinido";
        }
    }
}