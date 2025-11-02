/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 026 | 2025-10-12               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio026;

public class Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 026 | 2025-10-12", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarTablaValores(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("TITULO_TABLA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + centrarTexto("N\t10*N\t100*N\t1000*N", ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");

        int n = 1;
        while (n <= 5) {
            String linea = n + "\t" + (10 * n) + "\t" + (100 * n) + "\t" + (1000 * n);
            System.out.println(BORDE_IZQ + centrarTexto(linea, ANCHO - 2) + BORDE_DER);
            n++;
        }

        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "TITULO_TABLA": return "TABLA DE VALORES";
                default: return "";
            }
        } else {
            switch (clave) {
                case "TITULO_TABLA": return "VALUES TABLE";
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

    private static void imprimirLineaConDato(String texto) {
        int espaciosRestantes = ANCHO - texto.length() - 2;
        if (espaciosRestantes < 0) espaciosRestantes = 0;
        System.out.println(BORDE_IZQ + texto + " ".repeat(espaciosRestantes) + BORDE_DER);
    }
}