/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 020 | 2025-10-22
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que calcula y muestra los ingresos semanales de múltiples vendedores (salario base + 9% de comisión), usando un ciclo while y dos niveles de menú (idioma y control).
 */

package Ejercicio_020;

import java.util.Scanner;

/**
 * Archivo principal (Main.java). Contiene el punto de entrada del programa.
 * Orquesta la inicialización del sistema, la selección de idioma y el flujo
 * principal de ejecución.
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicializa el objeto Scanner para la entrada de datos
        Scanner scanner = new Scanner(System.in);
        
        // 1. Instancia del gestor de menús y utilidades
        Menus menus = new Menus();
        
        // La variable 'idioma' almacena la clave del idioma seleccionado ("ES" o "EN")
        String idioma = "";
        
        // Ciclo principal para la selección de idioma
        while (idioma.isEmpty()) {
            idioma = menus.menuSeleccionIdioma(scanner);
        }
        
        // 2. Variables de control para el segundo menú
        int opcionEjecucion = -1;
        boolean continuar = true;
        
        // Ciclo principal del programa: ejecuta el ejercicio o finaliza
        while (continuar) {
            
            // Muestra el menú de control (Ejecutar/Finalizar)
            opcionEjecucion = menus.menuControl(scanner, idioma);
            
            switch (opcionEjecucion) {
                case 1:
                    // Opción: Ejecutar el ejercicio
                    Operaciones operaciones = new Operaciones(idioma);
                    operaciones.procesarVendedores(scanner);
                    break;
                case 2:
                    // Opción: Finalizar el programa
                    System.out.println(Utilidades.getTexto(idioma, "MSG_FINALIZAR"));
                    continuar = false;
                    break;
                default:
                    // Mensaje de error (opción no válida)
                    System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA"));
                    break;
            }
        }
        
        // Cierra el scanner al finalizar la ejecución
        scanner.close();
    }
}
