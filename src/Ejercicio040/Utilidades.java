/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 040 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que lee una serie de enteros no negativos (deteniéndose en el primero negativo) y luego imprime una tabla con N, N², N³, 2N-1 y sus totales, utilizando un ciclo para la lectura y menús de idioma y control.
 */

package Ejercicio_040;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 40, incluyendo etiquetas de la tabla.
 */
public class Utilidades {

    // Mapa estático para almacenar todos los textos de la aplicación por idioma y clave
    private static final Map<String, Map<String, String>> TEXTOS = new HashMap<>();

    // Bloque estático para inicializar el mapa de textos al cargar la clase
    static {
        // --- TEXTOS EN ESPAÑOL (ES) ---
        Map<String, String> textosES = new HashMap<>();
        textosES.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosES.put("MENU_IDIOMA_OPCION_ES", "1. Español");
        textosES.put("MENU_IDIOMA_OPCION_EN", "2. Inglés (English)");
        textosES.put("MENU_IDIOMA_PROMPT", "Seleccione el idioma (1 o 2): ");
        
        textosES.put("MENU_CONTROL_TITULO", "--- MENÚ DE CONTROL ---");
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Tabla de Valores Positivos");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        textosES.put("TITULO_OPERACIONES", "MÓDULO: SEAMOS POSITIVOS (TABLA Y TOTALES)");
        textosES.put("MSG_INSTRUCCION_LECTURA", "Ingrese números enteros no negativos. Ingrese un número negativo para detener la lectura y generar la tabla.");
        textosES.put("PROMPT_ENTERO", "Ingrese número: ");
        
        textosES.put("MSG_TITULO_TABLA", "--- RESULTADOS ---");
        textosES.put("COL_INDICE", "#");
        textosES.put("COL_N", "N");
        textosES.put("COL_N2", "N²");
        textosES.put("COL_N3", "N³");
        textosES.put("COL_2N1", "2N-1");
        textosES.put("COL_TOTALES", "Totales");
        textosES.put("MSG_SIN_DATOS", "\nNo se ingresó ningún número positivo. Tabla no generada.");
        
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_ENTRADA_INVALIDA", "\nERROR: Entrada no válida. Por favor, ingrese un número entero.");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");
        
        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Positive Values Table");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        textosEN.put("TITULO_OPERACIONES", "MODULE: BE POSITIVE (TABLE AND TOTALS)");
        textosEN.put("MSG_INSTRUCCION_LECTURA", "Enter non-negative integers. Enter a negative number to stop reading and generate the table.");
        textosEN.put("PROMPT_ENTERO", "Enter number: ");
        
        textosEN.put("MSG_TITULO_TABLA", "--- RESULTS ---");
        textosEN.put("COL_INDICE", "#");
        textosEN.put("COL_N", "N");
        textosEN.put("COL_N2", "N²");
        textosEN.put("COL_N3", "N³");
        textosEN.put("COL_2N1", "2N-1");
        textosEN.put("COL_TOTALES", "Totals");
        textosEN.put("MSG_SIN_DATOS", "\nNo positive numbers were entered. Table not generated.");

        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_ENTRADA_INVALIDA", "\nERROR: Invalid input. Please enter an integer number.");

        TEXTOS.put("EN", textosEN);
    }

    /**
     * Obtiene el texto correspondiente a una clave en el idioma especificado.
     * @param idioma La clave del idioma ("ES" o "EN").
     * @param clave La clave del texto a recuperar.
     * @return El texto en el idioma solicitado o un mensaje de error si no se encuentra.
     */
    public static String getTexto(String idioma, String clave) {
        if (TEXTOS.containsKey(idioma) && TEXTOS.get(idioma).containsKey(clave)) {
            return TEXTOS.get(idioma).get(clave);
        }
        return "!!! TEXTO NO ENCONTRADO [" + idioma + ":" + clave + "] !!!";
    }
}
