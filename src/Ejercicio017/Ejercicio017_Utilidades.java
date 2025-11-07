// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Metadatos: Dany Noguera | dany.noguera@unah.hn | 017 | 2025-11-04          ║
// ║ Resumen: Utilidades gráficas (bordes y estética).                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 017 | 2025-11-04

package Ejercicio017;

public class Ejercicio017_Utilidades {

    private static final char L = '═';

    /** Encabezado con título */
    public static void mostrarEncabezado(String titulo, int ancho) {
        System.out.println("╔" + String.valueOf(L).repeat(ancho - 2) + "╗");
        centrarTexto(titulo, ancho);
        System.out.println("╚" + String.valueOf(L).repeat(ancho - 2) + "╝\n");
    }

    /** Separador con texto centrado */
    public static void mostrarSeparador(String titulo, int ancho) {
        System.out.println("\n╠" + String.valueOf(L).repeat(ancho - 2) + "╣");
        centrarTexto(titulo, ancho);
        System.out.println("╠" + String.valueOf(L).repeat(ancho - 2) + "╣\n");
    }

    /** Centrar texto con bordes */
    public static void centrarTexto(String texto, int ancho) {
        int espacios = (ancho - 2 - texto.length()) / 2;
        System.out.println("║" + " ".repeat(espacios) + texto + " ".repeat(espacios) + "║");
    }

    /** Pie final */
    public static void mostrarPie(String mensaje) {
        mostrarSeparador(mensaje, 78);
        System.out.println("Gracias por usar el programa.\n");
    }
}
