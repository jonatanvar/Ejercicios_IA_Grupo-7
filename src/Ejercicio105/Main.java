/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 105 | 2025-10-26               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Nuevo ejercicio el #105, este no es cambiar uno anterior, es hacer uno que da
 *  muchas especificaciones, siguas a al pie de la letra, siempre usando los
 * parámetros de los ejercicios anteriores, siempre muestra las salidas de forma
 * elegante, dando una muestra al usuario de como llegaste a ese resultado, el ejercicio es este:
 * ¿Es cuadrada?: Haga un programa que solicite al usuario la cantidad de filas y columnas
 * (mayores que dos y menores o iguales a 10), si la matriz es cuadrada haga lo siguiente:
 * a. Inicializar en cero con una función.
 * b. Usando una función rellenarla con números aleatorios menores a 100.
 * c. Usando una función que Imprima la matriz completa
 * d. Usando una función que imprima la matriz de manera que solo se vean los números
 * de la diagonal principal.
 * e. Usando una función que Imprima la matriz de manera que solo se vean los números
 * de la diagonal principal y la diagonal secundaria
 * f. Usando una función que imprima la matriz de manera que solo se vean los números
 * que no pertenecen a la diagonal principal ni secundaria.
 * g. Usando una función que imprima la matriz de manera que solo se vean los elementos
 * arriba de la diagonal principal.
 * h. Usando una función que imprima la matriz de manera que solo se vean los elementos
 * debajo de la diagonal principal.
 * Por otro lado si la matriz no es cuadrada:
 * a. Inicializar en cero con una función.
 * b. Usando una función rellenarla con números aleatorios menores a 100 y mayores que
 * 1.
 * c. Usando una función que Imprima la matriz completa.
 * d. Ahora usar un vector para guardar el total por fila y un vector para guardar el total
 * por columna.
 * e. Imprimir la matriz y agregar como columna adicional el total por fila y como fila
 * adicional el vector de totales por columna.
 * f. Mostrar el total de números pares (una función que reciba la matriz y retorne ese
 * total)
 * g. Mostrar el total de números impares (una función que reciba la matriz y retorne ese
 * total)
 */

package Ejercicio105;

import java.util.Scanner;
import Ejercicio105.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}