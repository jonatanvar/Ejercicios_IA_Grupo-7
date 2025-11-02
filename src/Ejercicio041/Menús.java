/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 041 | 2025-10-13               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio041;

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
                if (opcion == 1 || opcion == 2) {
                    imprimirLineaConDato("Idioma seleccionado / Selected language: " + (opcion == 1 ? "Español" : "English"));
                    return opcion == 1 ? "ES" : "EN";
                }
            } else {
                scanner.next();
            }
            mostrarErrorEntrada("ES");
        } while (true);
    }

    public static int mostrarMenuPrincipal(Scanner scanner, String idioma) {
        int opcion;
        do {
            System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("MENU_TITULO", idioma), ANCHO - 2) + BORDE_DER);
            System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("MENU_EJECUTAR", idioma), ANCHO - 2) + BORDE_DER);
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("MENU_SALIR", idioma), ANCHO - 2) + BORDE_DER);
            System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
            System.out.print(obtenerTexto("SELECCIONE", idioma) + ": ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion == 1 || opcion == 2) {
                    imprimirLineaConDato(obtenerTexto("SELECCIONE", idioma) + ": " + opcion);
                    return opcion;
                }
            } else {
                scanner.next();
            }
            mostrarErrorEntrada(idioma);
        } while (true);
    }

    public static boolean preguntarRepetir(Scanner scanner, String idioma) {
        String respuesta;
        do {
            System.out.print("\n" + obtenerTexto("REPETIR", idioma));
            respuesta = scanner.next().toUpperCase();
            if (respuesta.equals("S") || respuesta.equals("Y") || respuesta.equals("N")) {
                imprimirLineaConDato(obtenerTexto("REPETIR", idioma) + respuesta);
                return respuesta.equals("S") || respuesta.equals("Y");
            }
            mostrarErrorEntrada(idioma);
        } while (true);
    }

    public static void mostrarDespedida(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("DESPEDIDA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_ENTRADA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "MENU_TITULO": return "MENÚ PRINCIPAL";
                case "MENU_EJECUTAR": return "1. Ejecutar programa";
                case "MENU_SALIR": return "2. Salir";
                case "SELECCIONE": return "Seleccione una opción";
                case "REPETIR": return "¿Desea ejecutar nuevamente? (S/N)";
                case "DESPEDIDA": return "¡Hasta pronto, gracias por usar el programa!";
                case "ERROR_ENTRADA": return "ERROR: Ingrese una opción válida";
                default: return "";
            }
        } else {
            switch (clave) {
                case "MENU_TITULO": return "MAIN MENU";
                case "MENU_EJECUTAR": return "1. Run program";
                case "MENU_SALIR": return "2. Exit";
                case "SELECCIONE": return "Select an option";
                case "REPETIR": return "Do you want to run again? (Y/N)";
                case "DESPEDIDA": return "See you soon, thank you for using the program!";
                case "ERROR_ENTRADA": return "ERROR: Enter a valid option";
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