/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 111 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que realiza diversas operaciones (suma, transpuesta, llenado especial) con matrices cuadradas del mismo orden.
 */

package Ejercicio_111;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas auxiliares, incluyendo la constante
 * para el orden de las matrices y la gestión centralizada de textos multilingües.
 */
public class Utilidades {

    // Constante pública para el orden (N) de las matrices (NxN)
    public static final int ORDEN_MATRIZ = 4; // Definimos un orden 4x4, por ejemplo.

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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Operaciones de Matrices");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");
        
        // Menú de Operaciones de Matriz
        textosES.put("TITULO_OPERACIONES", "MÓDULO: OPERACIONES CON MATRICES CUADRADAS");
        textosES.put("MSG_ORDEN_MATRIZ", "El programa trabajará con matrices de orden %dx%d.\n");
        textosES.put("MENU_MATRIZ_TITULO", "--- SELECCIONE OPERACIÓN ---");
        textosES.put("OPCION_SUMA_ALEATORIA", "1. Llenar Aleatorio y Sumar (Opción a)");
        textosES.put("OPCION_TRANSUESTA", "2. Obtener la Transpuesta (Opción b)");
        textosES.put("OPCION_IMPAR_PAR", "3. Llenar Impares/Pares (Opción c)");
        textosES.put("OPCION_VOLVER", "4. Volver al Menú Principal");
        textosES.put("PROMPT_OPCION_NUM", "Seleccione una opción (1 a 4): ");

        // Títulos de Matrices (Opción a)
        textosES.put("TITULO_MATRIZ_A_ALEATORIO", "Matriz A (Aleatoria)");
        textosES.put("TITULO_MATRIZ_B_ALEATORIO", "Matriz B (Aleatoria)");
        textosES.put("TITULO_MATRIZ_C_SUMA", "Matriz C (Suma A + B)");
        
        // Títulos de Matrices (Opción b)
        textosES.put("TITULO_MATRIZ_A_TRANS_ORIGINAL", "Matriz A (Original para Transpuesta)");
        textosES.put("TITULO_MATRIZ_B_TRANS_RESULTADO", "Matriz B (Transpuesta de A)");
        
        // Títulos de Matrices (Opción c)
        textosES.put("TITULO_MATRIZ_A_IMPAR", "Matriz A (Números Impares)");
        textosES.put("TITULO_MATRIZ_B_PAR", "Matriz B (Números Pares = A[i][j] - 1)");

        // Mensajes de control y error
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("ERR_OPCION_INVALIDA_CONTROL", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_OPCION_INVALIDA_MATRIZ", "\nERROR: Opción no válida. Por favor, ingrese un número entre 1 y 4.");

        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");

        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Matrix Operations");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");
        
        // Menú de Operaciones de Matriz
        textosEN.put("TITULO_OPERACIONES", "MODULE: SQUARE MATRIX OPERATIONS");
        textosEN.put("MSG_ORDEN_MATRIZ", "The program will work with matrices of order %dx%d.\n");
        textosEN.put("MENU_MATRIZ_TITULO", "--- SELECT OPERATION ---");
        textosEN.put("OPCION_SUMA_ALEATORIA", "1. Random Fill and Sum (Option a)");
        textosEN.put("OPCION_TRANSUESTA", "2. Get Transpose (Option b)");
        textosEN.put("OPCION_IMPAR_PAR", "3. Odd/Even Fill (Option c)");
        textosEN.put("OPCION_VOLVER", "4. Back to Main Menu");
        textosEN.put("PROMPT_OPCION_NUM", "Select an option (1 to 4): ");

        // Títulos de Matrices (Opción a)
        textosEN.put("TITULO_MATRIZ_A_ALEATORIO", "Matrix A (Random)");
        textosEN.put("TITULO_MATRIZ_B_ALEATORIO", "Matrix B (Random)");
        textosEN.put("TITULO_MATRIZ_C_SUMA", "Matrix C (Sum A + B)");
        
        // Títulos de Matrices (Opción b)
        textosEN.put("TITULO_MATRIZ_A_TRANS_ORIGINAL", "Matrix A (Original for Transpose)");
        textosEN.put("TITULO_MATRIZ_B_TRANS_RESULTADO", "Matrix B (Transpose of A)");
        
        // Títulos de Matrices (Opción c)
        textosEN.put("TITULO_MATRIZ_A_IMPAR", "Matrix A (Odd Numbers)");
        textosEN.put("TITULO_MATRIZ_B_PAR", "Matrix B (Even Numbers = A[i][j] - 1)");

        // Mensajes de control y error
        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("ERR_OPCION_INVALIDA_CONTROL", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_OPCION_INVALIDA_MATRIZ", "\nERROR: Invalid option. Please enter a number between 1 and 4.");

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