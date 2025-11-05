package Ejercicio077;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 077 | 2025-10-16
 */
public class Ejercicio077_Funciones {

    /**
     * Calcula la potencia de un número base elevado a un exponente entero.
     * Implementa las reglas: base^0 = 1 y manejo de exponentes negativos.
     * @param base El número base (double).
     * @param exponente El exponente (int).
     * @return El resultado de la potenciación (double).
     */
    public static double calcularPotencia(double base, int exponente) {

        // C. Todo número elevado a la cero es igual a 1.
        if (exponente == 0) {
            return 1.0;
        }

        // A. Calcular la potencia para exponentes positivos.
        double resultado = 1.0;
        int exponenteAbsoluto = Math.abs(exponente);

        for (int i = 0; i < exponenteAbsoluto; i++) {
            resultado *= base;
        }

        // B. Manejo de exponentes negativos.
        if (exponente < 0) {
            // base^-n = 1 / base^n
            return 1.0 / resultado;
        }

        return resultado;
    }
}