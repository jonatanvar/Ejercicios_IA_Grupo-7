/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 060 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Modificación del ejercicio "Alineado". Programa que dibuja un cuadrado relleno, cuyo lado y carácter de relleno son especificados por el usuario, utilizando una función obligatoria.
 */

package Ejercicio_060;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Módulo Menús: Se encarga de mostrar y gestionar las opciones de navegación
 * del programa, incluyendo el menú de selección de idioma y el menú de control
 * (ejecutar/finalizar), utilizando ciclos y manejo de excepciones.
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
            System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA"));
            scanner.nextLine(); // Limpiar buffer
            opcion = -1;
        }
        
        return opcion;
    }
}
