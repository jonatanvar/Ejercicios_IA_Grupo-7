/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 056 | 2025-10-15 00:24 CST    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio056;

public class Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 056 | 2025-10-15 00:24 CST", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarNombres(String[] nombres, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("LISTA_NOMBRES", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        for (String nombre : nombres) {
            // Asegurar que el texto ocupe 30 caracteres alineado a la izquierda, con relleno de espacios
            String formattedNombre = String.format("%-30s", nombre);
            // Calcular espacios restantes para mantener el ancho total de 70 caracteres
            int espaciosRestantes = ANCHO - 2 - formattedNombre.length();
            if (espaciosRestantes < 0) espaciosRestantes = 0;
            System.out.println(BORDE_IZQ + formattedNombre + " ".repeat(espaciosRestantes) + BORDE_DER);
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
                case "INGRESE_NOMBRE": return "Ingrese el nombre ";
                case "INGRESE_APELLIDO": return "Ingrese el apellido ";
                case "LISTA_NOMBRES": return "Lista de nombres y apellidos";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                case "ERROR_ENTRADA": return "Error: Ingrese solo letras y espacios";
                default: return "";
            }
        } else {
            switch (clave) {
                case "INGRESE_NOMBRE": return "Enter the name ";
                case "INGRESE_APELLIDO": return "Enter the surname ";
                case "LISTA_NOMBRES": return "List of names and surnames";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                case "ERROR_ENTRADA": return "Error: Enter letters and spaces only";
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