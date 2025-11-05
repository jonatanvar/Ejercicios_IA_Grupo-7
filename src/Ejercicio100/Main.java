/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 100 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que ordena un arreglo de 10 enteros ingresados por el usuario mediante el algoritmo de Ordenamiento de Burbuja.
 */

package Ejercicio_100;

import java.util.Scanner;

/**
 * Archivo principal (Main.java). Contiene el punto de entrada del programa.
 * Orquesta la inicialización, la selección de idioma y el flujo
 * principal de ejecución (Menú de Control).
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
                    // Opción 1: Ejecutar el Ordenamiento de Burbuja
                    ejecutarOrdenamiento(scanner, operaciones, idioma);
                    break;
                case 2:
                    // Opción 2: Finalizar el programa
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
    
    /**
     * Lógica para el manejo de la operación de ordenamiento.
     * @param scanner El objeto Scanner.
     * @param operaciones Instancia de Operaciones.
     * @param idioma Clave del idioma.
     */
    private static void ejecutarOrdenamiento(Scanner scanner, Operaciones operaciones, String idioma) {
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");

        // 1. Leer los 10 elementos del arreglo con validación
        int[] arreglo = operaciones.leerArreglo(scanner, 10);
        
        if (arreglo == null) {
            // Error de lectura (ej: entrada inválida), volver al menú principal
            return;
        }

        // 2. Mostrar el arreglo original
        operaciones.mostrarArreglo(arreglo, Utilidades.getTexto(idioma, "MSG_ARREGLO_ORIGINAL"));
        
        // 3. Aplicar el ordenamiento de burbuja (Función obligatoria)
        operaciones.ordenamientoBurbuja(arreglo);
        
        // 4. Mostrar el arreglo ordenado
        operaciones.mostrarArreglo(arreglo, Utilidades.getTexto(idioma, "MSG_ARREGLO_ORDENADO"));
    }
}