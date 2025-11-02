/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 112 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio112;

import java.util.Random;
import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static void llenarMatrizTemperaturas(int[][] matriz) {
        Random rand = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(51) - 10; // Temperaturas de -10 a 40
            }
        }
    }

    public static int[] encontrarMaxMinSemana(int[][] matriz) {
        int max = matriz[0][0], min = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > max) max = matriz[i][j];
                if (matriz[i][j] < min) min = matriz[i][j];
            }
        }
        return new int[]{max, min};
    }

    public static int[] encontrarMaxMinDia(int[][] matriz, int dia) {
        int max = matriz[dia][0], min = matriz[dia][0];
        for (int j = 0; j < matriz[0].length; j++) {
            if (matriz[dia][j] > max) max = matriz[dia][j];
            if (matriz[dia][j] < min) min = matriz[dia][j];
        }
        return new int[]{max, min};
    }

    public static double calcularMediaSemana(int[][] matriz) {
        int suma = 0, total = matriz.length * matriz[0].length;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                suma += matriz[i][j];
            }
        }
        return (double) suma / total;
    }

    public static double calcularMediaDia(int[][] matriz, int dia) {
        int suma = 0, total = matriz[0].length;
        for (int j = 0; j < matriz[0].length; j++) {
            suma += matriz[dia][j];
        }
        return (double) suma / total;
    }

    public static int contarDiasSuperiores30(int[][] matriz) {
        int count = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (calcularMediaDia(matriz, i) > 30) count++;
        }
        return count;
    }

    // Validaciones
    public static boolean validarEntrada(String input) {
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
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 112 | 2025-10-27                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = Math.max(0, espaciosTotal / 2);
        int espaciosDer = Math.max(0, espaciosTotal - espaciosIzq);
        return " ".repeat(espaciosIzq) + texto + " ".repeat(espaciosDer);
    }

    // Procesamiento de datos
    public static void procesarTemperaturas(Scanner scanner, String idioma) {
        int[][] temperaturas = new int[7][24];
        llenarMatrizTemperaturas(temperaturas);

        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("PROCESO DE LLENADO DE TEMPERATURAS", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                System.out.println("│ Día " + (i + 1) + ", Hora " + j + ": " + temperaturas[i][j] + " °C" + " ".repeat(ANCHO - 31 - String.valueOf(temperaturas[i][j]).length()) + "│");
            }
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

        mostrarMatriz(temperaturas, "MATRIZ DE TEMPERATURAS (7x24)");
        int[] maxMinSemana = encontrarMaxMinSemana(temperaturas);
        mostrarMaxMinSemana(maxMinSemana);
        mostrarMaxMinDias(temperaturas);
        double mediaSemana = calcularMediaSemana(temperaturas);
        mostrarMediaSemana(mediaSemana);
        mostrarMediasDias(temperaturas);
        int diasSuperiores30 = contarDiasSuperiores30(temperaturas);
        mostrarDiasSuperiores30(diasSuperiores30);
    }

    // Funciones de impresión
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

    public static void mostrarMaxMinSemana(int[] maxMin) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("MÁXIMA Y MÍNIMA TEMPERATURA DE LA SEMANA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Máxima: " + maxMin[0] + " °C" + " ".repeat(ANCHO - 17 - String.valueOf(maxMin[0]).length()) + "│");
        System.out.println("│ Mínima: " + maxMin[1] + " °C" + " ".repeat(ANCHO - 17 - String.valueOf(maxMin[1]).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarMaxMinDias(int[][] matriz) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("MÁXIMA Y MÍNIMA POR DÍA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            int[] maxMin = encontrarMaxMinDia(matriz, i);
            System.out.println("│ Día " + (i + 1) + ": Máx " + maxMin[0] + " °C, Mín " + maxMin[1] + " °C" + " ".repeat(ANCHO - 35 - String.valueOf(maxMin[0]).length() - String.valueOf(maxMin[1]).length()) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarMediaSemana(double media) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("TEMPERATURA MEDIA DE LA SEMANA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Media: " + String.format("%.2f", media) + " °C" + " ".repeat(ANCHO - 17 - String.valueOf(String.format("%.2f", media)).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarMediasDias(int[][] matriz) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("TEMPERATURA MEDIA POR DÍA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            double media = calcularMediaDia(matriz, i);
            System.out.println("│ Día " + (i + 1) + ": " + String.format("%.2f", media) + " °C" + " ".repeat(ANCHO - 23 - String.valueOf(String.format("%.2f", media)).length()) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarDiasSuperiores30(int dias) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("DÍAS CON MEDIA SUPERIOR A 30 °C", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Total: " + dias + " día(s)" + " ".repeat(ANCHO - 18 - String.valueOf(dias).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            procesarTemperaturas(scanner, idiomaActual);
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