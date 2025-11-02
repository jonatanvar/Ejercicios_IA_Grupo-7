/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 031 | 2025-10-12               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio031;

public class Operaciones {
    public static String calcularProductoImpares() {
        long producto = 1;
        StringBuilder pasos = new StringBuilder();
        int[] impares = {1, 3, 5, 7, 9, 11, 13, 15};

        for (int i = 0; i < impares.length; i++) {
            producto *= impares[i];
            pasos.append(impares[i]);
            if (i < impares.length - 1) {
                pasos.append(" × ");
            }
            if (i == impares.length - 1) {
                pasos.append(" = ").append(producto).append(" → producto final = ").append(String.format("%,d", producto));
            } else {
                pasos.append(impares[i + 1]).append(" = ").append(producto).append("\n");
            }
        }
        long suma = producto; // Suma es el mismo valor del producto final en este caso
        return pasos.toString() + "\nSuma del resultado: " + String.format("%,d", suma);
    }
}