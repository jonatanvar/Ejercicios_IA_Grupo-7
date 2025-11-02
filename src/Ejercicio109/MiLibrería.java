/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 109 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio109;

import java.util.Random;
import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static int generarImparPositivo(int max) {
        Random rand = new Random();
        return rand.nextInt(max / 2) * 2 + 1; // Genera impares positivos hasta max
    }

    public static void llenarMatrizImpares(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = generarImparPositivo(100); // Impares menores a 100
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz, String titulo) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(titulo, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // Validaciones
    public static boolean validarDimension(int dim) {
        return dim > 2 && dim < 15;
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 109 | 2025-10-27                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = Math.max(0, espaciosTotal / 2);
        int espaciosDer = Math.max(0, espaciosTotal - espaciosIzq);
        return " ".repeat(espaciosIzq) + texto + " ".repeat(espaciosDer);
    }

    // Procesamiento de datos
    public static void procesarMatriz(Scanner scanner, String idioma) {
        int tamano;
        do {
            System.out.print(obtenerTexto("INGRESE_TAMANO", idioma));
            if (scanner.hasNextInt()) {
                tamano = scanner.nextInt();
                scanner.nextLine();
                if (validarDimension(tamano)) break;
            } else {
                scanner.nextLine();
            }
            mostrarError(obtenerTexto("ERROR_TAMANO", idioma), idioma);
        } while (true);

        int[][] matriz = new int[tamano][tamano];
        llenarMatrizImpares(matriz);

        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("PROCESO DE LLENADO CON IMPARES", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.println("│ Llenando [" + i + "][" + j + "] con " + matriz[i][j] + " ".repeat(ANCHO - 28 - String.valueOf(matriz[i][j]).length()) + "│");
            }
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

        mostrarMatriz(matriz, "MATRIZ CUADRADA LLENA CON IMPARES");
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            procesarMatriz(scanner, idiomaActual);
            continuar = preguntarContinuar(scanner, idiomaActual);
        } while (continuar);
    }

    // Selección de idioma
    public static String seleccionarIdioma(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("SELECCIÓN DE IDIOMA / LANGUAGE SELECTION", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            System.out.println("│  1. Español" + " ".repeat(ANCHO - 15) + "│");
            System.out.println("│  2. English" + " ".repeat(ANCHO - 15) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione su idioma / Select language: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1 || opcion == 2) {
                    System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
                    String mensaje = "Idioma seleccionado / Selected language: " + (opcion == 1 ? "Español" : "English");
                    System.out.println("│" + centrarTexto(mensaje, ANCHO - 2) + "│");
                    System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
                    return opcion == 1 ? "ES" : "EN";
                }
            } else {
                scanner.nextLine();
            }
            mostrarError("Opción inválida, intente de nuevo.", "ES");
        } while (true);
    }

    // Formato de salida
    public static void mostrarError(String mensaje, String idioma) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(mensaje, ANCHO - 2) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static boolean preguntarContinuar(Scanner scanner, String idioma) {
        String respuesta;
        do {
            System.out.print("\n" + obtenerTexto("CONTINUAR", idioma));
            respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("S") || respuesta.equals("Y") || respuesta.equals("N")) {
                System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
                System.out.println("│" + centrarTexto(obtenerTexto("CONTINUAR", idioma) + respuesta, ANCHO - 2) + "│");
                System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
                return respuesta.equals("S") || respuesta.equals("Y");
            }
            mostrarError("Opción inválida, intente de nuevo.", idioma);
        } while (true);
    }

    // Procesamiento de textos
    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "INGRESE_TAMANO": return "Ingrese un número (3-14): ";
                case "ERROR_TAMANO": return "Número debe ser mayor a 2 y menor a 15.";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "INGRESE_TAMANO": return "Enter a number (3-14): ";
                case "ERROR_TAMANO": return "Number must be greater than 2 and less than 15.";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }
}