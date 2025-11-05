package Ejercicio068;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 068 | 2025-10-16
 */
public class Ejercicio068_Utilidades {

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
            {"[1] Iniciar Tutor de Multiplicación", "[1] Start Multiplication Tutor"}, // 7
            {"[2] Finalizar Programa", "[2] End Program"}, // 8
            {"El programa finalizará.", "The program will end."}, // 9

            // Mensajes del Programa
            {"Tutor de Multiplicación para Primaria", "Primary School Multiplication Tutor"}, // 10
            {"¿Cuánto es", "How much is"}, // 11 (Mensaje de la pregunta)
            {"Muy bien!", "Very good!"}, // 12 (Respuesta Correcta)
            {"No. Por favor intenta de nuevo.", "No. Please try again."}, // 13 (Respuesta Incorrecta/Error de Entrada)
            {"¿Desea continuar con otra pregunta? (S/N): ", "Do you want to continue with another question? (Y/N): "}, // 14
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 15
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

    // --- Métodos de I/O Adicionales ---

    /**
     * Pregunta al usuario si desea continuar con otra pregunta.
     * @param scanner Objeto Scanner.
     * @return true si desea continuar, false si no.
     */
    public static boolean preguntarContinuar(Scanner scanner) {
        System.out.print(obtenerTexto(14));
        String respuesta = scanner.next().toUpperCase();
        return (idiomaSeleccionado.equals("es") && respuesta.equals("S")) ||
                (idiomaSeleccionado.equals("en") && respuesta.equals("Y"));
    }

    // --- Métodos de Salida ---

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 068 | 2025-10-16";
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
}