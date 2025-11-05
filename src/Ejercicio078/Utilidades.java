/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 078 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Modificación del programa "Simple venta" para implementar una librería propia (GestorVenta) que maneje la lógica compleja de descuentos e impuestos.
 */

package Ejercicio_078;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 78 (Modificación Simple Venta).
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Simular Venta");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");

        // Prompts de Operaciones
        textosES.put("TITULO_OPERACIONES", "MÓDULO: CÁLCULO DE VENTA Y LIBRERÍA PROPIA");
        textosES.put("PROMPT_CANTIDAD", "Ingrese la cantidad total de artículos: ");
        textosES.put("PROMPT_PRECIO_UNITARIO", "Ingrese el precio unitario (L.): ");
        textosES.put("PROMPT_TERCERA_EDAD", "¿El cliente es de la tercera edad?");
        textosES.put("OPCION_SI", "1. Sí");
        textosES.put("OPCION_NO", "2. No");
        textosES.put("PROMPT_OPCION_NUM", "Seleccione una opción (1 o 2): ");

        // Etiquetas de Resultados
        textosES.put("TITULO_RESULTADOS", "--- DETALLE DE LA VENTA ---");
        textosES.put("RES_TERCERA_EDAD", "Estatus 3ra. Edad:");
        textosES.put("RES_SI", "SÍ");
        textosES.put("RES_NO", "NO");
        textosES.put("RES_SUBTOTAL", "Total Bruto (Subtotal):");
        textosES.put("RES_DESCUENTO", "Descuento:");
        textosES.put("RES_IMPUESTO", "Impuesto (IVA):");
        textosES.put("RES_TOTAL_NETO", "TOTAL NETO A PAGAR:");
        
        // Formatos de impresión de resultados
        textosES.put("FORMATO_RESULTADO", "%-25s %20s\n"); // Para el estatus 3ra edad
        textosES.put("FORMATO_RESULTADO_MONTO", "%-25s L. %17.2f\n");
        textosES.put("FORMATO_RESULTADO_MONTO_PORCENTAJE", "%-25s L. %17.2f (%5.1f%%)\n");
        textosES.put("FORMATO_RESULTADO_MONTO_FINAL", "%-25s L. %17.2f\n");
        
        // Mensajes de control y error
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("MSG_VENTA_INVALIDA", "\nERROR: La venta debe tener cantidades y precios mayores a cero. Terminando la simulación.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_OPCION_INVALIDA_TERCERA", "\nERROR: Opción no válida. Por favor, ingrese 1 para Sí o 2 para No.");
        textosES.put("ERR_ENTRADA_INVALIDA_NUM", "\nERROR: Entrada no válida. Por favor, ingrese un valor numérico.");
        textosES.put("ERR_VALOR_CERO", "\nERROR: La cantidad o el precio unitario deben ser mayores a cero.");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");

        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Simulate Sale");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");

        // Prompts de Operaciones
        textosEN.put("TITULO_OPERACIONES", "MODULE: SALE CALCULATION AND CUSTOM LIBRARY");
        textosEN.put("PROMPT_CANTIDAD", "Enter the total quantity of items: ");
        textosEN.put("PROMPT_PRECIO_UNITARIO", "Enter the unit price (L.): ");
        textosEN.put("PROMPT_TERCERA_EDAD", "Is the customer a senior citizen?");
        textosEN.put("OPCION_SI", "1. Yes");
        textosEN.put("OPCION_NO", "2. No");
        textosEN.put("PROMPT_OPCION_NUM", "Select an option (1 or 2): ");

        // Etiquetas de Resultados
        textosEN.put("TITULO_RESULTADOS", "--- SALE DETAILS ---");
        textosEN.put("RES_TERCERA_EDAD", "Senior Citizen Status:");
        textosEN.put("RES_SI", "YES");
        textosEN.put("RES_NO", "NO");
        textosEN.put("RES_SUBTOTAL", "Gross Total (Subtotal):");
        textosEN.put("RES_DESCUENTO", "Discount:");
        textosEN.put("RES_IMPUESTO", "Tax (VAT):");
        textosEN.put("RES_TOTAL_NETO", "NET TOTAL DUE:");

        // Formatos de impresión de resultados
        textosEN.put("FORMATO_RESULTADO", "%-25s %20s\n"); // For senior status
        textosEN.put("FORMATO_RESULTADO_MONTO", "%-25s L. %17.2f\n");
        textosEN.put("FORMATO_RESULTADO_MONTO_PORCENTAJE", "%-25s L. %17.2f (%5.1f%%)\n");
        textosEN.put("FORMATO_RESULTADO_MONTO_FINAL", "%-25s L. %17.2f\n");

        // Mensajes de control y error
        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("MSG_VENTA_INVALIDA", "\nERROR: Sale must have quantities and prices greater than zero. Ending simulation.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_OPCION_INVALIDA_TERCERA", "\nERROR: Invalid option. Please enter 1 for Yes or 2 for No.");
        textosEN.put("ERR_ENTRADA_INVALIDA_NUM", "\nERROR: Invalid input. Please enter a numerical value.");
        textosEN.put("ERR_VALOR_CERO", "\nERROR: Quantity or unit price must be greater than zero.");

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
