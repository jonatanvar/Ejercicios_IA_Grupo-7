package Ejercicio058_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 058 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la función para determinar si un número es múltiplo de otro.
 */
public class operaciones {

    /**
     * Determina si el segundo entero (num2) es múltiplo del primero (num1).
     * Esto es verdadero si el residuo de la división (num2 % num1) es cero.
     * * @param num1 El primer entero (el divisor potencial).
     * @param num2 El segundo entero (el múltiplo potencial).
     * @return true si num2 es múltiplo de num1, false en caso contrario.
     */
    public static boolean multiple(int num1, int num2) {
        // Debemos evitar la división por cero.
        if (num1 == 0) {
            // Si el divisor es 0, no se considera que num2 sea su múltiplo,
            // a menos que num2 también sea 0, pero la definición estándar es evitar el caso.
            // Para simplicidad en este ejercicio, devolvemos false si el divisor es 0.
            return false;
        }

        // La clave de la lógica: si el residuo es 0, num2 es múltiplo de num1.
        return num2 % num1 == 0;
    }
}