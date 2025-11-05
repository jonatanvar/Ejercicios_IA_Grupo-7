package Ejercicio028_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 028 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para cifrar y descifrar enteros de cuatro dígitos.
 */
public class operaciones {

    /**
     * Convierte un entero de 4 dígitos en un array de 4 enteros (los dígitos).
     * @param numero El número de 4 dígitos (ej: 1234).
     * @return Array de dígitos [d1, d2, d3, d4].
     */
    private static int[] toDigitos(int numero) {
        int[] digitos = new int[4];
        // La forma más simple de obtener los dígitos en orden:
        String str = String.format("%04d", numero); // Asegura 4 dígitos con ceros iniciales
        for (int i = 0; i < 4; i++) {
            digitos[i] = Character.getNumericValue(str.charAt(i));
        }
        return digitos;
    }

    /**
     * Convierte un array de 4 dígitos en un entero de 4 dígitos.
     * @param digitos Array de 4 dígitos.
     * @return El entero combinado.
     */
    private static int toEntero(int[] digitos) {
        return digitos[0] * 1000 + digitos[1] * 100 + digitos[2] * 10 + digitos[3];
    }

    /**
     * Realiza el intercambio de dígitos: 1<->3 y 2<->4.
     * @param digitos Array de 4 dígitos.
     */
    private static void intercambiarDigitos(int[] digitos) {
        // Intercambio 1 (posición 0) con 3 (posición 2)
        int temp1 = digitos[0];
        digitos[0] = digitos[2];
        digitos[2] = temp1;

        // Intercambio 2 (posición 1) con 4 (posición 3)
        int temp2 = digitos[1];
        digitos[1] = digitos[3];
        digitos[3] = temp2;
    }

    /**
     * Cifra un entero de cuatro dígitos.
     * Cifrado: (dígito + 7) mod 10, luego intercambiar 1<->3 y 2<->4.
     * @param numero El entero original de 4 dígitos.
     * @return El entero cifrado.
     */
    public static int cifrar(int numero) {
        int[] digitos = toDigitos(numero);

        // Paso 1: Reemplazar cada dígito con (dígito + 7) mod 10
        for (int i = 0; i < 4; i++) {
            digitos[i] = (digitos[i] + 7) % 10;
        }

        // Paso 2: Intercambiar
        intercambiarDigitos(digitos);

        return toEntero(digitos);
    }

    /**
     * Descifra un entero de cuatro dígitos cifrado.
     * Descifrado: 1. Intercambiar 1<->3 y 2<->4.
     * 2. Invertir la suma: (dígito + 3) mod 10 (es el inverso de +7 mod 10).
     * @param cifrado El entero cifrado de 4 dígitos.
     * @return El entero original (descifrado).
     */
    public static int descifrar(int cifrado) {
        int[] digitos = toDigitos(cifrado);

        // Paso 1: Deshacer el intercambio
        intercambiarDigitos(digitos);

        // Paso 2: Invertir la operación modular (+7 mod 10)
        // La operación inversa de (d + 7) mod 10 es (d + 3) mod 10, ya que 7 + 3 = 10 ≡ 0 (mod 10)
        for (int i = 0; i < 4; i++) {
            digitos[i] = (digitos[i] + 3) % 10;
        }

        return toEntero(digitos);
    }
}