/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 041 | 2025-10-13               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente ahora el ejercicio#41, agrega todos los requerimientos agregados en los ejercicios anteriores,
 * el ejercicio consta de lo siguiente:
 * Tablita: Escriba un programa que luego dar la bienvenida al usuario le muestre la siguiente tabla:
 *  si el usuario ingresa 5 debes de mostrar esta tabla (ejemplo):
 * ╚═══════════════════════════════════════════════════════╝
 * ╔══════════════════════════════════════════════════════╗
 * ║  #  │   N   │   N²   │   N³    │  2N-1               ║
 * ╠══════════════════════════════════════════════════════╣
 * ║  1  │   1   │    1   │     1    │    1               ║
 * ║  2  │   2   │    4   │     8    │    3               ║
 * ║  3  │   3   │    9   │     27   │    5               ║
 * ║  4  │   4   │   16   │     64   │                    ║
 * ║  5  │   5   │   25   │    125   │    9               ║
 * ╠══════════════════════════════════════════════════════╣
 * ║ Totales │  15  │   55   │   225  │   25              ║
 * ╠══════════════════════════════════════════════════════╣
 * ║Promedios│   3  │   11   │    45  │    5              ║
 * ╚══════════════════════════════════════════════════════╝
 * la tabla hace esto:
 * Calcular cada columna:
 * N = el número actual (1, 2, 3, ..., N)
 * N² = N × N
 * N³ = N × N × N
 * 2N-1 = (2 × N) - 1
 * y entonces le pida un número del 1 al 15, tras validar la entrada debe entonces
 * crear una tabla que vaya desde 1 hasta el número que el usuario haya indicado.
 * Dale las instrucciones al usuario que rango de números le es permitido ingresar,
 * si es necesario muestra un mensaje de validación invalidad si el usuario
 *  ingresa un numero > a 15 y si es negativo igualmente, que la salida sea similar al ejemplo
 * dado con un cuadro elegante, un dato importante en la estructura del programa es el siguiente:
 *  Se aclara que la tabla se debe generar con ciclos y no con condicionales anidados.
 */

package Ejercicio041;

import java.util.Scanner;

public class Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(scanner);

        do {
            int opcion = Menús.mostrarMenuPrincipal(scanner, idiomaActual);
            if (opcion == 1) {
                Utilidades.mostrarBienvenida(idiomaActual);
                Utilidades.mostrarAyudaNumeros(idiomaActual);
                int numero = Operaciones.leerYValidarNumero(scanner, idiomaActual);
                int[][] tabla = Operaciones.generarTablaCalculos(numero);
                Utilidades.mostrarTabla(tabla, numero, idiomaActual);
                continuar = Menús.preguntarRepetir(scanner, idiomaActual);
            } else {
                Menús.mostrarDespedida(idiomaActual);
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }
}