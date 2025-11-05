package Ejercicio034;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 034 | 2025-10-15
 */
public class Ejercicio034_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static final int CENTINELA = 0;
    private static String idiomaSeleccionado = "es";

    private static String[][] textos = {
            {"es", "en"},

            {"*** BIENVENIDO ***", "*** WELCOME ***"}, // 1
            {"Seleccione el idioma:", "Select language:"}, // 2
            {"[1] Español", "[1] Spanish"}, // 3
            {"[2] Inglés", "[2] English"}, // 4
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."}, // 5
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"}, // 6
            {"[1] Ejecutar Programa", "[1] Run Program"}, // 7
            {"[2] Finalizar Programa", "[2] End Program"}, // 8
            {"El programa finalizará.", "The program will end."}, // 9

            {"Cálculo Total de Ventas por Producto", "Total Sales Calculation by Product"}, // 10
            {"Ingrese el número del producto (1-5, o 0 para finalizar): ", "Enter product number (1-5, or 0 to finish): "}, // 11
            {"Ingrese la cantidad vendida (entero positivo): ", "Enter quantity sold (positive integer): "}, // 12
            {"ERROR: Entrada inválida. Ingrese un número entero.", "ERROR: Invalid input. Enter an integer number."}, // 13
            {"ERROR: Número de producto inválido. Debe ser 1-5.", "ERROR: Invalid product number. Must be 1-5."}, // 14
            {"ERROR: Cantidad inválida. Debe ser un entero positivo.", "ERROR: Invalid quantity. Must be a positive integer."}, // 15
            {"El valor total de venta de todos los productos es: $%.2f%n", "The total retail value of all products sold is: $%.2f%n"}, // 16
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 17
    };

    public static int getCentinela() {
        return CENTINELA;
    }

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
                    System.out.println(obtenerTexto(13));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(13));
                scanner.next();
            }
        }
        return valor;
    }

    public static int leerCantidadVendida(Scanner scanner) {
        int valor = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(obtenerTexto(12));
            try {
                if (scanner.hasNextInt()) {
                    valor = scanner.nextInt();
                    if (valor > 0) {
                        entradaValida = true;
                    } else {
                        System.out.println(obtenerTexto(15));
                    }
                } else {
                    System.out.println(obtenerTexto(13));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(13));
                scanner.next();
            }
        }
        return valor;
    }

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 034 | 2025-10-15";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    public static void mostrarResultado(double totalVentas) {
        System.out.printf(obtenerTexto(16), totalVentas);
    }

    public static void mostrarEncabezado() {
        System.out.println("\n--- " + obtenerTexto(10) + " ---");
    }

    public static void mostrarErrorProductoInvalido() {
        System.out.println(obtenerTexto(14));
    }
}