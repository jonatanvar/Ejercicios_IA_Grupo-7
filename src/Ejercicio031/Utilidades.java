/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 031 | 2025-10-12               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio031;

public class Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 031 | 2025-10-12", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarResultado(String resultado, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("TITULO_RESULTADO", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        String[] lines = resultado.split("\n");
        for (String line : lines) {
            System.out.println(BORDE_IZQ + centrarTexto(line, ANCHO - 2) + BORDE_DER);
        }
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "TITULO_RESULTADO": return "RESULTADO DEL PRODUCTO DE IMPARES";
                case "DETALLE_RESULTADO": return "El producto de los enteros impares del 1 al 15 es: ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "TITULO_RESULTADO": return "ODD NUMBERS PRODUCT RESULT";
                case "DETALLE_RESULTADO": return "The product of odd integers from 1 to 15 is: ";
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