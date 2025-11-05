package Ejercicio043_KevinLainez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 043 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica del menú interactivo.
 */
public class operaciones {

    // Rango del menú: 1-5 son opciones, 0 es Salir
    private static final int OPCION_MINIMA = 0;
    private static final int OPCION_MAXIMA = 5;

    /**
     * Muestra el menú, solicita la opción al usuario, y valida la entrada.
     * Este método contiene toda la lógica de presentación y validación.
     * * @param sc El objeto Scanner ya inicializado.
     * @return La opción válida elegida por el usuario (entero entre 0 y 5).
     */
    public static int gestionarMenu(Scanner sc) {
        int opcionElegida = -1;
        boolean entradaValida = false;

        // Bucle para repetir la solicitud hasta que la entrada sea válida
        while (!entradaValida) {

            // 1. Mostrar el menú
            mostrarOpcionesMenu();

            try {
                System.out.print(">> Ingrese su opción [" + OPCION_MINIMA + "-" + OPCION_MAXIMA + "]: ");
                opcionElegida = sc.nextInt(); // Intenta leer el entero
                sc.nextLine(); // Consumir el salto de línea

                // 2. Validar el rango
                if (opcionElegida >= OPCION_MINIMA && opcionElegida <= OPCION_MAXIMA) {
                    entradaValida = true;
                } else {
                    // Mensaje de opción fuera de rango
                    System.out.println("----------------------------------------------------------------------");
                    System.out.printf("ERROR: Opción %d no válida. Debe ser entre %d y %d.\n", opcionElegida, OPCION_MINIMA, OPCION_MAXIMA);
                    System.out.println("----------------------------------------------------------------------");
                }

            } catch (InputMismatchException e) {
                // Mensaje de error si la entrada no es un entero
                System.out.println("----------------------------------------------------------------------");
                System.out.println("ERROR: Entrada inválida. Por favor, ingrese un NÚMERO entero.");
                System.out.println("----------------------------------------------------------------------");
                sc.nextLine(); // Limpiar el buffer de entrada no válida
            }
        }

        return opcionElegida;
    }

    /**
     * Dibuja y presenta las opciones del menú.
     */
    private static void mostrarOpcionesMenu() {
        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("  M E N Ú   P R I N C I P A L  "));
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
        System.out.println(utilidades.centrarTexto("1. Opción de Procesos A"));
        System.out.println(utilidades.centrarTexto("2. Opción de Cálculos B"));
        System.out.println(utilidades.centrarTexto("3. Opción de Reportes C"));
        System.out.println(utilidades.centrarTexto("4. Opción de Configuración D"));
        System.out.println(utilidades.centrarTexto("5. Opción de Ayuda E"));
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
        System.out.println(utilidades.centrarTexto("0. Salir del Programa"));
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));
    }
}