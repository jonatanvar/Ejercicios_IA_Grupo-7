/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 045 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que calcula la potencia B^E (donde E puede ser positivo, negativo o cero) sin usar Math.pow, implementando menús de idioma y control.
 */

package Ejercicio_045;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 45.
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Cálculo de Potencia");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        textosES.put("TITULO_OPERACIONES", "MÓDULO: CÁLCULO DE POTENCIA B^E (SIN MATH.POW)");
        textosES.put("PROMPT_BASE", "Ingrese la Base (B - número real): ");
        textosES.put("PROMPT_EXPONENTE", "Ingrese el Exponente (E - número entero): ");
        
        textosES.put("MSG_RESULTADO", "\nRESULTADO: %.2f elevado a la potencia %d es igual a: %.4f\n"); 
        
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: El exponente debe ser un número entero válido.");
        textosES.put("ERR_ENTRADA_INVALIDA_DOUBLE", "\nERROR: La base debe ser un número real válido.");
        textosES.put("ERR_BASE_CERO_NEGATIVO", "\nERROR: Cero elevado a potencia negativa es una forma indeterminada o infinito. Operación no válida.");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");
        
        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Power Calculation");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        textosEN.put("TITULO_OPERACIONES", "MODULE: POWER CALCULATION B^E (WITHOUT MATH.POW)");
        textosEN.put("PROMPT_BASE", "Enter the Base (B - real number): ");
        textosEN.put("PROMPT_EXPONENTE", "Enter the Exponent (E - integer number): ");
        
        textosEN.put("MSG_RESULTADO", "\nRESULT: %.2f raised to the power of %d equals: %.4f\n"); 

        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: The exponent must be a valid integer number.");
        textosEN.put("ERR_ENTRADA_INVALIDA_DOUBLE", "\nERROR: The base must be a valid real number.");
        textosEN.put("ERR_BASE_CERO_NEGATIVO", "\nERROR: Zero raised to a negative power is an indeterminate form or infinity. Operation not valid.");

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
