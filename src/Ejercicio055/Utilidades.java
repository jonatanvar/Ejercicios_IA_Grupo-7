/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 055 | 2025-10-27
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que simula un juego de dados (apuesta sobre la suma de dos dados) con crédito inicial de L. 1000.00, funciones obligatorias (lanzar, sumar, dibujar, ganancia), control de crédito y opción de retiro tras 5 turnos.
 */

package Ejercicio_055;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo Utilidades: Contiene herramientas y funciones auxiliares,
 * principalmente la gestión y almacenamiento de los textos en múltiples idiomas
 * para la aplicación del Ejercicio 55 (Juego de Dados).
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
        textosES.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Jugar: El Dado está en el Aire");
        textosES.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Finalizar el Programa");
        textosES.put("MENU_CONTROL_PROMPT", "Seleccione una opción (1 o 2): ");
        
        textosES.put("MENU_RETIRO_TITULO", "¿Desea continuar jugando o retirarse?");
        textosES.put("MENU_RETIRO_OPCION_CONTINUAR", "1. Seguir jugando");
        textosES.put("MENU_RETIRO_OPCION_RETIRAR", "2. Retirarse con mi crédito actual");
        textosES.put("MENU_RETIRO_PROMPT", "Seleccione una opción (1 o 2): ");
        
        // Mensajes del juego
        textosES.put("TITULO_OPERACIONES", "JUEGO: EL DADO ESTÁ EN EL AIRE");
        textosES.put("MSG_BIENVENIDA", "¡Bienvenido! Su crédito inicial es de L. %.2f\n");
        textosES.put("MSG_REGLAS", "REGLAS: Ganas si la suma de los dos dados coincide con tu predicción (2 a 12). Si ganas, recibes tu apuesta más la mitad de la misma.");
        textosES.put("MSG_RONDA", "\n--- RONDA");
        textosES.put("MSG_CREDITO_ACTUAL", "Crédito actual: L. %.2f\n");
        textosES.put("PROMPT_APUESTA", "Ingrese su apuesta (L. 1.00 hasta L. %.2f): ");
        textosES.put("PROMPT_PREDICCION", "Ingrese la suma que predice (2 a 12): ");
        textosES.put("MSG_TIRADA_RESULTADO", "\n¡Los dados están en el aire! Resultado de la tirada:");
        textosES.put("MSG_DADOS_VALOR", "Valor de Dados: Dado 1 = %d, Dado 2 = %d (Suma total = %d)\n");
        textosES.put("MSG_GANADOR", "¡GANASTE! Predijiste %d y la suma fue %d. Tu ganancia es de L. %.2f\n");
        textosES.put("MSG_PERDEDOR", "PERDISTE. Predijiste %d y la suma fue %d. Has perdido tu apuesta.\n");
        textosES.put("MSG_FIN_JUEGO", "FIN DEL JUEGO");
        textosES.put("MSG_CREDITO_FINAL", "Crédito Final: L. %.2f\n");
        textosES.put("MSG_SIN_DINERO", "\nTe has quedado sin crédito (L. 0.00). Fin del juego.");
        textosES.put("MSG_RETIRO_VOLUNTARIO", "Te retiras del juego con un crédito de L. %.2f");
        
        // Errores
        textosES.put("MSG_FINALIZAR", "\n¡Programa finalizado! Gracias por usar el programa.");
        textosES.put("MSG_CONTINUAR_ASUMIDO", ". Se asume que desea continuar.");
        textosES.put("MSG_APUESTA_CANCELADA", "Apuesta cancelada. Regresando al menú.");
        textosES.put("MSG_PREDICCION_CANCELADA", "Predicción cancelada. Regresando al menú.");
        textosES.put("ERR_OPCION_INVALIDA", "\nERROR: Opción no válida. Por favor, ingrese 1 o 2.");
        textosES.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: Entrada no válida. Por favor, ingrese un número entero.");
        textosES.put("ERR_ENTRADA_INVALIDA_DOUBLE", "\nERROR: Entrada no válida. Por favor, ingrese un número real.");
        textosES.put("ERR_APUESTA_MAYOR_CREDITO", "\nERROR: La apuesta no puede ser mayor a su crédito actual (L. %.2f)");
        textosES.put("ERR_APUESTA_MINIMA", "\nERROR: La apuesta mínima es L. 1.00.");
        textosES.put("ERR_PREDICCION_RANGO", "\nERROR: La suma de dos dados debe estar entre 2 y 12.");
        
        TEXTOS.put("ES", textosES);

        // --- TEXTOS EN INGLÉS (EN) ---
        Map<String, String> textosEN = new HashMap<>();
        textosEN.put("MENU_IDIOMA_TITULO", "--- SELECCIÓN DE IDIOMA / LANGUAGE SELECTION ---");
        textosEN.put("MENU_IDIOMA_OPCION_ES", "1. Spanish (Español)");
        textosEN.put("MENU_IDIOMA_OPCION_EN", "2. English");
        textosEN.put("MENU_IDIOMA_PROMPT", "Select language (1 or 2): ");
        
        textosEN.put("MENU_CONTROL_TITULO", "--- CONTROL MENU ---");
        textosEN.put("MENU_CONTROL_OPCION_EJECUTAR", "1. Play: The Die is in the Air");
        textosEN.put("MENU_CONTROL_OPCION_FINALIZAR", "2. Exit Program");
        textosEN.put("MENU_CONTROL_PROMPT", "Select an option (1 or 2): ");
        
        textosEN.put("MENU_RETIRO_TITULO", "Do you want to keep playing or withdraw?");
        textosEN.put("MENU_RETIRO_OPCION_CONTINUAR", "1. Keep playing");
        textosEN.put("MENU_RETIRO_OPCION_RETIRAR", "2. Withdraw with my current credit");
        textosEN.put("MENU_RETIRO_PROMPT", "Select an option (1 or 2): ");

        // Mensajes del juego
        textosEN.put("TITULO_OPERACIONES", "GAME: THE DIE IS IN THE AIR");
        textosEN.put("MSG_BIENVENIDA", "Welcome! Your starting credit is L. %.2f\n");
        textosEN.put("MSG_REGLAS", "RULES: You win if the sum of the two dice matches your prediction (2 to 12). If you win, you receive your bet plus half of that value.");
        textosEN.put("MSG_RONDA", "\n--- ROUND");
        textosEN.put("MSG_CREDITO_ACTUAL", "Current Credit: L. %.2f\n");
        textosEN.put("PROMPT_APUESTA", "Enter your bet (L. 1.00 up to L. %.2f): ");
        textosEN.put("PROMPT_PREDICCION", "Enter the sum you predict (2 to 12): ");
        textosEN.put("MSG_TIRADA_RESULTADO", "\nThe dice are in the air! Roll result:");
        textosEN.put("MSG_DADOS_VALOR", "Dice Value: Die 1 = %d, Die 2 = %d (Total sum = %d)\n");
        textosEN.put("MSG_GANADOR", "YOU WON! You predicted %d and the sum was %d. Your winnings are L. %.2f\n");
        textosEN.put("MSG_PERDEDOR", "YOU LOST. You predicted %d and the sum was %d. You lost your bet.\n");
        textosEN.put("MSG_FIN_JUEGO", "END OF GAME");
        textosEN.put("MSG_CREDITO_FINAL", "Final Credit: L. %.2f\n");
        textosEN.put("MSG_SIN_DINERO", "\nYou ran out of credit (L. 0.00). Game over.");
        textosEN.put("MSG_RETIRO_VOLUNTARIO", "You voluntarily withdraw from the game with a credit of L. %.2f");

        // Errores
        textosEN.put("MSG_FINALIZAR", "\nProgram terminated! Thank you for using the program.");
        textosEN.put("MSG_CONTINUAR_ASUMIDO", ". Continuing is assumed.");
        textosEN.put("MSG_APUESTA_CANCELADA", "Bet canceled. Returning to menu.");
        textosEN.put("MSG_PREDICCION_CANCELADA", "Prediction canceled. Returning to menu.");
        textosEN.put("ERR_OPCION_INVALIDA", "\nERROR: Invalid option. Please enter 1 or 2.");
        textosEN.put("ERR_ENTRADA_INVALIDA_INT", "\nERROR: Invalid input. Please enter an integer number.");
        textosEN.put("ERR_ENTRADA_INVALIDA_DOUBLE", "\nERROR: Invalid input. Please enter a real number.");
        textosEN.put("ERR_APUESTA_MAYOR_CREDITO", "\nERROR: Bet cannot be greater than your current credit (L. %.2f)");
        textosEN.put("ERR_APUESTA_MINIMA", "\nERROR: Minimum bet is L. 1.00.");
        textosEN.put("ERR_PREDICCION_RANGO", "\nERROR: The sum of two dice must be between 2 and 12.");

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
