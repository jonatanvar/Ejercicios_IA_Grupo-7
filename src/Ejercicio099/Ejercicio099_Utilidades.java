package Ejercicio099;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 099 | 2025-10-21
 */
public class Ejercicio099_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";
    private static final int ANCHO_COLUMNA = 15;

    private static final String[] RANGOS_ES = {
            "$200-299", "$300-399", "$400-499", "$500-599",
            "$600-699", "$700-799", "$800-899", "$900-999", "$1000 o más"
    };
    private static final String[] RANGOS_EN = {
            "$200-299", "$300-399", "$400-499", "$500-599",
            "$600-699", "$700-799", "$800-899", "$900-999", "$1000 or more"
    };

    private static String[][] textos = {

            {"es", "en"}, // 0
            {"*** BIENVENIDO ***", "*** WELCOME ***"},
            {"Seleccione el idioma:", "Select language:"},
            {"[1] Español", "[1] Spanish"},
            {"[2] Inglés", "[2] English"},
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."},
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"},
            {"[1] Procesar Pagos y Generar Reporte", "[1] Process Payments and Generate Report"},
            {"[2] Finalizar Programa", "[2] End Program"},
            {"El programa finalizará.", "The program will end."},

            {"Reporte de Salarios por Rango (Arreglos)", "Salary Range Report (Arrays)"},
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 11
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
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 099 | 2025-10-21";
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
     * Muestra los contadores de salario y genera la gráfica de barras horizontal.
     * @param contadores Arreglo con el número de vendedores en cada rango.
     */
    public static void mostrarReporte(int[] contadores) {
        String[] rangos = idiomaSeleccionado.equals("es") ? RANGOS_ES : RANGOS_EN;

        System.out.println("\n" + "=".repeat(ANCHO_COLUMNA + 30));
        System.out.printf("%-" + ANCHO_COLUMNA + "s | %-10s | Gráfico de Barras%n", "Rango Salarial", "Vendedores");
        System.out.println("=".repeat(ANCHO_COLUMNA + 30));

        for (int i = 0; i < contadores.length; i++) {

            System.out.printf("%-" + ANCHO_COLUMNA + "s | %-10d | ", rangos[i], contadores[i]);


            for (int j = 0; j < contadores[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("=".repeat(ANCHO_COLUMNA + 30));
    }
}