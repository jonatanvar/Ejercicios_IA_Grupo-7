package Ejercicio024;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 024 | 2025-10-15
 */
public class Ejercicio024_Operaciones {

    public static boolean esTriangulo(double a, double b, double c) {
        boolean condicion1 = (a + b) > c;
        boolean condicion2 = (a + c) > b;
        boolean condicion3 = (b + c) > a;

        return condicion1 && condicion2 && condicion3;
    }
}