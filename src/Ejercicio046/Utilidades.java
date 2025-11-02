/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 046 | 2025-10-14               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio046;

public class Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 046 | 2025-10-14", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarResultado(double valorAbsoluto, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("RESULTADO", idioma) + String.format("%.2f", valorAbsoluto), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }

    private static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "RESULTADO": return "El valor absoluto es: ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "RESULTADO": return "The absolute value is: ";
                default: return "";
            }
        }
    }
}