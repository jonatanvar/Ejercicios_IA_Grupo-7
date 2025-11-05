package Ejercicio023_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 023 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para dibujar el cuadrado hueco.
 */
public class operaciones {

    /**
     * Dibuja un cuadrado hueco de asteriscos en la consola.
     * @param lado El tamaño del lado del cuadrado (entre 1 y 20).
     */
    public static void dibujarCuadradoHueco(int lado) {

        // Validar el rango de entrada
        if (lado < 1 || lado > 20) {
            System.out.println("Error: El tamaño del lado debe estar entre 1 y 20.");
            return;
        }

        // Bucle exterior para filas
        for (int fila = 1; fila <= lado; fila++) {

            // Bucle interior para columnas
            for (int columna = 1; columna <= lado; columna++) {

                // 1. Caso de Bordes (Filas superior e inferior)
                // 2. Caso de Bordes (Columnas izquierda y derecha)
                if (fila == 1 || fila == lado || columna == 1 || columna == lado) {
                    System.out.print("* ");
                }
                // Caso de Interior (Espacio en blanco)
                else {
                    // Se usa "  " (dos espacios) para alinear con el "* " de los bordes.
                    System.out.print("  ");
                }
            }
            // Saltar a la siguiente línea al finalizar la fila
            System.out.println();
        }
    }
}