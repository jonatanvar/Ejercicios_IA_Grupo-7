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
 * Clase principal que gestiona la interacción con el usuario.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mensaje de bienvenida
        System.out.println(Utilidades.getMensajeBienvenida());

        // Solicitud de entrada de datos
        int numero1 = Utilidades.leerEntero(scanner, "Escriba el primer número entero: ");
        int numero2 = Utilidades.leerEntero(scanner, "Escriba el segundo número entero: ");

        // Instanciación de Operaciones
        Operaciones operaciones = new Operaciones();
        String resultado = operaciones.compararYObtenerMensaje(numero1, numero2);

        // Mostrar resultado
        Utilidades.mostrarResultado(resultado);

        scanner.close();
    }
}
