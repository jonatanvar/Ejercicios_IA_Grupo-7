/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 074 | 2025-10-18               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio074;

public class Operaciones {
    public static int elevarCd(int numero) {
        return numero * numero;
    }

    public static void elevarCd(Integer numero) {
        numero = numero * numero; // No modifica el original
    }

    public static int elevarCb(int numero) {
        return numero * numero * numero;
    }

    public static void elevarCb(Integer numero) {
        numero = numero * numero * numero; // No modifica el original
    }
}