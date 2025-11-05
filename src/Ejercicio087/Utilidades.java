/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 087 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que gestiona un archivo de texto, permitiendo al usuario ver su contenido y agregar mensajes en nuevas líneas.
 */

package Ejercicio_087;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas auxiliares, incluyendo la constante
 * del archivo de trabajo y la gestión centralizada de textos multilingües.
 */
public class Utilidades {

    // Constante pública para el nombre del archivo de mensajes
    public static final String NOMBRE_ARCHIVO = "mensajes.txt";

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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Gestión de Archivos");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        // Menú de Operaciones de Archivo
        textosES.put("TITULO_OPERACIONES", "MÓDULO: GESTIÓN DE ARCHIVO '" + NOMBRE_ARCHIVO + "'");
        textosES.put("MENU_ARCHIVO_TITULO", "--- MENÚ DE ARCHIVO ---");
        textosES.put("OPCION_MOSTRAR_CONTENIDO", "1. Mostrar contenido del archivo");
        textosES.put("OPCION_AGREGAR_MENSAJE", "2. Agregar mensaje");
        textosES.put("OPCION_VOLVER", "3. Volver al Menú Principal");
        textosES.put("PROMPT_OPCION_NUM", "Seleccione una opción (1, 2 o 3): ");

        // Mensajes del archivo
        textosES.put("MSG_CONTENIDO_TITULO", "Contenido de '" + NOMBRE_ARCHIVO + "'");
        textosES.put("MSG_ARCHIVO_NO_EXISTE", "El archivo aún no existe o no tiene contenido.");
        textosES.put("MSG_ARCHIVO_VACIO", "(El archivo está vacío)");
        textosES.put("PROMPT_MENSAJE", "Ingrese el mensaje a agregar: ");
        textosES.put("MSG_MENSAJE_AGREGADO", "¡Mensaje agregado exitosamente a '" + NOMBRE_ARCHIVO + "'!");

        // Mensajes y Errores
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA_CONTROL", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_OPCION_INVALIDA_ARCHIVO", "\nERROR: Opción no válida. Por favor, ingrese 1, 2 o 3.");
        textosES.put("ERR_MENSAJE_VACIO", "\nERROR: El mensaje no puede estar vacío.");
        textosES.put("ERR_LECTURA", "\nERROR DE LECTURA DE ARCHIVO: ");
        textosES.put("ERR_ESCRITURA", "\nERROR DE ESCRITURA EN ARCHIVO: ");

        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");

        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. File Management");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        // Menú de Operaciones de Archivo
        textosEN.put("TITULO_OPERACIONES", "MODULE: FILE MANAGEMENT '" + NOMBRE_ARCHIVO + "'");
        textosEN.put("MENU_ARCHIVO_TITULO", "--- FILE MENU ---");
        textosEN.put("OPCION_MOSTRAR_CONTENIDO", "1. Display file content");
        textosEN.put("OPCION_AGREGAR_MENSAJE", "2. Append message");
        textosEN.put("OPCION_VOLVER", "3. Back to Main Menu");
        textosEN.put("PROMPT_OPCION_NUM", "Select an option (1, 2 or 3): ");

        // Mensajes del archivo
        textosEN.put("MSG_CONTENIDO_TITULO", "Content of '" + NOMBRE_ARCHIVO + "'");
        textosEN.put("MSG_ARCHIVO_NO_EXISTE", "The file does not exist yet or has no content.");
        textosEN.put("MSG_ARCHIVO_VACIO", "(The file is empty)");
        textosEN.put("PROMPT_MENSAJE", "Enter the message to append: ");
        textosEN.put("MSG_MENSAJE_AGREGADO", "Message successfully appended to '" + NOMBRE_ARCHIVO + "'!");

        // Mensajes y Errores
        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA_CONTROL", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_OPCION_INVALIDA_ARCHIVO", "\nERROR: Invalid option. Please enter 1, 2 or 3.");
        textosEN.put("ERR_MENSAJE_VACIO", "\nERROR: Message cannot be empty.");
        textosEN.put("ERR_LECTURA", "\nFILE READING ERROR: ");
        textosEN.put("ERR_ESCRITURA", "\nFILE WRITING ERROR: ");

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
