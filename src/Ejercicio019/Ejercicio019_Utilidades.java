package Ejercicio019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 019 | 2025-10-15
 */
public class Ejercicio019_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";

    private static String[][] textos = {
            {"es", "en"},
            {"*** BIENVENIDO ***", "*** WELCOME ***"},
            {"Seleccione el idioma:", "Select language:"},
            {"[1] Español", "[1] Spanish"},
            {"[2] Inglés", "[2] English"},
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."},
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"},
            {"[1] Ejecutar Programa", "[1] Run Program"},
            {"[2] Finalizar Programa", "[2] End Program"},
            {"El programa finalizará.", "The program will end."},
            {"Análisis de Crédito de Clientes", "Customer Credit Analysis"},
            {"Ingrese el número de cuenta (o 0 para finalizar): ", "Enter account number (or 0 to end): "},
            {"Ingrese el saldo al inicio del mes: ", "Enter start of month balance: "},
            {"Ingrese el total de cargos del mes: ", "Enter total items charged this month: "},
            {"Ingrese el total de créditos aplicados: ", "Enter total credits applied: "},
            {"Ingrese el límite de crédito: ", "Enter credit limit: "},
            {"Se excedió el límite de su crédito", "Credit limit exceeded"},
            {"Cuenta: ", "Account: "},
            {"Límite de crédito: ", "Credit limit: "},
            {"Nuevo saldo: ", "New balance: "},
            {"------------------------------------------", "------------------------------------------"},
            {"ERROR: Entrada inválida. Ingrese un número.", "ERROR: Invalid input. Enter a number."},
    };

    private static String obtenerTexto(int index) {
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
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    idiomaSeleccionado = "es";
                } else if (opcion == 2) {
                    idiomaSeleccionado = "en";
                } else {
                    System.out.println(obtenerTexto(5));
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
                opcion = scanner.nextInt();
                if (opcion == 2) {
                    System.out.println(obtenerTexto(9));
                    return false;
                } else if (opcion != 1) {
                    System.out.println(obtenerTexto(5));
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(5));
                scanner.next();
            }
        }
        return true;
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                if (scanner.hasNextInt()) {
                    valor = scanner.nextInt();
                    entradaValida = true;
                } else {
                    System.out.println(obtenerTexto(21));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(21));
                scanner.next();
            }
        }
        return valor;
    }

    public static double leerDouble(Scanner scanner, String mensaje) {
        double valor = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                if (scanner.hasNextDouble()) {
                    valor = scanner.nextDouble();
                    entradaValida = true;
                } else {
                    System.out.println(obtenerTexto(21));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(21));
                scanner.next();
            }
        }
        return valor;
    }

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 019 | 2025-10-15";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    public static void mostrarAdvertencia(int cuenta, double limiteCredito, double nuevoSaldo) {
        System.out.println(obtenerTexto(20));
        System.out.printf("%s%d%n", obtenerTexto(17), cuenta);
        System.out.printf("%s$%.2f%n", obtenerTexto(18), limiteCredito);
        System.out.printf("%s$%.2f%n", obtenerTexto(19), nuevoSaldo);
        System.out.println(obtenerTexto(16));
        System.out.println(obtenerTexto(20));
    }

    public static void mostrarEncabezado() {
        System.out.println("\n--- " + obtenerTexto(10) + " ---");
    }

    public static String obtenerTexto(int index, boolean isPrivate) {
        if (isPrivate) {
            return obtenerTexto(index);
        }
        return obtenerTexto(index);
    }
}
