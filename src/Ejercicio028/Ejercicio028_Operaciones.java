package Ejercicio028;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 028 | 2025-10-10
 */

public class Ejercicio028_Operaciones {

    /** Cifra un número de 4 dígitos */
    public static String cifrar(int numero) {
        int[] digitos = obtenerDigitos(numero);
        // Paso 1: (d + 7) % 10
        for (int i = 0; i < 4; i++) {
            digitos[i] = (digitos[i] + 7) % 10;
        }
        // Paso 2: Intercambiar 1↔3 y 2↔4
        swap(digitos, 0, 2);
        swap(digitos, 1, 3);
        return arrayToString(digitos);
    }

    /** Descifra un número cifrado */
    public static String descifrar(int numero) {
        int[] digitos = obtenerDigitos(numero);
        // Paso 1: Intercambiar 1↔3 y 2↔4 (inverso)
        swap(digitos, 0, 2);
        swap(digitos, 1, 3);
        // Paso 2: Inverso de (d + 7) % 10 → (d + 3) % 10
        for (int i = 0; i < 4; i++) {
            digitos[i] = (digitos[i] + 3) % 10;
        }
        return arrayToString(digitos);
    }

    private static int[] obtenerDigitos(int numero) {
        return new int[]{
                (numero / 1000) % 10,
                (numero / 100) % 10,
                (numero / 10) % 10,
                numero % 10
        };
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static String arrayToString(int[] arr) {
        return String.format("%d%d%d%d", arr[0], arr[1], arr[2], arr[3]);
    }
}