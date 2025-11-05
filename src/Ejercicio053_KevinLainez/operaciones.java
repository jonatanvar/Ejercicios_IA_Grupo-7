package Ejercicio053_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 053 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica matemática para la conversión de temperaturas.
 */
public class operaciones {

    // Constantes para identificar las escalas
    public static final String CELSIUS = "C";
    public static final String FAHRENHEIT = "F";
    public static final String KELVIN = "K";

    /**
     * Función principal que convierte la temperatura de una escala a otra.
     * @param tempInicial La temperatura a convertir.
     * @param escalaInicial La escala de la temperatura inicial (C, F, o K).
     * @param escalaFinal La escala a la que se debe convertir (C, F, o K).
     * @return La temperatura en la escala final.
     */
    public static double convertirTemperatura(double tempInicial, String escalaInicial, String escalaFinal) {

        // Paso 1: Convertir la temperatura inicial a una BASE (usaremos Celsius)
        double tempBaseCelsius = aCelsius(tempInicial, escalaInicial);

        // Paso 2: Convertir la temperatura base Celsius a la escala final
        return deCelsius(tempBaseCelsius, escalaFinal);
    }

    /**
     * Convierte cualquier temperatura inicial a Celsius (la base de cálculo).
     */
    private static double aCelsius(double temp, String escala) {
        if (escala.equals(CELSIUS)) {
            return temp;
        } else if (escala.equals(FAHRENHEIT)) {
            // C = (F - 32) * 5/9
            return (temp - 32.0) * 5.0 / 9.0;
        } else if (escala.equals(KELVIN)) {
            // C = K - 273.15
            return temp - 273.15;
        }
        return Double.NaN; // Retorna Not a Number si la escala es inválida
    }

    /**
     * Convierte la temperatura base Celsius a la escala final deseada.
     */
    private static double deCelsius(double tempCelsius, String escala) {
        if (escala.equals(CELSIUS)) {
            return tempCelsius;
        } else if (escala.equals(FAHRENHEIT)) {
            // F = C * 9/5 + 32
            return tempCelsius * 9.0 / 5.0 + 32.0;
        } else if (escala.equals(KELVIN)) {
            // K = C + 273.15
            return tempCelsius + 273.15;
        }
        return Double.NaN; // Retorna Not a Number si la escala es inválida
    }
}