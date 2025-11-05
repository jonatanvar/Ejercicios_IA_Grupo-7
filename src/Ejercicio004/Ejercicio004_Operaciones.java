package Ejercicio004;

/*
 * Cristina Cruz | Lis | cristinacruz@unah.hn | 004 | 2025-10-10
 */
public class Ejercicio004_Operaciones {
    public static double calcularSuma(double num1, double num2) {
        return num1 + num2;
    }

    public static double calcularProducto(double num1, double num2) {
        return num1 * num2;
    }

    public static double calcularDiferencia(double num1, double num2) {
        return num1 - num2;
    }

    public static double calcularCociente(double num1, double num2) {
        if (num2 == 0) {
            return Double.NaN; // Indicador de división por cero
        }
        return num1 / num2;
    }
}