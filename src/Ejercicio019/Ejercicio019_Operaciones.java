package Ejercicio019;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 019 | 2025-10-15
 */
public class Ejercicio019_Operaciones {

    public static double calcularNuevoSaldo(double saldoInicial, double cargos, double creditos) {
        return saldoInicial + cargos - creditos;
    }

    public static boolean excedioLimite(double nuevoSaldo, double limiteCredito) {
        return nuevoSaldo > limiteCredito;
    }
}