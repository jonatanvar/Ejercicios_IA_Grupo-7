/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 069 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa CAI que enseña multiplicación con retroalimentación variable y aleatoria para mantener la atención del estudiante.
 */

package Ejercicio_069;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 69 (CAI). Incluye los mensajes de
 * retroalimentación variable.
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Iniciar Instrucción Asistida por Computadora (CAI)");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        // Prompts y Títulos del CAI
        textosES.put("TITULO_OPERACIONES", "MÓDULO: INSTRUCCIÓN ASISTIDA POR COMPUTADORA (CAI)");
        textosES.put("MSG_INSTRUCCIONES", "Responda las preguntas de multiplicación. Ingrese 0 para salir en cualquier momento.");
        textosES.put("MSG_PREGUNTA", "¿Cuánto es %d por %d? ");
        textosES.put("MSG_PREGUNTA_REPETIR", "El problema sigue siendo: ¿Cuánto es %d por %d? "); // Usado para repetir la pregunta después de una respuesta incorrecta
        textosES.put("PROMPT_RESPUESTA", "Su respuesta: ");
        textosES.put("MSG_FIN_SESION", "Fin de la sesión CAI. Regresando al menú principal.");
        
        // --- Retroalimentación Variable (4 Correctas) ---
        textosES.put("RESPUESTA_CORRECTA_1", "Muy bien!");
        textosES.put("RESPUESTA_CORRECTA_2", "Excelente!");
        textosES.put("RESPUESTA_CORRECTA_3", "Buen trabajo!");
        textosES.put("RESPUESTA_CORRECTA_4", "Sigue así!");

        // --- Retroalimentación Variable (4 Incorrectas) ---
        textosES.put("RESPUESTA_INCORRECTA_1", "No. Por favor intenta de nuevo.");
        textosES.put("RESPUESTA_INCORRECTA_2", "Incorrecto. Intenta una vez más.");
        textosES.put("RESPUESTA_INCORRECTA_3", "No te rindas!");
        textosES.put("RESPUESTA_INCORRECTA_4", "No. Sigue intentando.");

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
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Start Computer-Assisted Instruction (CAI)");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        // Prompts y Títulos del CAI
        textosEN.put("TITULO_OPERACIONES", "MODULE: COMPUTER-ASSISTED INSTRUCTION (CAI)");
        textosEN.put("MSG_INSTRUCCIONES", "Answer the multiplication questions. Enter 0 to exit at any time.");
        textosEN.put("MSG_PREGUNTA", "How much is %d times %d? ");
        textosEN.put("MSG_PREGUNTA_REPETIR", "The problem is still: How much is %d times %d? ");
        textosEN.put("PROMPT_RESPUESTA", "Your answer: ");
        textosEN.put("MSG_FIN_SESION", "End of CAI session. Returning to the main menu.");
        
        // --- Retroalimentación Variable (4 Correctas) ---
        textosEN.put("RESPUESTA_CORRECTA_1", "Very good!");
        textosEN.put("RESPUESTA_CORRECTA_2", "Excellent!");
        textosEN.put("RESPUESTA_CORRECTA_3", "Nice work!");
        textosEN.put("RESPUESTA_CORRECTA_4", "Keep up the good work!");

        // --- Retroalimentación Variable (4 Incorrectas) ---
        textosEN.put("RESPUESTA_INCORRECTA_1", "No. Please try again.");
        textosEN.put("RESPUESTA_INCORRECTA_2", "Incorrect. Try once more.");
        textosEN.put("RESPUESTA_INCORRECTA_3", "Don't give up!");
        textosEN.put("RESPUESTA_INCORRECTA_4", "No. Keep trying.");

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
