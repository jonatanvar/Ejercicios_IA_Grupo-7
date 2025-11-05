package Ejercicio064;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 064 | 2025-10-16
 */
public class Ejercicio064_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";

    // --- Diccionario para textos (Bilingüe) ---
    private static String[][] textos = {
            {"es", "en"}, // 0. Códigos de Idioma
            // Mensajes de Menú
            {"*** BIENVENIDO ***", "*** WELCOME ***"}, // 1
            {"Seleccione el idioma:", "Select language:"}, // 2
            {"[1] Español", "[1] Spanish"}, // 3
            {"[2] Inglés", "[2] English"}, // 4
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."}, // 5
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"}, // 6
            {"[1] Ejecutar Programa", "[1] Run Program"}, // 7
            {"[2] Finalizar Programa", "[2] End Program"}, // 8
            {"El programa finalizará.", "The program will end."}, // 9

            // Mensajes del Programa
            {"Inversión de Dígitos de un Número Entero", "Integer Digit Reversal"}, // 10
            {"Ingrese un número entero positivo: ", "Enter a positive integer number: "}, // 11
            {"ERROR: Entrada inválida. Ingrese un número entero positivo.", "ERROR: Invalid input. Enter a positive integer number."}, // 12
            {"El número invertido es: %d%n", "The reversed number is: %d%n"}, // 13
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 14
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    // --- Métodos de Menú ---

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

    // --- Métodos de I/O y Validación ---

    /**
     * Solicita y lee un entero que debe ser positivo.
     */
    public static int leerEnteroPositivo(Scanner scanner) {
        int numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(obtenerTexto(11));
            try {
                if (scanner.hasNextInt()) {
                    numero = scanner.nextInt();
                    if (numero >= 0) { // Permitimos el cero
                        entradaValida = true;
                    } else {
                        System.out.println(obtenerTexto(12));
                    }
                } else {
                    System.out.println(obtenerTexto(12));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(12));
                scanner.next();
            }
        }
        return numero;
    }

    // --- Métodos de Salida ---

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 064 | 2025-10-16";
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

    public static void mostrarResultado(int numeroInvertido) {
        System.out.printf(obtenerTexto(13), numeroInvertido);
    }
}