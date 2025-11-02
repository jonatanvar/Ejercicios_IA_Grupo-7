/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 036 | 2025-10-13               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente ejercicio #36, es un poco diferente a los demás,
 *  pero siempre implementa las funciones correspondientes a
 *  lo que hemos desarrollado anteriormente, como nuestro menú,
 *  y nuestra distribución de archivos.
 * Un cuento de cinco druidas: Ahora hagamos un programa que lea cinco números,
 *  debe validar que ninguno sea menor que uno (1) o mayor que doce (12),
 * luego los ordene de menor a mayor y, finalmente, muestre una gráfica de barras
 * horizontales de estos cinco números.
 * Si se ingresa una letra, un carácter, un numero fuera de los limites antes mencionado
 *  muestra un mensaje al usuario explicando que esta haciendo mal, trata de desarrollar
 * un gráfico elegante en la salida.
 *  implementa más ayuda para el usuario, cuando este ingresado los números,
 * dale un ejemplo de los números que tiene permitido en esta parte que sigue después que
 * el le da ejecutar el código
 */

package Ejercicio036;

import java.util.Scanner;

public class Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menus.seleccionarIdioma(scanner);

        do {
            int opcion = Menus.mostrarMenuPrincipal(scanner, idiomaActual);
            if (opcion == 1) {
                Utilidades.mostrarAyudaNumeros(idiomaActual); // Nueva ayuda antes de ingresar números
                ejecutarEjercicio(scanner, idiomaActual);
                continuar = Menus.preguntarRepetir(scanner, idiomaActual);
            } else {
                Menus.mostrarDespedida(idiomaActual);
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(Scanner scanner, String idioma) {
        int[] numeros = Operaciones.leerYValidarNumeros(scanner, idioma);
        int[] ordenados = Operaciones.ordenarNumeros(numeros);
        Utilidades.mostrarGraficaBarras(ordenados, idioma);
    }
}