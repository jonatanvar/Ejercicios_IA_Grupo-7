/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 050 | 2025-10-27
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que permite elegir entre 5 figuras geométricas (Círculo, Cuadrado, Triángulo, Rectángulo, Rombo), solicita sus dimensiones y calcula su área y perímetro, mostrando la figura y los resultados.
 */

package Ejercicio_050;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 50 (Figuras v2).
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Ejecutar Calculadora Geométrica (Figuras v2)");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");
        
        // Menú de figuras
        textosES.put("MENU_FIGURAS_TITULO", "--- SELECCIÓN DE FIGURA (Área y Perímetro) ---");
        textosES.put("FIGURA_CIRCULO", "1. Círculo");
        textosES.put("FIGURA_CUADRADO", "2. Cuadrado");
        textosES.put("FIGURA_TRIANGULO", "3. Triángulo");
        textosES.put("FIGURA_RECTANGULO", "4. Rectángulo");
        textosES.put("FIGURA_ROMBO", "5. Rombo");
        textosES.put("MENU_FIGURAS_OPCION_REGRESAR", "6. Regresar al Menú Anterior");
        textosES.put("MENU_FIGURAS_PROMPT", "Seleccione una figura (1-6): ");
        
        // Nombres de figuras
        textosES.put("FIGURA_1_NOMBRE", "Círculo");
        textosES.put("FIGURA_2_NOMBRE", "Cuadrado");
        textosES.put("FIGURA_3_NOMBRE", "Triángulo");
        textosES.put("FIGURA_4_NOMBRE", "Rectángulo");
        textosES.put("FIGURA_5_NOMBRE", "Rombo");

        // Prompts de entrada
        textosES.put("TITULO_OPERACIONES", "CÁLCULO GEOMÉTRICO");
        textosES.put("PROMPT_RADIO", "Ingrese el radio del círculo: ");
        textosES.put("PROMPT_LADO", "Ingrese la longitud del lado: ");
        textosES.put("PROMPT_TRIANGULO_BASE", "Ingrese la base del triángulo (para Área): ");
        textosES.put("PROMPT_TRIANGULO_ALTURA", "Ingrese la altura del triángulo (para Área): ");
        textosES.put("MSG_PERIMETRO_LADOS", "\n--- Para calcular el Perímetro del Triángulo, ingrese la longitud de sus tres lados ---");
        textosES.put("PROMPT_RECTANGULO_BASE", "Ingrese la base del rectángulo: ");
        textosES.put("PROMPT_RECTANGULO_ALTURA", "Ingrese la altura del rectángulo: ");
        textosES.put("PROMPT_ROMBO_DIAGONAL_MAYOR", "Ingrese la Diagonal Mayor (D) del rombo: ");
        textosES.put("PROMPT_ROMBO_DIAGONAL_MENOR", "Ingrese la Diagonal Menor (d) del rombo: ");
        textosES.put("PROMPT_ROMBO_LADO", "Ingrese la longitud del lado (l) del rombo: ");

        // Mensajes de resultados
        textosES.put("MSG_FIGURA_SELECCIONADA", "Figura Seleccionada");
        textosES.put("MSG_ENTRADAS_USUARIO", "\n--- Entradas del Usuario ---");
        textosES.put("RES_RADIO", "Radio: %.2f\n");
        textosES.put("RES_LADO", "Lado: %.2f\n");
        textosES.put("RES_BASE_ALTURA", "Base: %.2f, Altura: %.2f\n");
        textosES.put("RES_LADOS_TRIANGULO", "Lados: l1=%.2f, l2=%.2f, l3=%.2f\n");
        textosES.put("RES_DIAGONALES", "Diagonal Mayor (D): %.2f, Diagonal Menor (d): %.2f\n");
        
        textosES.put("MSG_RESULTADOS_CALCULADOS", "--- Resultados Calculados ---");
        textosES.put("RES_AREA", "Área: %.4f\n");
        textosES.put("RES_PERIMETRO", "Perímetro: %.4f\n");

        // Mensajes de control y error
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("MSG_REGRESAR", "\nRegresando al menú de control...");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_OPCION_INVALIDA_FIGURA", "\nERROR: Opción no válida. Por favor, ingrese un número entre 1 y 6.");
        textosES.put("ERR_ENTRADA_INVALIDA_DOUBLE", "\nERROR: Entrada no válida. Por favor, ingrese un número real.");
        textosES.put("ERR_ENTRADA_NEGATIVA", "\nERROR: La dimensión debe ser un valor no negativo.");
        textosES.put("ERR_DIMENSION_CERO", "\nERROR: La operación requiere dimensiones válidas (mayores a 0) para el cálculo.");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");
        
        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Execute Geometric Calculator (Figures v2)");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        // Menú de figuras
        textosEN.put("MENU_FIGURAS_TITULO", "--- FIGURE SELECTION (Area and Perimeter) ---");
        textosEN.put("FIGURA_CIRCULO", "1. Circle");
        textosEN.put("FIGURA_CUADRADO", "2. Square");
        textosEN.put("FIGURA_TRIANGULO", "3. Triangle");
        textosEN.put("FIGURA_RECTANGULO", "4. Rectangle");
        textosEN.put("FIGURA_ROMBO", "5. Rhombus");
        textosEN.put("MENU_FIGURAS_OPCION_REGRESAR", "6. Return to Previous Menu");
        textosEN.put("MENU_FIGURAS_PROMPT", "Select a figure (1-6): ");
        
        // Nombres de figuras
        textosEN.put("FIGURA_1_NOMBRE", "Circle");
        textosEN.put("FIGURA_2_NOMBRE", "Square");
        textosEN.put("FIGURA_3_NOMBRE", "Triangle");
        textosEN.put("FIGURA_4_NOMBRE", "Rectangle");
        textosEN.put("FIGURA_5_NOMBRE", "Rhombus");

        // Prompts de entrada
        textosEN.put("TITULO_OPERACIONES", "GEOMETRIC CALCULATION");
        textosEN.put("PROMPT_RADIO", "Enter the circle's radius: ");
        textosEN.put("PROMPT_LADO", "Enter the side length: ");
        textosEN.put("PROMPT_TRIANGULO_BASE", "Enter the triangle's base (for Area): ");
        textosEN.put("PROMPT_TRIANGULO_ALTURA", "Enter the triangle's height (for Area): ");
        textosEN.put("MSG_PERIMETRO_LADOS", "\n--- To calculate the Triangle's Perimeter, enter the length of its three sides ---");
        textosEN.put("PROMPT_RECTANGULO_BASE", "Enter the rectangle's base: ");
        textosEN.put("PROMPT_RECTANGULO_ALTURA", "Enter the rectangle's height: ");
        textosEN.put("PROMPT_ROMBO_DIAGONAL_MAYOR", "Enter the Major Diagonal (D) of the rhombus: ");
        textosEN.put("PROMPT_ROMBO_DIAGONAL_MENOR", "Enter the Minor Diagonal (d) of the rhombus: ");
        textosEN.put("PROMPT_ROMBO_LADO", "Enter the side length (l) of the rhombus: ");

        // Mensajes de resultados
        textosEN.put("MSG_FIGURA_SELECCIONADA", "Selected Figure");
        textosEN.put("MSG_ENTRADAS_USUARIO", "\n--- User Inputs ---");
        textosEN.put("RES_RADIO", "Radius: %.2f\n");
        textosEN.put("RES_LADO", "Side: %.2f\n");
        textosEN.put("RES_BASE_ALTURA", "Base: %.2f, Height: %.2f\n");
        textosEN.put("RES_LADOS_TRIANGULO", "Sides: l1=%.2f, l2=%.2f, l3=%.2f\n");
        textosEN.put("RES_DIAGONALES", "Major Diagonal (D): %.2f, Minor Diagonal (d): %.2f\n");

        textosEN.put("MSG_RESULTADOS_CALCULADOS", "--- Calculated Results ---");
        textosEN.put("RES_AREA", "Area: %.4f\n");
        textosEN.put("RES_PERIMETRO", "Perimeter: %.4f\n");

        // Mensajes de control y error
        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("MSG_REGRESAR", "\nReturning to the control menu...");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_OPCION_INVALIDA_FIGURA", "\nERROR: Invalid option. Please enter a number between 1 and 6.");
        textosEN.put("ERR_ENTRADA_INVALIDA_DOUBLE", "\nERROR: Invalid input. Please enter a real number.");
        textosEN.put("ERR_ENTRADA_NEGATIVA", "\nERROR: Dimension must be a non-negative value.");
        textosEN.put("ERR_DIMENSION_CERO", "\nERROR: Operation requires valid dimensions (greater than 0) for calculation.");

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
