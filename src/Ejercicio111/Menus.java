/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 111 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que realiza diversas operaciones (suma, transpuesta, llenado especial) con matrices cuadradas del mismo orden.
 */

package Ejercicio_111;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Módulo Menús: Se encarga de mostrar y gestionar las opciones de navegación
 * del programa, incluyendo el menú de selección de idioma, el menú de control
 * (ejecutar/finalizar) y el menú de operaciones de matrices.
 */
public class Menus {

    /**
     * Muestra y gestiona el menú inicial de selección de idioma.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @return La clave del idioma seleccionado ("ES" o "EN"), o una cadena vacía si la entrada fue inválida.
     */
    public String menuSeleccionIdioma(Scanner scanner) {
        String idiomaSeleccionado = "";
        int opcion = -1;
        
        System.out.println(Utilidades.getTexto("ES", "MENU_IDIOMA_TITULO"));
        System.out.println(Utilidades.getTexto("ES", "MENU_IDIOMA_OPCION_ES"));
        System.out.println(Utilidades.getTexto("ES", "MENU_IDIOMA_OPCION_EN"));
        System.out.print(Utilidades.getTexto("ES", "MENU_IDIOMA_PROMPT"));

        try {
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de nextInt
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: Invalid selection. Please enter 1 or 2.");
            scanner.nextLine(); // Limpiar buffer de entrada errónea
            return "";
        }
        
        switch (opcion) {
            case 1:
                idiomaSeleccionado = "ES";
                break;
            case 2:
                idiomaSeleccionado = "EN";
                break;
            default:
                // Si la opción no es 1 o 2, se trata como inválida
                System.out.println("\nERROR: Invalid selection. Please enter 1 or 2.");
                break;
        }
        
        return idiomaSeleccionado;
    }

    /**
     * Muestra y gestiona el menú de control (Ejecutar o Finalizar) en el idioma
     * seleccionado.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param idioma La clave del idioma a utilizar para los textos.
     * @return La opción seleccionada (1 o 2), o -1 si la entrada fue inválida.
     */
    public int menuControl(Scanner scanner, String idioma) {
        int opcion = -1;
        
        System.out.println("\n" + Utilidades.getTexto(idioma, "MENU_CONTROL_TITULO"));
        System.out.println(Utilidades.getTexto(idioma, "MENU_CONTROL_OPCION_EJECUTAR"));
        System.out.println(Utilidades.getTexto(idioma, "MENU_CONTROL_OPCION_FINALIZAR"));
        System.out.print(Utilidades.getTexto(idioma, "MENU_CONTROL_PROMPT"));

        try {
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de nextInt
        } catch (InputMismatchException e) {
            // Manejar error de entrada no numérica
            System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA_CONTROL"));
            scanner.nextLine(); // Limpiar buffer
            opcion = -1;
        }
        
        return opcion;
    }

    /**
     * Muestra el menú específico para las operaciones de matrices (a, b, c).
     * @param scanner El objeto Scanner.
     * @param idioma La clave del idioma.
     * @return La opción seleccionada (1, 2, 3 o 4), o -1 si la entrada fue inválida.
     */
    public int menuOperacionesMatriz(Scanner scanner, String idioma) {
        int opcion = -1;
        
        System.out.println("\n" + Utilidades.getTexto(idioma, "MENU_MATRIZ_TITULO"));
        System.out.println(Utilidades.getTexto(idioma, "OPCION_SUMA_ALEATORIA"));      // Opción a
        System.out.println(Utilidades.getTexto(idioma, "OPCION_TRANSUESTA"));         // Opción b
        System.out.println(Utilidades.getTexto(idioma, "OPCION_IMPAR_PAR"));          // Opción c
        System.out.println(Utilidades.getTexto(idioma, "OPCION_VOLVER"));             // Opción d
        System.out.print(Utilidades.getTexto(idioma, "PROMPT_OPCION_NUM"));

        try {
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } catch (InputMismatchException e) {
            // Manejar error de entrada no numérica
            System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA_MATRIZ"));
            scanner.nextLine(); // Limpiar buffer
            opcion = -1;
        }
        
        return opcion;
    }
}