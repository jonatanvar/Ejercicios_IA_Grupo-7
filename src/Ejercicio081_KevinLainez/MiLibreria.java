package Ejercicio081_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | LIBRERIA | 2025-11-03             │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase MiLibreria: Librería propia de utilidades estéticas y de formato.
 * Contiene métodos estáticos para crear bordes, centrar texto, mostrar el sello y dibujar patrones.
 */
public class MiLibreria {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    // Getters para las constantes públicas (útiles para dibujar fuera de la clase)
    public static int getANCHO() { return ANCHO; }
    public static char getBORDE_IZQ() { return BORDE_IZQ; }
    public static char getBORDE_DER() { return BORDE_DER; }

    /**
     * Centra un texto dentro del ancho especificado (70 caracteres).
     */
    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    /**
     * Dibuja una línea horizontal para los bordes del cuadro.
     */
    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    /**
     * Muestra el cuadro de bienvenida general.
     */
    public static void mostrarSaludo(String titulo) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #81!"));
        System.out.println(centrarTexto(titulo));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    /**
     * Muestra el sello personalizado (versión corta).
     */
    public static void mostrarSelloCorto(String numEjercicio) {
        String sello = "Kevin Lainez | klainezs@unah.hn | " + numEjercicio + " | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Dibuja un patrón simple de líneas, centralizando el proceso.
     */
    public static void dibujarPatronDeLineas() {
        final int TAMANO = 8;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("** PATRÓN DE LÍNEAS USANDO LIBRERÍA **"));

        // Bucle de filas
        for (int i = 1; i <= TAMANO; i++) {

            // Lógica para centrar
            int largoLinea = 2 * i - 1;
            int espaciosCentrales = ANCHO - 2 - largoLinea;
            int paddingIzquierdo = espaciosCentrales / 2;
            int paddingDerecho = espaciosCentrales - paddingIzquierdo;

            System.out.print(BORDE_IZQ);

            // Imprime los espacios iniciales (Padding)
            for (int j = 0; j < paddingIzquierdo; j++) {
                System.out.print(' ');
            }

            // Imprime la línea de patrón
            for (int j = 0; j < largoLinea; j++) {
                System.out.print('=');
            }

            // Imprime los espacios finales (Padding)
            for (int j = 0; j < paddingDerecho; j++) {
                System.out.print(' ');
            }

            System.out.println(BORDE_DER);
        }

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}