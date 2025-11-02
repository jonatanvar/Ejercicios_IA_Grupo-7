/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 026 | 2025-10-12               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio026;

public class Operaciones {
    public static void generarTabla() {
        int n = 1;
        while (n <= 5) {
            System.out.println(n + "\t" + 10 * n + "\t" + 100 * n + "\t" + 1000 * n);
            n++;
        }
    }
}