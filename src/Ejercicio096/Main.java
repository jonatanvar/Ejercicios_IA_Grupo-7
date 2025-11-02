/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 096 | 2025-10-24               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente el ejercicio #96 nos corresponde hacer, este ejercicio sigue
 *  los anteriores en el punto que es de modificar un ejercicio anterior
 * te mandaré que tienes que hacer, sigue usando los parámetros anteriores
 * con todo lo necesario para un manejo placentero al usuario el ejercicio
 * conta de los siguiente:
 *
 * Al programa Vectocien que es un ejercicio que no nos correspondía
 *  hacer pero es este (Haga un programa que inicialice un vector de
 * 100 elementos con números aleatorios y luego los sume, presente los
 * elementos ordenados de menor a mayor y el total.), a ese debemos hacer
 * lo siguiente agregar funciones para totalizar números pares, números
 * impares, y junto con la salida mostrar no solo el arreglo ordenado sino
 *  el mayor de los elementos menos el menor y los totales de pares e impares.
 *
 * Siempre muestra al usuario como llegas al resultado, junto con los cuadros de salida.
 */

package Ejercicio096;

import java.util.Scanner;
import Ejercicio096.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}