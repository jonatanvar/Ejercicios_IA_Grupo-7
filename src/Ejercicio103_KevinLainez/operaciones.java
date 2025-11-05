package Ejercicio103_KevinLainez;

import java.util.Random;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 103 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para simular el tiro de dos dados y registrar las frecuencias.
 */
public class operaciones {

    // El arreglo debe ser de tamaño 13 para poder usar los índices 2 a 12 directamente.
    // La posición 0 y 1 se dejan sin usar.
    public static final int TAMANO_ARREGLO = 13;
    public static final int TIROS = 36000;

    private static final Random generador = new Random();

    /**
     * Simula el tiro de dos dados el número de veces especificado y registra las frecuencias de la suma.
     * @return El arreglo de frecuencias donde el índice es la suma (2 a 12).
     */
    public static int[] simularTiroDados() {
        int[] frecuencias = new int[TAMANO_ARREGLO];

        for (int i = 0; i < TIROS; i++) {
            // El rango de nextInt(6) es [0, 5]. Sumamos 1 para obtener [1, 6].
            int dado1 = generador.nextInt(6) + 1;
            int dado2 = generador.nextInt(6) + 1;

            int suma = dado1 + dado2;

            // Incrementamos la frecuencia en la posición correspondiente a la suma
            if (suma >= 2 && suma <= 12) {
                frecuencias[suma]++;
            }
        }
        return frecuencias;
    }
}