package Ejercicio063_KevinLainez;

import java.util.ArrayList;
import java.util.List;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 063 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para determinar si un número es perfecto.
 */
public class operaciones {

    /**
     * Calcula y devuelve la lista de divisores de un número, excluyendo el número mismo.
     * @param numero El número a evaluar.
     * @return Una lista de enteros que son divisores propios del número.
     */
    public static List<Integer> obtenerDivisores(int numero) {
        List<Integer> divisores = new ArrayList<>();
        if (numero <= 1) {
            return divisores; // No hay divisores propios para 0 o 1
        }

        // Empezamos desde 1
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                divisores.add(i);
            }
        }
        return divisores;
    }

    /**
     * Determina si un número es un número perfecto.
     * Un número es perfecto si la suma de sus divisores propios (incluyendo 1, excluyendo el número)
     * es igual al número.
     * @param numero El número a evaluar.
     * @return true si el número es perfecto, false en caso contrario.
     */
    public static boolean perfecto(int numero) {
        if (numero <= 1) {
            return false;
        }

        List<Integer> divisores = obtenerDivisores(numero);
        int sumaDivisores = 0;

        // Sumar los divisores
        for (int divisor : divisores) {
            sumaDivisores += divisor;
        }

        // Condición de número perfecto: Suma de divisores = Número
        return sumaDivisores == numero;
    }
}