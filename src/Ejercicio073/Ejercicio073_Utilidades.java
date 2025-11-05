package Ejercicio073;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 073 | 2025-10-16
 */
public class Ejercicio073_Utilidades {

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
            {"Comparación: Triplicar por Valor vs. Referencia", "Comparison: Triple by Value vs. Reference"}, // 10
            {"Ingrese un valor inicial (entero positivo): ", "Enter an initial value (positive integer): "}, // 11
            {"ERROR: Entrada inválida. Ingrese un número entero positivo.", "ERROR: Invalid input. Enter a positive integer number."}, // 12
            {"Valor inicial de cuenta: %d%n", "Initial value of count: %d%n"}, // 13
            {"Resultado de triplicarPorValor: %d%n", "Result of tripleByValue: %d%n"}, // 14
            {"Valor de cuenta después de triplicarPorValor: %d%n", "Value of count after tripleByValue: %d%n"}, // 15
            {"Valor de cuenta antes de triplicarPorReferencia: %d%n", "Value of count before tripleByReference: %d%n"}, // 16
            {"Valor de cuenta después de triplicarPorReferencia: %d%n", "Value of count after tripleByReference: %d%n"}, // 17
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 18
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    // --- Métodos de Menú/Validación (Omitidos para brevedad, son idénticos a los ejercicios anteriores) ---

    // ... (Métodos seleccionarIdioma, mostrarMenuEjecucion, mostrarSelloCorto, mostrarEncabezado) ...

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
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 073 | 2025-10-16";
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

    // Validación
    public static int leerEnteroPositivo(Scanner scanner) {
        int numero = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(obtenerTexto(11));
            try {
                if (scanner.hasNextInt()) {
                    numero = scanner.nextInt();
                    if (numero >= 0) {
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

    // Mostrar resultados
    public static void mostrarValorInicial(int cuenta) {
        System.out.printf(obtenerTexto(13), cuenta);
    }
    public static void mostrarResultadoValor(int resultado) {
        System.out.printf(obtenerTexto(14), resultado);
    }
    public static void mostrarValorDespuesValor(int cuenta) {
        System.out.printf(obtenerTexto(15), cuenta);
    }
    public static void mostrarValorAntesReferencia(int cuenta) {
        System.out.printf(obtenerTexto(16), cuenta);
    }
    public static void mostrarValorDespuesReferencia(int cuenta) {
        System.out.printf(obtenerTexto(17), cuenta);
    }
}