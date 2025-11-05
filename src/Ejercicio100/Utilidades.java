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

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas auxiliares, incluyendo la gestión
 * centralizada de textos multilingües para el Ejercicio 100 (Ordenamiento de Burbuja).
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Ordenamiento de Burbuja (10 enteros)");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        // Prompts y Mensajes de Operaciones
        textosES.put("TITULO_OPERACIONES", "MÓDULO: ORDENAMIENTO DE BURBUJA");
        textosES.put("MSG_INSTRUCCIONES_ENTRADA", "Por favor, ingrese 10 números enteros, uno a la vez:");
        textosES.put("PROMPT_ENTRADA_ELEMENTO", "Ingrese elemento %d de %d: ");
        textosES.put("MSG_ARREGLO_ORIGINAL", "Arreglo ingresado (Original):");
        textosES.put("MSG_ARREGLO_ORDENADO", "Arreglo ordenado (Burbuja):");

        // Mensajes de control y error
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: Entrada no válida. Por favor, ingrese un número entero.");

        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");

        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Bubble Sort (10 integers)");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        // Prompts y Mensajes de Operaciones
        textosEN.put("TITULO_OPERACIONES", "MODULE: BUBBLE SORT");
        textosEN.put("MSG_INSTRUCCIONES_ENTRADA", "Please enter 10 integer numbers, one at a time:");
        textosEN.put("PROMPT_ENTRADA_ELEMENTO", "Enter element %d of %d: ");
        textosEN.put("MSG_ARREGLO_ORIGINAL", "Array entered (Original):");
        textosEN.put("MSG_ARREGLO_ORDENADO", "Array sorted (Bubble Sort):");

        // Mensajes de control y error
        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: Invalid input. Please enter an integer number.");

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