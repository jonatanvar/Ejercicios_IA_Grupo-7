/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 112 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente el ejercicio #112, siempre usa los parámetros de los ejercicios anteriores,
 *  muestra los proceso que realizas para el usuario, siempre usa nuestro sistemas de
 * archivos, con cuadros elegantes para el usuario, el ejercicio consta de esto:
 * En una estación meteorológica registramos la temperatura (en grados centígrados)
 * cada hora durante una semana. Almacenamos el resultado en una matriz de 7 × 24
 * (cada fila de la matriz contiene las 24 mediciones de un día). Hacer un programa
 * que lea los datos por teclado (se admite que se llene automáticamente con valores
 *  de -10 a 40) y muestre:
 * a. La matriz.
 * b. La máxima y mínima temperatura de la semana.
 * c. La máxima y mínima temperatura de cada día.
 * d. Luego de lo anterior, la temperatura media de la semana.
 * e. La temperatura media de cada día.
 * f. El número de días en los que la temperatura media fue superior a 30 grados
 *
 * Para que el usuario entienda, pide de los datos de manera simple, para que los datos
 * ingresados sean correctos, trata de organizar los cuadros de salida, que sean simétricos.
 */

package Ejercicio112;

import java.util.Scanner;
import Ejercicio112.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}