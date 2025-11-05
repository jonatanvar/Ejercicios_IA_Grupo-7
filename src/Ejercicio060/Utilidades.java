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

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 60 (Alinea ésta).
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Dibujo de Cuadrado Relleno");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        // Prompts y Títulos
        textosES.put("TITULO_OPERACIONES", "MÓDULO: DIBUJO DE CUADRADO RELLENO");
        textosES.put("PROMPT_LADO", "Ingrese la longitud del lado del cuadrado (entero positivo): ");
        textosES.put("PROMPT_CARACTER", "Ingrese el carácter de relleno (ej: #, $, *, etc.): ");
        
        // Mensajes de resultados
        textosES.put("MSG_RESULTADO", "--- Resultado del Dibujo ---");
        textosES.put("MSG_PARAMETROS", "Parámetros: Lado=%d, Carácter='%c'\n"); 

        // Mensajes de control y error
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: Entrada no válida. Por favor, ingrese un número entero positivo para el lado.");
        textosES.put("ERR_LADO_CERO", "\nERROR: El lado del cuadrado debe ser un entero positivo.");
        textosES.put("ERR_CARACTER_VACIO", "\nERROR: Debe ingresar al menos un carácter de relleno.");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");
        
        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Filled Square Drawing");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        // Prompts y Títulos
        textosEN.put("TITULO_OPERACIONES", "MODULE: FILLED SQUARE DRAWING");
        textosEN.put("PROMPT_LADO", "Enter the side length of the square (positive integer): ");
        textosEN.put("PROMPT_CARACTER", "Enter the filling character (e.g.: #, $, *, etc.): ");

        // Mensajes de resultados
        textosEN.put("MSG_RESULTADO", "--- Drawing Result ---");
        textosEN.put("MSG_PARAMETROS", "Parameters: Side=%d, Character='%c'\n");

        // Mensajes de control y error
        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: Invalid input. Please enter a positive integer number for the side.");
        textosEN.put("ERR_LADO_CERO", "\nERROR: The side of the square must be a positive integer.");
        textosEN.put("ERR_CARACTER_VACIO", "\nERROR: You must enter at least one filling character.");

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
