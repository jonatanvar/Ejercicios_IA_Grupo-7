/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 005 | 2025-10-22
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que solicita dos números enteros, los compara e imprime el mayor, o un mensaje de igualdad si son idénticos.
 */

package Ejercicio_005;

import java.util.Scanner;

/**
 * Clase de utilidades para interacción con el usuario y mensajes estándar.
 */
public class Utilidades {

    /**
     * Muestra un mensaje de bienvenida para el programa.
     */
    public static String getMensajeBienvenida() {
        return "--- COMPARACIÓN DE DOS NÚMEROS ENTEROS ---";
    }

    /**
     * Solicita al usuario un número entero con mensaje personalizado.
     * @param scanner Objeto Scanner para lectura.
     * @param mensaje Mensaje que se mostrará al usuario.
     * @return El número entero ingresado por el usuario.
     */
    public static int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Muestra un resultado en pantalla.
     * @param mensaje Resultado que se desea imprimir.
     */
    public static void mostrarResultado(String mensaje) {
        System.out.println("\nResultado:");
        System.out.println(mensaje);
    }
}
