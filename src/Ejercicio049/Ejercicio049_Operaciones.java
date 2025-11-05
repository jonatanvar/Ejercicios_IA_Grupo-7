package Ejercicio049;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 049 | 2025-11-04
 */

/**
 * Clase con funciones puras para cifrado y descifrado.
 * No contiene entrada/salida ni estado.
 */
public class Ejercicio049_Operaciones {

    /**
     * Cifra un número de 4 dígitos.
     * @param numero número original (0000-9999)
     * @return número cifrado como String de 4 dígitos
     */
    public static String cifrar(int numero) {
        int[] d = extraerDigitos(numero);
        // Paso 1: (d + 7) % 10
        for (int i = 0; i < 4; i++) {
            d[i] = (d[i] + 7) % 10;
        }
        // Paso 2: intercambiar 0↔2 y 1↔3
        intercambiar(d, 0, 2);
        intercambiar(d, 1, 3);
        return formatear(d);
    }

    /**
     * Descifra un número cifrado.
     * @param numero número cifrado (0000-9999)
     * @return número original como String de 4 dígitos
     */
    public static String descifrar(int numero) {
        int[] d = extraerDigitos(numero);
        // Paso 1: intercambiar (inverso)
        intercambiar(d, 0, 2);
        intercambiar(d, 1, 3);
        // Paso 2: (d + 3) % 10
        for (int i = 0; i < 4; i++) {
            d[i] = (d[i] + 3) % 10;
        }
        return formatear(d);
    }

    private static int[] extraerDigitos(int n) {
        return new int[]{
                (n / 1000) % 10,
                (n / 100)  % 10,
                (n / 10)   % 10,
                n          % 10
        };
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static String formatear(int[] d) {
        return String.format("%d%d%d%d", d[0], d[1], d[2], d[3]);
    }
}