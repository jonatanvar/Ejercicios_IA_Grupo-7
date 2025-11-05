package Ejercicio024;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 024 | 2025-10-15
 */
public class Ejercicio024_Utilidades {

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
            {"Verificación de Lados de un Triángulo", "Triangle Sides Verification"}, // 10
            {"Ingrese el lado A (double, positivo): ", "Enter side A (double, positive): "}, // 11
            {"Ingrese el lado B (double, positivo): ", "Enter side B (double, positive): "}, // 12
            {"Ingrese el lado C (double, positivo): ", "Enter side C (double, positive): "}, // 13
            {"Resultado: Los lados SÍ pueden formar un triángulo.", "Result: The sides CAN form a triangle."}, // 14
            {"Resultado: Los lados NO pueden formar un triángulo.", "Result: The sides CANNOT form a triangle."}, // 15
            {"ERROR: Entrada inválida. Ingrese un número double positivo.", "ERROR: Invalid input. Enter a positive double number."}, // 16
            {"--- ANÁLISIS ---", "--- ANALYSIS ---"}, // 17
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 18
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

    // --- Métodos de I/O y Validación ---

    /**
     * Solicita y lee un valor double positivo (mayor que cero).
     */
    public static double leerDoublePositivo(Scanner scanner, String mensaje) {
        double valor = 0.0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                if (scanner.hasNextDouble()) {
                    valor = scanner.nextDouble();
                    if (valor > 0.0) {
                        entradaValida = true;
                    } else {
                        System.out.println(obtenerTexto(16));
                    }
                } else {
                    System.out.println(obtenerTexto(16));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(16));
                scanner.next();
            }
        }
        return valor;
    }

    // --- Métodos de Salida ---

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 024 | 2025-10-15";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    public static void mostrarResultado(boolean esTriangulo) {
        System.out.println("\n" + obtenerTexto(17));
        if (esTriangulo) {
            System.out.println(obtenerTexto(14));
        } else {
            System.out.println(obtenerTexto(15));
        }
    }

    public static void mostrarEncabezado() {
        System.out.println("\n--- " + obtenerTexto(10) + " ---");
    }
}