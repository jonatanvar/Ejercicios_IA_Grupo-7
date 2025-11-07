// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Metadatos: Dany Noguera | dany.noguera@unah.hn | 007 | 2025-11-04          ║
// ║ Resumen: Utilidades gráficas (bordes, centrado, separadores).              ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 007 | 2025-11-04

package Ejercicio007;

public class Ejercicio007_Utilidades {
    private static final char L = '═';
    private static final int ANCHO = 78;

    public static void mostrarEncabezado(String titulo, int ancho) {
        System.out.println("╔" + String.valueOf(L).repeat(ancho - 2) + "╗");
        centrarTexto(titulo, ancho);
        System.out.println("╚" + String.valueOf(L).repeat(ancho - 2) + "╝\n");
    }

    public static void mostrarSeparador(String titulo, int ancho) {
        System.out.println("╠" + String.valueOf(L).repeat(ancho - 2) + "╣");
        centrarTexto(titulo, ancho);
        System.out.println("╠" + String.valueOf(L).repeat(ancho - 2) + "╣\n");
    }

    public static void centrarTexto(String texto, int ancho) {
        int espacios = (ancho - 2 - texto.length()) / 2;
        String izq = " ".repeat(Math.max(0, espacios));
        String der = " ".repeat(Math.max(0, ancho - 2 - texto.length() - espacios));
        System.out.println("║" + izq + texto + der + "║");
    }

    public static void mostrarVersionCorta(String texto, int ancho) {
        System.out.println("\n╠" + String.valueOf(L).repeat(ancho - 2) + "╣");
        centrarTexto(texto, ancho);
        System.out.println("╚" + String.valueOf(L).repeat(ancho - 2) + "╝");
    }

    public static void mostrarPie(String msg) {
        System.out.println("\n╔" + String.valueOf(L).repeat(ANCHO - 2) + "╗");
        centrarTexto(msg, ANCHO);
        centrarTexto("¡Ejercicio 007 completado!", ANCHO);
        System.out.println("╚" + String.valueOf(L).repeat(ANCHO - 2) + "╝");
    }
}