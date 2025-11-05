package Ejercicio038_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 038 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para dibujar el rombo de asteriscos.
 */
public class operaciones {

    // Definimos el tamaño máximo del lado del rombo (la fila central es de este tamaño)
    private static final int LADO_MAXIMO = 5;
    // El número total de filas será (LADO_MAXIMO * 2) - 1, es decir, (5 * 2) - 1 = 9 filas.
    private static final char ASTERISCO = '*';
    private static final char ESPACIO = ' ';

    /**
     * Imprime un carácter específico un número dado de veces.
     * @param caracter El carácter a imprimir.
     * @param veces Las veces que se imprime.
     */
    public static void imprimirCaracter(char caracter, int veces) {
        for (int i = 0; i < veces; i++) {
            System.out.print(caracter);
        }
    }

    /**
     * Dibuja la figura completa del rombo.
     */
    public static void dibujarRombo() {

        // --- PARTE SUPERIOR DEL ROMBO (incluye la fila central) ---
        // 'i' representa el número de fila, desde 1 hasta LADO_MAXIMO (5)
        for (int i = 1; i <= LADO_MAXIMO; i++) {

            // 1. Imprimir Espacios Iniciales (alineación central)
            // En la fila 1 (i=1), se imprimen 4 espacios (5-1)
            // En la fila 5 (i=5), se imprimen 0 espacios (5-5)
            imprimirCaracter(ESPACIO, LADO_MAXIMO - i);

            // 2. Imprimir Asteriscos
            // El número de asteriscos es (2*i - 1).
            // Fila 1: 1 asterisco (2*1 - 1)
            // Fila 5: 9 asteriscos (2*5 - 1)
            imprimirCaracter(ASTERISCO, 2 * i - 1);

            System.out.println(); // Salto de línea
        }

        // --- PARTE INFERIOR DEL ROMBO (filas 6 a 9) ---
        // 'i' representa el número de fila, desde LADO_MAXIMO - 1 (4) hasta 1
        for (int i = LADO_MAXIMO - 1; i >= 1; i--) {

            // 1. Imprimir Espacios Iniciales (alineación central)
            // Fila 6 (i=4): 1 espacio (5-4)
            // Fila 9 (i=1): 4 espacios (5-1)
            imprimirCaracter(ESPACIO, LADO_MAXIMO - i);

            // 2. Imprimir Asteriscos
            // Fila 6 (i=4): 7 asteriscos (2*4 - 1)
            // Fila 9 (i=1): 1 asterisco (2*1 - 1)
            imprimirCaracter(ASTERISCO, 2 * i - 1);

            System.out.println(); // Salto de línea
        }
    }
}