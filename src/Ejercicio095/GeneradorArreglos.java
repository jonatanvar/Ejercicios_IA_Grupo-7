package Ejercicio095;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 095 | 2025-10-21
 * Librería propia para la generación y ordenamiento de vectores.
 */
public class GeneradorArreglos {

    private static final Random generador = new Random();
    private static final int RANGO_MIN_VALOR = 1;
    private static final int RANGO_MAX_VALOR = 1000;

    /**
     * Crea un arreglo de enteros con el tamaño especificado, llenándolo con números aleatorios.
     * @param tamano El número de elementos del arreglo.
     * @return El arreglo de enteros generado.
     */
    public static int[] crearVectorAleatorio(int tamano) {
        int[] vector = new int[tamano];
        // Ciclo for para llenar el arreglo
        for (int i = 0; i < tamano; i++) {
            // Genera números aleatorios entre RANGO_MIN_VALOR y RANGO_MAX_VALOR
            vector[i] = generador.nextInt(RANGO_MAX_VALOR - RANGO_MIN_VALOR + 1) + RANGO_MIN_VALOR;
        }
        return vector;
    }

    /**
     * Ordena el arreglo de mayor a menor (descendente).
     * Nota: Java Collections.reverseOrder() solo funciona con objetos (Integer[]),
     * por lo que se convierte el arreglo primitivo a su clase Integer wrapper.
     * @param vector El arreglo de enteros a ordenar.
     * @return El arreglo de enteros ordenado de mayor a menor.
     */
    public static int[] ordenarVectorDescendente(int[] vector) {
        // 1. Convertir int[] a Integer[] para usar Collections.reverseOrder()
        Integer[] vectorWrapper = Arrays.stream(vector).boxed().toArray(Integer[]::new);

        // 2. Ordenar de mayor a menor
        Arrays.sort(vectorWrapper, Collections.reverseOrder());

        // 3. Convertir de nuevo a int[]
        return Arrays.stream(vectorWrapper).mapToInt(Integer::intValue).toArray();
    }
}