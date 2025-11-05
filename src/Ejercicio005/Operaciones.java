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

/**
 * Clase que encapsula la lógica de comparación de dos números enteros.
 */
public class Operaciones {

    public String compararYObtenerMensaje(int num1, int num2) {
        if (num1 > num2) {
            return num1 + " es más grande.";
        } else if (num2 > num1) {
            return num2 + " es más grande.";
        } else {
            return "Estos números son iguales.";
        }
    }
}
