package Ejercicio033_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 033 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para dibujar los cuatro patrones de asteriscos.
 */
public class operaciones {

    private static final int TAMANO_BASE = 10;
    private static final char ASTERISCO = '*';
    private static final char ESPACIO = ' ';

    /**
     * Imprime un carácter específico un número dado de veces.
     * Usado para cumplir el requisito de 'cout << '*';' (System.out.print('*'))
     * @param caracter El carácter a imprimir.
     * @param veces Las veces que se imprime.
     */
    private static void imprimirCaracter(char caracter, int veces) {
        for (int i = 0; i < veces; i++) {
            System.out.print(caracter);
        }
    }

    /**
     * Dibuja el patrón (a): Triángulo creciente (alineado a la izquierda).
     * Ejemplo (Tamaño 5):
     * *
     * **
     * ***
     * ****
     * *****
     */
    public static void dibujarPatronA() {
        System.out.println("Patrón (a): Triángulo Creciente");
        for (int i = 1; i <= TAMANO_BASE; i++) { // Bucle de filas
            // Dibuja i asteriscos por fila
            imprimirCaracter(ASTERISCO, i);
            System.out.println(); // Salto de línea
        }
    }

    /**
     * Dibuja el patrón (b): Triángulo decreciente (alineado a la izquierda).
     * Ejemplo (Tamaño 5):
     * *****
     * ****
     * ***
     * **
     * *
     */
    public static void dibujarPatronB() {
        System.out.println("\nPatrón (b): Triángulo Decreciente");
        for (int i = TAMANO_BASE; i >= 1; i--) { // Bucle de filas (decreciente)
            // Dibuja i asteriscos por fila
            imprimirCaracter(ASTERISCO, i);
            System.out.println(); // Salto de línea
        }
    }

    /**
     * Dibuja el patrón (c): Triángulo decreciente (alineado a la derecha).
     * Requiere espacios iniciales.
     * Ejemplo (Tamaño 5):
     * ***** (0 espacios)
     * **** (1 espacio)
     * *** (2 espacios)
     * ** (3 espacios)
     * * (4 espacios)
     */
    public static void dibujarPatronC() {
        System.out.println("\nPatrón (c): Triángulo Decreciente (Derecha)");
        for (int i = TAMANO_BASE; i >= 1; i--) { // Bucle de filas (número de asteriscos)
            // Dibuja (TAMANO_BASE - i) espacios iniciales
            imprimirCaracter(ESPACIO, TAMANO_BASE - i);
            // Dibuja i asteriscos
            imprimirCaracter(ASTERISCO, i);
            System.out.println(); // Salto de línea
        }
    }

    /**
     * Dibuja el patrón (d): Triángulo creciente (alineado a la derecha).
     * Requiere espacios iniciales.
     * Ejemplo (Tamaño 5):
     * * (4 espacios)
     * ** (3 espacios)
     * *** (2 espacios)
     * **** (1 espacio)
     * ***** (0 espacios)
     */
    public static void dibujarPatronD() {
        System.out.println("\nPatrón (d): Triángulo Creciente (Derecha)");
        for (int i = 1; i <= TAMANO_BASE; i++) { // Bucle de filas (número de asteriscos)
            // Dibuja (TAMANO_BASE - i) espacios iniciales
            imprimirCaracter(ESPACIO, TAMANO_BASE - i);
            // Dibuja i asteriscos
            imprimirCaracter(ASTERISCO, i);
            System.out.println(); // Salto de línea
        }
    }
}