/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 030 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que utiliza un ciclo for para encontrar el menor de varios enteros, donde el primer valor leído especifica el número de valores restantes. Incluye menús de idioma y control.
 */

package Ejercicio_030;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 30.
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Búsqueda del Menor Valor");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        textosES.put("TITULO_OPERACIONES", "MÓDULO: EL MENOR DE VARIOS ENTEROS (CICLO FOR)");
        textosES.put("PROMPT_CANTIDAD_VALORES", "Ingrese la cantidad de números que va a comparar (N > 0): ");
        textosES.put("MSG_CANTIDAD_INSUFICIENTE", "\nOperación cancelada: Se requiere ingresar al menos un valor (N > 0).");
        textosES.put("MSG_INSTRUCCION_VALORES", "Proceda a ingresar los ");
        textosES.put("MSG_PUNTOS", " valores restantes.");
        textosES.put("PROMPT_VALOR", "Valor ");
        
        textosES.put("MSG_RESULTADO_MENOR", "\nEl menor de los valores ingresados es: %d\n"); 

        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_ENTRADA_INVALIDA", "\nERROR: Entrada no válida. Por favor, ingrese un número entero.");
        textosES.put("ERR_ENTRADA_NEGATIVA", "\nERROR: El número de valores (N) debe ser un entero positivo.");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");
        
        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Find Smallest Value");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        textosEN.put("TITULO_OPERACIONES", "MODULE: FIND THE SMALLEST INTEGER (FOR LOOP)");
        textosEN.put("PROMPT_CANTIDAD_VALORES", "Enter the count of numbers to compare (N > 0): ");
        textosEN.put("MSG_CANTIDAD_INSUFICIENTE", "\nOperation canceled: You must enter at least one value (N > 0).");
        textosEN.put("MSG_INSTRUCCION_VALORES", "Proceed to enter the remaining ");
        textosEN.put("MSG_PUNTOS", " values.");
        textosEN.put("PROMPT_VALOR", "Value ");
        
        textosEN.put("MSG_RESULTADO_MENOR", "\nThe smallest of the entered values is: %d\n"); 

        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_ENTRADA_INVALIDA", "\nERROR: Invalid input. Please enter an integer number.");
        textosEN.put("ERR_ENTRADA_NEGATIVA", "\nERROR: The number of values (N) must be a positive integer.");

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
