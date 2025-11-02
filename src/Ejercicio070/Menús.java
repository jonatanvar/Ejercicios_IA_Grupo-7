/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 070 | 2025-10-17               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio070;

import java.util.Scanner;

public class Menús {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static String seleccionarIdioma(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
            System.out.println(BORDE_IZQ + centrarTexto("SELECCIÓN DE IDIOMA / LANGUAGE SELECTION", ANCHO - 2) + BORDE_DER);
            System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
            System.out.println(BORDE_IZQ + centrarTexto("1. Español", ANCHO - 2) + BORDE_DER);
            System.out.println(BORDE_IZQ + centrarTexto("2. English", ANCHO - 2) + BORDE_DER);
            System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione su idioma / Select language: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1 || opcion == 2) {
                    imprimirLineaConDato("Idioma seleccionado / Selected language: " + (opcion == 1 ? "Español" : "English"));
                    return opcion == 1 ? "ES" : "EN";
                }
            } else {
                scanner.nextLine();
            }
            Utilidades.mostrarErrorEntrada("ES");
        } while (true);
    }

    public static boolean preguntarContinuar(Scanner scanner, String idioma) {
        String respuesta;
        do {
            System.out.print("\n" + Utilidades.obtenerTexto("CONTINUAR", idioma));
            respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("S") || respuesta.equals("Y") || respuesta.equals("N")) {
                imprimirLineaConDato(Utilidades.obtenerTexto("CONTINUAR", idioma) + respuesta);
                return respuesta.equals("S") || respuesta.equals("Y");
            }
            Utilidades.mostrarErrorEntrada(idioma);
        } while (true);
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