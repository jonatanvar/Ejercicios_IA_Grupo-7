/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 101 | 2025-10-26               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio101;

import java.util.Random;
import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static void ordenamientoBurbujaOptimizado(int[] arreglo, int tamano) {
        boolean intercambiado;
        for (int i = 0; i < tamano - 1; i++) {
            intercambiado = false;
            int comparaciones = tamano - 1 - i;
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("PASAJE " + (i + 1) + " - COMPARACIONES: " + comparaciones, ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");

            for (int j = 0; j < comparaciones; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambiado = true;
                    System.out.println("│ Intercambio: " + arreglo[j] + " > " + arreglo[j + 1] + " en posiciones " + j + ", " + (j + 1) + " │");
                } else {
                    System.out.println("│ No hay intercambio: " + arreglo[j] + " ≤ " + arreglo[j + 1] + " en posiciones " + j + ", " + (j + 1) + " │");
                }
            }
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

            if (!intercambiado) {
                System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
                System.out.println("│" + centrarTexto("NO HUBO INTERCAMBIOS, ORDEN COMPLETO", ANCHO - 2) + "│");
                System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
                break;
            }
        }
    }

    // Validaciones
    public static boolean validarEntero(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 101 | 2025-10-26                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = Math.max(0, espaciosTotal / 2);
        int espaciosDer = Math.max(0, espaciosTotal - espaciosIzq);
        return " ".repeat(espaciosIzq) + texto + " ".repeat(espaciosDer);
    }

    // Procesamiento de datos
    public static void procesarOrdenamiento(Scanner scanner, String idioma) {
        Random rand = new Random();
        int[] vector = new int[50];
        for (int i = 0; i < 50; i++) {
            vector[i] = rand.nextInt(100) + 1; // Números aleatorios entre 1 y 100
        }

        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("VECTOR ORIGINAL (50 ELEMENTOS)", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 50; i += 10) {
            StringBuilder linea = new StringBuilder("│ ");
            for (int j = i; j < i + 10 && j < 50; j++) {
                linea.append(String.format("%2d", vector[j])).append(" ");
            }
            System.out.println(linea.toString() + " ".repeat(Math.max(0, ANCHO - 3 - linea.length())) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

        ordenamientoBurbujaOptimizado(vector, 50);

        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("VECTOR ORDENADO (50 ELEMENTOS)", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 50; i += 10) {
            StringBuilder linea = new StringBuilder("│ ");
            for (int j = i; j < i + 10 && j < 50; j++) {
                linea.append(String.format("%2d", vector[j])).append(" ");
            }
            System.out.println(linea.toString() + " ".repeat(Math.max(0, ANCHO - 3 - linea.length())) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            procesarOrdenamiento(scanner, idiomaActual);
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
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }
}