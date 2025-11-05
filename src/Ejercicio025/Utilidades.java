/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 025 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que lee tres enteros y determina si pueden ser los lados de un triángulo rectángulo (Teorema de Pitágoras), usando menús de idioma y control.
 */

package Ejercicio_025;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 25.
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Verificación de Triángulo Rectángulo");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        textosES.put("TITULO_OPERACIONES", "MÓDULO: TRIÁNGULO RECTÁNGULO (TEOREMA DE PITÁGORAS)");
        textosES.put("MSG_INSTRUCCION_LADOS", "Introduzca las longitudes (enteros positivos) de los tres lados del triángulo:");
        textosES.put("PROMPT_LADO", "Lado ");
        
        textosES.put("MSG_RESULTADO_RECTO", "\nRESULTADO: Los lados %d, %d y %d PUEDEN formar un triángulo rectángulo (a^2 + b^2 = c^2)."); 
        textosES.put("MSG_RESULTADO_NO_RECTO", "\nRESULTADO: Los lados %d, %d y %d NO pueden formar un triángulo rectángulo.");

        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_ENTRADA_INVALIDA", "\nERROR: Entrada no válida. Por favor, ingrese un número entero.");
        textosES.put("ERR_ENTRADA_NEGATIVA", "\nERROR: La longitud del lado debe ser un entero positivo (mayor que cero).");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");
        
        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Right Triangle Check");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        textosEN.put("TITULO_OPERACIONES", "MODULE: RIGHT TRIANGLE CHECK (PYTHAGOREAN THEOREM)");
        textosEN.put("MSG_INSTRUCCION_LADOS", "Enter the lengths (positive integers) of the three sides of the triangle:");
        textosEN.put("PROMPT_LADO", "Side ");
        
        textosEN.put("MSG_RESULTADO_RECTO", "\nRESULT: Sides %d, %d, and %d CAN form a right triangle (a^2 + b^2 = c^2)."); 
        textosEN.put("MSG_RESULTADO_NO_RECTO", "\nRESULT: Sides %d, %d, and %d CANNOT form a right triangle.");

        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_ENTRADA_INVALIDA", "\nERROR: Invalid input. Please enter an integer number.");
        textosEN.put("ERR_ENTRADA_NEGATIVA", "\nERROR: The side length must be a positive integer (greater than zero).");

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
