package Ejercicio91;

import java.util.Scanner;

public class Ejercicio91_Utilidades {
    private static final String LINEA_SUP = "---------------------------------------------------------------------";
    private static final String LINEA_SEP = "|                                                                   |";
    private static final String LINEA_INF = "---------------------------------------------------------------------";
    private static final int ANCHO = 68;
    private static int idioma = 1;

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotales = ancho - texto.length();
        int izq = espaciosTotales / 2;
        int der = espaciosTotales - izq;
        return "|" + " ".repeat(izq) + texto + " ".repeat(der) + "|";
    }

    public static void mostrarSelloCorto() {
        System.out.println(LINEA_SUP);
        System.out.println(centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO));
        System.out.println(LINEA_SEP);
        String sello = "Cristina Cruz | Lis | cristinacruz@unah.hn | 091 | 2025-11-05";
        System.out.println(centrarTexto(sello, ANCHO));
        System.out.println(LINEA_INF);
        System.out.println();
    }

    public static void seleccionarIdioma(Scanner sc) {
        System.out.println("Seleccione el idioma / Select language:");
        System.out.println("1. Español");
        System.out.println("2. English");
        int op = leerEntero(sc, "Opción / Option: ");
        idioma = (op == 1 || op == 2) ? op : 1;
    }

    public static boolean mostrarMenuEjecucion(Scanner sc) {
        System.out.println(obtenerTexto(1));
        System.out.println(obtenerTexto(2));
        System.out.println(obtenerTexto(3));
        int op = leerEntero(sc, obtenerTexto(4));
        return op == 1;
    }

    public static void mostrarEncabezado() {
        System.out.println(obtenerTexto(10));
    }

    public static int leerEntero(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println(obtenerTexto(5));
                sc.nextLine();
            }
        }
    }

    public static int leerEnteroRango(Scanner sc, String msg, int min, int max) {
        int n;
        do {
            n = leerEntero(sc, msg);
            if (n < min || n > max) {
                System.out.printf(obtenerTexto(6), min, max);
            }
        } while (n < min || n > max);
        return n;
    }

    public static void mostrarLista(int[] lista) {
        System.out.print(obtenerTexto(7));
        for (int i = 0; i < lista.length; i++) {
            if (i == lista.length - 1) {
                System.out.print(lista[i] + obtenerTexto(8));
            } else if (i == lista.length - 2) {
                System.out.print(lista[i] + obtenerTexto(9));
            } else {
                System.out.print(lista[i] + ", ");
            }
        }
        System.out.println("\n");
    }

    public static void mostrarTabla(int[] seleccion, int[] lista) {
        System.out.println(obtenerTexto(11));
        System.out.println(obtenerTexto(12));
        for (int valor : seleccion) {
            int posicion = -1;
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == valor) {
                    posicion = i;
                    break;
                }
            }
            System.out.printf("%5d | %17d%n", valor, posicion);
        }
    }

    public static String obtenerTexto(int id) {
        return switch (id) {
            case 1  -> idioma == 1 ? "Menú de ejecución:\n" : "Execution menu:\n";
            case 2  -> idioma == 1 ? "1. Ejecutar\n" : "1. Run\n";
            case 3  -> idioma == 1 ? "2. Finalizar\n" : "2. Exit\n";
            case 4  -> idioma == 1 ? "Opción: " : "Option: ";
            case 5  -> idioma == 1 ? "Error: Ingrese un número entero válido.\n"
                    : "Error: Enter a valid integer.\n";
            case 6  -> idioma == 1 ? "Error: Debe estar entre %d y %d.\n"
                    : "Error: Must be between %d and %d.\n";
            case 7  -> idioma == 1 ? "Notar " : "Note ";
            case 8  -> idioma == 1 ? "." : ".";
            case 9  -> idioma == 1 ? " y " : " and ";
            case 10 -> idioma == 1 ? "Sistema de entrada de datos\n"
                    : "Data input system\n";
            case 11 -> idioma == 1 ? "Valor | Posición en lista\n"
                    : "Value | Position in list\n";
            case 12 -> idioma == 1 ? "------+------------------\n"
                    : "------+------------------\n";
            case 20 -> idioma == 1 ? "Ingrese un número entero (11-99): "
                    : "Enter an integer (11-99): ";
            case 21 -> idioma == 1 ? "Número " : "Number ";
            case 22 -> idioma == 1 ? "Error: El número " : "Error: The number ";
            case 23 -> idioma == 1 ? "Ingrese número " : "Enter number ";
            case 24 -> idioma == 1 ? "Error: " : "Error: ";
            case 30 -> idioma == 1 ? "Programa finalizado. Gracias.\n"
                    : "Program terminated. Thank you.\n";
            default -> "";
        };
    }
}