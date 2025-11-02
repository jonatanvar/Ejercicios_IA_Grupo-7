/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 041 | 2025-10-13               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio041;

public class Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_SUP = '╔';
    private static final char BORDE_INF = '╚';
    private static final char BORDE_SEP = '╠';
    private static final char BORDE_IZQ = '║';
    private static final char BORDE_DER = '║';
    private static final char LINEA_H = '═';
    private static final char SEP_VERT = '│';
    private static final char CRUZ = '╣';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 041 | 2025-10-13", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarBienvenida(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("BIENVENIDA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarAyudaNumeros(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("AYUDA_NUMEROS", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarTabla(int[][] tabla, int n, String idioma) {
        int[] totales = Operaciones.calcularTotales(tabla);
        int[] promedios = Operaciones.calcularPromedios(tabla);

        System.out.println("\n" + BORDE_SUP + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "╗");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("TITULO_TABLA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_SEP + String.valueOf(LINEA_H).repeat(ANCHO - 2) + CRUZ);
        System.out.printf(BORDE_IZQ + " %-2s " + SEP_VERT + " %-4s " + SEP_VERT + " %-6s " + SEP_VERT + " %-7s " + SEP_VERT + " %-6s " + BORDE_DER + "%n", "#", "N", "N²", "N³", "2N-1");

        for (int i = 0; i < n; i++) {
            System.out.printf(BORDE_IZQ + " %-2d " + SEP_VERT + " %-4d " + SEP_VERT + " %-6d " + SEP_VERT + " %-7d " + SEP_VERT + " %-6d " + BORDE_DER + "%n",
                    tabla[i][0], tabla[i][1], tabla[i][2], tabla[i][3], tabla[i][4]);
        }
        System.out.println(BORDE_SEP + String.valueOf(LINEA_H).repeat(ANCHO - 2) + CRUZ);
        System.out.printf(BORDE_IZQ + " %-6s " + SEP_VERT + " %-4d " + SEP_VERT + " %-6d " + SEP_VERT + " %-7d " + SEP_VERT + " %-6d " + BORDE_DER + "%n",
                "Totales", totales[0], totales[1], totales[2], totales[3]);
        System.out.println(BORDE_SEP + String.valueOf(LINEA_H).repeat(ANCHO - 2) + CRUZ);
        System.out.printf(BORDE_IZQ + " %-6s " + SEP_VERT + " %-4d " + SEP_VERT + " %-6d " + SEP_VERT + " %-7d " + SEP_VERT + " %-6d " + BORDE_DER + "%n",
                "Promedios", promedios[0], promedios[1], promedios[2], promedios[3]);
        System.out.println(BORDE_INF + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "╝");
    }

    public static void mostrarErrorLimites(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_LIMITES", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_ENTRADA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "BIENVENIDA": return "¡Bienvenido a la tabla de cálculos!";
                case "INGRESE_NUMERO": return "Ingrese un número (1-15): ";
                case "AYUDA_NUMEROS": return "Instrucción: Ingrese un número entre 1 y 15 (e.g., 5, 10, 15)";
                case "TITULO_TABLA": return "TABLA DE CÁLCULOS";
                case "ERROR_LIMITES": return "ERROR: El número debe estar entre 1 y 15";
                case "ERROR_ENTRADA": return "ERROR: Ingrese un número entero válido";
                default: return "";
            }
        } else {
            switch (clave) {
                case "BIENVENIDA": return "Welcome to the calculation table!";
                case "INGRESE_NUMERO": return "Enter a number (1-15): ";
                case "AYUDA_NUMEROS": return "Instruction: Enter a number between 1 and 15 (e.g., 5, 10, 15)";
                case "TITULO_TABLA": return "CALCULATION TABLE";
                case "ERROR_LIMITES": return "ERROR: Number must be between 1 and 15";
                case "ERROR_ENTRADA": return "ERROR: Enter a valid integer";
                default: return "";
            }
        }
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}