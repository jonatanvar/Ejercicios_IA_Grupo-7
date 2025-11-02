/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 031 | 2025-10-12               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente el ejercicio#31, siempre muestra nuestro muevo sistema de distribucion de carpetas,
 *  con los menús atractivos en los cuadros anteriormente desarrollados,
 * el nuevo ejercicio consta de los siguiente:
 * No pases de 15: Escriba un programa que utilice una instrucción for para calcular e imprimir el
 * producto de los enteros impares del 1 al 15.
 * Todo en una salida elegante al usuario, y ahora usemos un mensaje de despedida cuando el usuario deje
 *  de usar el programa.
 *  muestra todos los procesos matemáticos que haces y los muestras como esto:
 * 1 × 3 = 3
 * 3 × 5 = 15
 * 15 × 7 = 105
 * 105 × 9 = 945
 * 945 × 11 = 10395
 * 10395 × 13 = 135135
 * 135135 × 15 = 2 027 025 → producto final = 2,027,025
 * y muestra la suma que haces del resultado de los productos
 */

package Ejercicio031;

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
                ejecutarEjercicio(idiomaActual);
                continuar = Menus.preguntarRepetir(scanner, idiomaActual);
            } else {
                Menus.mostrarDespedida(idiomaActual);
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(String idioma) {
        String resultado = Operaciones.calcularProductoImpares();
        Utilidades.mostrarResultado(resultado, idioma);
    }
}