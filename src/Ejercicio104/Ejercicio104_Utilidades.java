package Ejercicio104;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio104_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";
    private static final int ANCHO_COLUMNA = 15;

    private static final int VENDEDORES = GeneradorVentas.NUM_VENDEDORES;
    private static final int PRODUCTOS = GeneradorVentas.NUM_PRODUCTOS;

    private static String[][] textos = {
            {"es", "en"},
            {"*** BIENVENIDO ***", "*** WELCOME ***"},
            {"Seleccione el idioma:", "Select language:"},
            {"[1] Español", "[1] Spanish"},
            {"[2] Inglés", "[2] English"},
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."},
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"},
            {"[1] Procesar Ventas del Mes", "[1] Process Monthly Sales"},
            {"[2] Finalizar Programa", "[2] End Program"},
            {"El programa finalizará.", "The program will end."},

            {"Reporte de Ventas Mensuales por Vendedor y Producto (Matriz)", "Monthly Sales Report by Vendor and Product (Matrix)"},
            {"Total de transacciones simuladas: %d%n", "Total simulated transactions: %d%n"},
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."},
            {"Producto", "Product"},
            {"Total Producto", "Product Total"},
            {"Total Vendedor", "Vendor Total"},
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
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 104 | 2025-10-21";
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

    public static void mostrarTotalTransacciones(int total) {
        System.out.printf(obtenerTexto(11), total);
    }

    public static void mostrarTabla(double[][] matrizTotales) {

        System.out.println("\n" + "=".repeat(ANCHO_COLUMNA * (VENDEDORES + 2) + 5));

        System.out.printf("%-" + ANCHO_COLUMNA + "s |", obtenerTexto(13));

        for (int j = 1; j <= VENDEDORES; j++) {
            System.out.printf("%-" + ANCHO_COLUMNA + "s|", "Vendedor " + j);
        }
        System.out.printf("%-" + ANCHO_COLUMNA + "s%n", obtenerTexto(14));

        System.out.println("─".repeat(ANCHO_COLUMNA * (VENDEDORES + 2) + 5));

        for (int i = 1; i <= PRODUCTOS; i++) {
            System.out.printf("%-" + ANCHO_COLUMNA + "s |", "Producto " + i);

            for (int j = 1; j <= VENDEDORES + 1; j++) {
                System.out.printf("%-" + ANCHO_COLUMNA + ".2f|", matrizTotales[i][j]);
            }
            System.out.println();
        }

        System.out.println("─".repeat(ANCHO_COLUMNA * (VENDEDORES + 2) + 5));
        System.out.printf("%-" + ANCHO_COLUMNA + "s |", obtenerTexto(15));

        for (int j = 1; j <= VENDEDORES + 1; j++) {
            System.out.printf("%-" + ANCHO_COLUMNA + ".2f|", matrizTotales[PRODUCTOS + 1][j]);
        }
        System.out.println("\n" + "=".repeat(ANCHO_COLUMNA * (VENDEDORES + 2) + 5));
    }
}