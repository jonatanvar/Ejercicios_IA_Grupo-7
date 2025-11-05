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

import java.util.Scanner;

/**
 * Archivo principal (Main.java). Contiene el punto de entrada del programa.
 * Orquesta la inicialización, la selección de idioma y el flujo
 * principal de ejecución, incluyendo el menú de operaciones de matrices.
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicializa el objeto Scanner para la entrada de datos
        Scanner scanner = new Scanner(System.in);
        
        // 1. Inicialización de utilidades y menús
        Menus menus = new Menus();
        String idioma = "";
        
        // Ciclo para asegurar la selección de idioma
        while (idioma.isEmpty()) {
            idioma = menus.menuSeleccionIdioma(scanner);
        }
        
        // 2. Variables de control para el segundo menú (Ciclo Principal)
        int opcionControl = -1;
        boolean continuar = true;
        Operaciones operaciones = new Operaciones(idioma); // Instancia de operaciones
        
        while (continuar) {
            
            // Muestra el menú de control
            opcionControl = menus.menuControl(scanner, idioma);
            
            switch (opcionControl) {
                case 1:
                    // Opción 1: Ejecutar el módulo de Matrices
                    ejecutarOperacionesMatrices(scanner, operaciones, menus, idioma);
                    break;
                case 2:
                    // Opción 2: Finalizar el programa
                    System.out.println(Utilidades.getTexto(idioma, "MSG_FINALIZAR"));
                    continuar = false;
                    break;
                default:
                    // Mensaje de error (opción no válida)
                    System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA_CONTROL"));
                    break;
            }
        }
        
        // Cierra el scanner al finalizar la ejecución
        scanner.close();
    }
    
    /**
     * Gestiona el bucle del menú de operaciones específicas (a, b, c).
     * @param scanner El objeto Scanner.
     * @param operaciones Instancia de Operaciones.
     * @param menus Instancia de Menus.
     * @param idioma Clave del idioma.
     */
    private static void ejecutarOperacionesMatrices(Scanner scanner, Operaciones operaciones, Menus menus, String idioma) {
        int opcionMatriz = -1;
        boolean gestionando = true;
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        System.out.printf(
            Utilidades.getTexto(idioma, "MSG_ORDEN_MATRIZ"), 
            Utilidades.ORDEN_MATRIZ, // Primer %d
            Utilidades.ORDEN_MATRIZ  // Segundo %d
        );
        
        while (gestionando) {
            opcionMatriz = menus.menuOperacionesMatriz(scanner, idioma);
            
            switch (opcionMatriz) {
                case 1:
                    // Opción a: Llenar aleatorio y Sumar matrices
                    operaciones.opcionLlenadoYSuma();
                    break;
                case 2:
                    // Opción b: Transpuesta de la primera matriz
                    operaciones.opcionTranspuesta();
                    break;
                case 3:
                    // Opción c: Llenar impares/pares y mostrar
                    operaciones.opcionLlenadoImparPar();
                    break;
                case 4:
                    // Opción d: Volver al menú principal
                    gestionando = false;
                    break;
                default:
                    System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA_MATRIZ"));
                    break;
            }
        }
    }
}