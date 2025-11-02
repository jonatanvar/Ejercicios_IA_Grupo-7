/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 109 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente el ejercicio #109, siempre usa los parámetros y restricciones de los ejercicios anteriores, con nuestro sistema de archivos, salida elegante en cuadros al usuario el ejercicio dice lo siguiente:
 * Pedir al usuario que ingrese un número mayor a 2 y menor a 15, con ese número crear una matriz cuadrada y llenarla con números positivos impares (generados con una función) entonces una vez llena la matriz mostrarla (usando una función para eso)
 */

package Ejercicio109;

import java.util.Scanner;
import Ejercicio109.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}