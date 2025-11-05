package Ejercicio029;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 029 | 2025-10-15
 */
public class Ejercicio029_Operaciones {

    /**
     * Calcula el promedio de un conjunto de números.
     * @param suma El total de los números.
     * @param contador La cantidad de números.
     * @return El promedio como un double, o 0.0 si no hay números.
     */
    public static double calcularPromedio(double suma, int contador) {
        if (contador == 0) {
            return 0.0;
        }
        return suma / contador;
    }
}