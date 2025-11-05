package Ejercicio094_KevinLainez;

import java.util.Arrays;
import java.util.Random;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 094 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene las funciones para inicializar, sumar y ordenar el vector.
 */
public class operaciones {

    private static final Random generador = new Random();
    private static final int MAX_VALOR_ALEATORIO = 1000;

    /**
     * Inicializa un arreglo de enteros con números aleatorios.
     * @param arreglo El arreglo a inicializar.
     */
    public static void inicializarVectorAleatorio(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            // Genera números aleatorios entre 1 y MAX_VALOR_ALEATORIO (ej: 1000)
            arreglo[i] = generador.nextInt(MAX_VALOR_ALEATORIO) + 1;
        }
    }

    /**
     * Suma todos los elementos de un arreglo de enteros.
     * @param arreglo El arreglo a sumar.
     * @return El total de la suma de los elementos.
     */
    public static long sumarVector(int[] arreglo) {
        long suma = 0;
        for (int valor : arreglo) {
            suma += valor;
        }
        return suma;
    }

    /**
     * Ordena el arreglo de menor a mayor (ascendente).
     * Nota: Utiliza el método de ordenamiento nativo de Java para eficiencia.
     * @param arreglo El arreglo a ordenar in-place (se modifica el original).
     */
    public static void ordenarVector(int[] arreglo) {
        Arrays.sort(arreglo);
    }
}