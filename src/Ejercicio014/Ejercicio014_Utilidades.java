package Ejercicio014;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 014 | 2025-10-15
 * Propósito: Contiene métodos para el formato, el sello y la impresión del tablero.
 */
public class Ejercicio014_Utilidades {

    private static final int ANCHO_SELLO = 70;

    /**
     * Muestra el sello personalizado.
     */
    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 014 | 2025-10-15";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    /**
     * Muestra el patrón del tablero de ajedrez usando OCHO instrucciones de salida.
     */
    public static void dibujarTableroOchoLineas() {
        String casilla = Ejercicio014_Operaciones.CASILLA;
        String fila = casilla.repeat(4);
        System.out.println("\n--- Patrón del Tablero (8 Instrucciones) ---");

        // Se usan 8 System.out.println/print para satisfacer el requisito.
        System.out.println(fila + fila); // Fila 1
        System.out.println(" " + fila + fila); // Fila 2
        System.out.println(fila + fila); // Fila 3
        System.out.println(" " + fila + fila); // Fila 4
        System.out.println(fila + fila); // Fila 5
        System.out.println(" " + fila + fila); // Fila 6
        System.out.println(fila + fila); // Fila 7
        System.out.println(" " + fila + fila); // Fila 8

        System.out.println("--------------------------------------------");
    }

    /**
     * Muestra el patrón del tablero de ajedrez usando el MENOR número de instrucciones (UNA).
     */
    public static void dibujarTableroMinimo() {
        String c = Ejercicio014_Operaciones.CASILLA;

        // CORRECCIÓN: Definición clara de las variables en líneas separadas.
        String filaPar = c.repeat(8);     // Fila que comienza con *
        String filaImpar = " " + filaPar; // Fila que comienza con espacio

        System.out.println("\n--- Patrón del Tablero (Mínimo de Instrucciones) ---");

        // Se usa UNA instrucción de salida (System.out.printf) para imprimir todo el patrón.
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n",
                filaPar, filaImpar, filaPar, filaImpar,
                filaPar, filaImpar, filaPar, filaImpar);

        System.out.println("-----------------------------------------------------");
    }
}