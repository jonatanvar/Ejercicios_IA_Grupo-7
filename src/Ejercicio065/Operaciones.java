/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                    │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 065                               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio065;

public class Operaciones {
    public static double calcularCargos(double horas) {
        if (horas <= 3) {
            return 2.00;
        } else if (horas > 24) {
            return 10.00;
        } else {
            double horasExtra = horas - 3;
            double cargoExtra = Math.ceil(horasExtra) * 0.50;
            double total = 2.00 + cargoExtra;
            return Math.min(total, 10.00);
        }
    }
}