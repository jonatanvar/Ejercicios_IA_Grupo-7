/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 016 | 2025-10-10               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio016;

public class Ejercicio016_Operaciones {
    public static void separarDigitos(int numero, int[] digitos) {
        numero = Math.abs(numero);
        for (int i = 4; i >= 0; i--) {
            digitos[i] = numero % 10;
            numero /= 10;
        }
    }
}