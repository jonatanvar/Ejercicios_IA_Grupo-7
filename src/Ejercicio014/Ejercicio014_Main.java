package Ejercicio014;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 014 | 2025-10-15
 * Propósito: Flujo principal del programa. Muestra un patrón de tablero de ajedrez
 * primero con 8 instrucciones de salida y luego con la menor cantidad posible.
 */
public class Ejercicio014_Main {

    public static void main(String[] args) {

        // 1. Mostrar Sello Personalizado
        Ejercicio014_Utilidades.mostrarSelloCorto();

        // 2. Mostrar el tablero usando OCHO instrucciones de salida
        Ejercicio014_Utilidades.dibujarTableroOchoLineas();

        // 3. Mostrar el tablero usando el MÍNIMO número de instrucciones (una)
        Ejercicio014_Utilidades.dibujarTableroMinimo();

        System.out.println("Programa finalizado.");
    }
}