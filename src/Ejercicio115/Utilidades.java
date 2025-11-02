package Ejercicio115;

public class Utilidades {
    private static final int ANCHO = 70;

    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrar("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 115 | 2025-10-27                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrar(String texto, int ancho) {
        int espacios = ancho - texto.length();
        int izq = espacios / 2, der = espacios - izq;
        return " ".repeat(izq) + texto + " ".repeat(der);
    }

    public static String obtenerOrdinal(int n) {
        return switch (n) {
            case 1 -> "primero";
            case 2 -> "segundo";
            case 3 -> "tercero";
            default -> n + "°";
        };
    }

    public static void mostrarError(String msg) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrar(msg, ANCHO - 2) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }
}