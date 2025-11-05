package Ejercicio008_KevinLainez;

import java.util.Arrays;
import java.util.Collections;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 008 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para las Operaciones y el ordenamiento de cuatro números.
 */
public class Operaciones {

    /**
     * Ordena un array de números de mayor a menor.
     * @param numeros El array de doubles a ordenar.
     * @return Un nuevo array de Doubles ordenado de mayor a menor.
     */
    public static Double[] ordenarMayorAMenor(double[] numeros) {
        // Convertir double[] a Double[] para usar Collections.reverseOrder()
        Double[] cajaNumeros = new Double[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            cajaNumeros[i] = numeros[i];
        }

        // Ordenar de mayor a menor
        Arrays.sort(cajaNumeros, Collections.reverseOrder());
        return cajaNumeros;
    }

    /**
     * Calcula la suma de los elementos en un array.
     * @param numeros El array de números.
     * @return La suma total.
     */
    public static double calcularSuma(double[] numeros) {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma;
    }

    /**
     * Calcula el promedio de los elementos en un array.
     * @param numeros El array de números.
     * @return El promedio.
     */
    public static double calcularPromedio(double[] numeros) {
        if (numeros.length == 0) return 0;
        return calcularSuma(numeros) / numeros.length;
    }

    /**
     * Calcula el producto de los elementos en un array.
     * @param numeros El array de números.
     * @return El producto total.
     */
    public static double calcularProducto(double[] numeros) {
        double producto = 1;
        for (double num : numeros) {
            producto *= num;
        }
        return producto;
    }

    /**
     * Encuentra el número mayor en un array.
     * @param numeros El array de números.
     * @return El número mayor.
     */
    public static double encontrarMayor(double[] numeros) {
        if (numeros.length == 0) return Double.NaN;
        double mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        return mayor;
    }

    /**
     * Encuentra el número menor en un array.
     * @param numeros El array de números.
     * @return El número menor.
     */
    public static double encontrarMenor(double[] numeros) {
        if (numeros.length == 0) return Double.NaN;
        double menor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        return menor;
    }
}