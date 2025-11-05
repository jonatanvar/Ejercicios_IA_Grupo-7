/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 087 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que gestiona un archivo de texto, permitiendo al usuario ver su contenido y agregar mensajes en nuevas líneas (Ejercicio 87).
 */

package Ejercicio_087;

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
        
        // 1. Instancia del gestor de menús y variables de control
        Menus menus = new Menus();
        String idioma = "";
        
        // Ciclo principal para la selección de idioma
        while (idioma.isEmpty()) {
            idioma = menus.menuSeleccionIdioma(scanner);
        }
        
        // 2. Bucle principal del programa
        int opcionControl = -1;
        boolean continuar = true;
        Operaciones operaciones = new Operaciones(idioma); // Instancia de operaciones
        
        while (continuar) {
            
            // Muestra el menú de control (Ejecutar/Finalizar)
            opcionControl = menus.menuControl(scanner, idioma);
            
            switch (opcionControl) {
                case 1:
                    // Opción 1: Ejecutar la gestión de archivos
                    ejecutarGestionArchivos(scanner, operaciones, menus, idioma);
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
     * Gestiona el bucle del menú de operaciones de archivo (Mostrar/Agregar).
     * @param scanner El objeto Scanner.
     * @param operaciones Instancia de Operaciones.
     * @param menus Instancia de Menus.
     * @param idioma Clave del idioma.
     */
    private static void ejecutarGestionArchivos(Scanner scanner, Operaciones operaciones, Menus menus, String idioma) {
        int opcionArchivo = -1;
        boolean gestionando = true;
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        
        while (gestionando) {
            opcionArchivo = menus.menuOperacionesArchivo(scanner, idioma);
            
            switch (opcionArchivo) {
                case 1:
                    // Opción a: Mostrar contenido
                    operaciones.mostrarContenidoArchivo();
                    break;
                case 2:
                    // Opción b: Agregar mensaje
                    operaciones.agregarMensaje(scanner);
                    break;
                case 3:
                    // Opción c: Volver al menú principal
                    gestionando = false;
                    break;
                default:
                    System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA_ARCHIVO"));
                    break;
            }
        }
    }
}
