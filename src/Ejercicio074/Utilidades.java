/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 074 | 2025-10-18               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio074;

public class Utilidades {
    public static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 074 | 2025-10-18", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarBienvenida(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("BIENVENIDA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarTabla(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("TABLA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.printf(BORDE_IZQ + " %-5s %-15s %-15s %-15s %-15s" + BORDE_DER + "%n", "N", "Cuadrado Valor", "Cuadrado Ref", "Cubo Valor", "Cubo Ref");
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");

        for (int n = 0; n <= 10; n++) {
            int cuadradoValor = Operaciones.elevarCd(n);
            Integer cuadradoRef = n;
            Operaciones.elevarCd(cuadradoRef);
            int cuboValor = Operaciones.elevarCb(n);
            Integer cuboRef = n;
            Operaciones.elevarCb(cuboRef);
            System.out.printf(BORDE_IZQ + " %-5d %-15d %-15d %-15d %-15d" + BORDE_DER + "%n", n, cuadradoValor, cuadradoRef, cuboValor, cuboRef);
        }

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
                case "BIENVENIDA": return "¡Bienvenido al programa de elevaciones!";
                case "TABLA": return "Tabla de Elevaciones";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                case "ERROR_ENTRADA": return "Error: Ingrese un valor válido";
                default: return "";
            }
        } else {
            switch (clave) {
                case "BIENVENIDA": return "Welcome to the elevation program!";
                case "TABLA": return "Elevation Table";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                case "ERROR_ENTRADA": return "Error: Enter a valid value";
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