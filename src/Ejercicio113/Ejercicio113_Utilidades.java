package Ejercicio113;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 113 | 2025-10-21
 */
public class Ejercicio113_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";
    private static final int ANCHO_CELDA = 6;

    private static String[][] textos = {
            {"es", "en"},
            {"*** BIENVENIDO ***", "*** WELCOME ***"},
            {"Seleccione el idioma:", "Select language:"},
            {"[1] Español", "[1] Spanish"},
            {"[2] Inglés", "[2] English"},
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."},
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"},
            {"[1] Validar y Calcular Trayecto", "[1] Validate and Calculate Route"},
            {"[2] Finalizar Programa", "[2] End Program"},
            {"El programa finalizará.", "The program will end."},

            {"Análisis de Trayectos en Grafo de 10 Ciudades (0-9)", "Route Analysis in 10-City Graph (0-9)"}, // 10
            {"Ingrese el trayecto (Ciudades separadas por espacio, ej: 0 5 2 9): ", "Enter the route (Cities separated by space, e.g.: 0 5 2 9): "}, // 11
            {"ERROR: Entrada no válida. Ingrese solo números separados por espacio.", "ERROR: Invalid input. Enter only numbers separated by space."}, // 12
            {"RESULTADO: Trayecto VÁLIDO. Distancia total: %d KM%n", "RESULT: VALID Route. Total distance: %d KM%n"}, // 13
            {"RESULTADO: Trayecto INVÁLIDO. No existe carretera directa entre dos ciudades consecutivas.", "RESULT: INVALID Route. No direct road exists between two consecutive cities."}, // 14
            {"RESULTADO: Trayecto INVÁLIDO. Una o más ciudades están fuera del rango [0-9].", "RESULT: INVALID Route. One or more cities are outside the range [0-9]."}, // 15
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 16
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    public static void seleccionarIdioma(Scanner scanner) {
        int opcion = 0;
        while (opcion != 1 && opcion != 2) {
            System.out.println(obtenerTexto(1));
            System.out.println(obtenerTexto(2));
            System.out.println(obtenerTexto(3));
            System.out.println(obtenerTexto(4));
            System.out.print(">");
            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 1) {
                        idiomaSeleccionado = "es";
                    } else if (opcion == 2) {
                        idiomaSeleccionado = "en";
                    } else {
                        System.out.println(obtenerTexto(5));
                    }
                } else {
                    System.out.println(obtenerTexto(5));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(5));
                scanner.next();
            }
        }
    }

    public static boolean mostrarMenuEjecucion(Scanner scanner) {
        int opcion = 0;
        while (opcion != 1 && opcion != 2) {
            System.out.println("\n" + obtenerTexto(6));
            System.out.println(obtenerTexto(7));
            System.out.println(obtenerTexto(8));
            System.out.print(">");
            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 2) {
                        System.out.println(obtenerTexto(9));
                        return false;
                    } else if (opcion != 1) {
                        System.out.println(obtenerTexto(5));
                    }
                } else {
                    System.out.println(obtenerTexto(5));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(5));
                scanner.next();
            }
        }
        return true;
    }

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 113 | 2025-10-21";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    public static void mostrarEncabezado() {
        System.out.println("\n--- " + obtenerTexto(10) + " ---");
    }

    /**
     * Imprime la matriz de distancias en formato tabular.
     */
    public static void imprimirMatriz(int[][] matriz) {
        int tamano = UtilidadesGrafo.NUM_CIUDADES;

        System.out.println("\nMatriz de Distancias (KM):");

        System.out.print("  |");
        for (int j = 0; j < tamano; j++) {
            System.out.printf("%" + ANCHO_CELDA + "d", j);
        }
        System.out.println();
        System.out.println("─".repeat(ANCHO_CELDA * (tamano + 1)));

        for (int i = 0; i < tamano; i++) {
            System.out.printf("%d |", i);
            for (int j = 0; j < tamano; j++) {
                System.out.printf("%" + ANCHO_CELDA + "d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Lee y valida el vector de trayecto desde el teclado.
     * @param scanner Scanner para leer la entrada.
     * @return Arreglo de enteros con el trayecto o null si hay error de formato.
     */
    public static int[] leerTrayecto(Scanner scanner) {
        int[] trayecto = null;
        scanner.nextLine();

        System.out.print(obtenerTexto(11));
        String linea = scanner.nextLine().trim();

        if (linea.isEmpty()) {
            System.out.println(obtenerTexto(12));
            return null;
        }

        try {
            String[] ciudadesStr = linea.split("\\s+");
            trayecto = new int[ciudadesStr.length];
            for (int i = 0; i < ciudadesStr.length; i++) {
                trayecto[i] = Integer.parseInt(ciudadesStr[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println(obtenerTexto(12));
            return null;
        }

        return trayecto;
    }
}