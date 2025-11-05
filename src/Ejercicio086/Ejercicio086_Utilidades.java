package Ejercicio086;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 086 | 2025-10-16
 */
public class Ejercicio086_Utilidades {

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
            {"[1] Escribir Mensaje en Archivo", "[1] Write Message to File"}, // 7
            {"[2] Finalizar Programa", "[2] End Program"}, // 8
            {"El programa finalizará.", "The program will end."}, // 9

            // Mensajes del Programa
            {"Imprimiendo Mensaje en Archivo de Texto", "Printing Message to Text File"}, // 10
            {"Ingrese el mensaje que desea guardar en el archivo: ", "Enter the message you want to save to the file: "}, // 11
            {"ÉXITO: Mensaje guardado correctamente en: %s%n", "SUCCESS: Message successfully saved to: %s%n"}, // 12
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 13
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    // --- Métodos de Menú/Sello ---

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
                    scanner.nextLine(); // Consumir el salto de línea pendiente
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

    // --- Métodos de I/O ---

    /**
     * Solicita y lee el mensaje completo del usuario.
     */
    public static String leerMensaje(Scanner scanner) {
        System.out.print(obtenerTexto(11));
        // Usamos nextLine() para capturar toda la frase o línea de texto
        return scanner.nextLine();
    }

    // --- Métodos de Salida ---

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 086 | 2025-10-16";
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

    public static void mostrarExito(String nombreArchivo) {
        System.out.printf(obtenerTexto(12), nombreArchivo);
    }
}