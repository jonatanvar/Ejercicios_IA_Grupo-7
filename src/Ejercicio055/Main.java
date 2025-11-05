/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 055 | 2025-10-27
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que simula un juego de dados (apuesta sobre la suma de dos dados) con crédito inicial de L. 1000.00, funciones obligatorias (lanzar, sumar, dibujar, ganancia), control de crédito y opción de retiro tras 5 turnos.
 */

package Ejercicio_055;

import java.util.Scanner;

/**
 * Archivo principal (Main.java). Contiene el punto de entrada del programa.
 * Orquesta la inicialización, la selección de idioma y el flujo
 * principal de ejecución (Ejecutar/Finalizar).
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicializa el objeto Scanner para la entrada de datos
        Scanner scanner = new Scanner(System.in);
        
        // 1. Instancia del gestor de menús y variables de control
        Menus menus = new Menus();
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
                    // Opción: Ejecutar el juego de dados
                    Operaciones operaciones = new Operaciones(idioma);
                    operaciones.iniciarJuego(scanner);
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
