package Ejercicio095;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 095 | 2025-10-21
 */
public class Ejercicio095_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";
    private static final int MIN_TAMANO = 10;
    private static final int MAX_TAMANO = 100;

    // --- Diccionario para textos (Bilingüe, abreviado) ---
    private static String[][] textos = {
            {"es", "en"}, // 0
            {"*** BIENVENIDO ***", "*** WELCOME ***"}, // 1
            {"Seleccione el idioma:", "Select language:"}, // 2
            {"[1] Español", "[1] Spanish"}, // 3
            {"[2] Inglés", "[2] English"}, // 4
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."}, // 5
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"}, // 6
            {"[1] Crear y Ordenar Vector", "[1] Create and Sort Vector"}, // 7
            {"[2] Finalizar Programa", "[2] End Program"}, // 8
            {"El programa finalizará.", "The program will end."}, // 9

            // Mensajes del Programa
            {"Generador y Ordenador de Vectores Aleatorios", "Random Vector Generator and Sorter"}, // 10
            {"Ingrese el tamaño del vector (entero entre " + MIN_TAMANO + " y " + MAX_TAMANO + "): ", "Enter the vector size (integer between " + MIN_TAMANO + " and " + MAX_TAMANO + "): "}, // 11
            {"ERROR: Entrada inválida. El tamaño debe ser un entero entre " + MIN_TAMANO + " y " + MAX_TAMANO + ".", "ERROR: Invalid input. Size must be an integer between " + MIN_TAMANO + " and " + MAX_TAMANO + "."}, // 12
            {"Vector Original Creado:", "Original Vector Created:"}, // 13
            {"Vector Ordenado (Mayor a Menor):", "Sorted Vector (Descending):"}, // 14
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 15
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    // --- Métodos de I/O y Validación ---

    /**
     * Solicita y lee el tamaño del vector, validando que esté en el rango [10, 100].
     */
    public static int leerTamanoVector(Scanner scanner) {
        int tamano = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(obtenerTexto(11));
            try {
                if (scanner.hasNextInt()) {
                    tamano = scanner.nextInt();
                    if (tamano >= MIN_TAMANO && tamano <= MAX_TAMANO) {
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
        return tamano;
    }

    // --- Métodos de Presentación ---

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 095 | 2025-10-21";
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
     * Muestra el contenido de un arreglo.
     */
    public static void mostrarVector(int[] vector, int mensajeIndex) {
        System.out.println("\n" + obtenerTexto(mensajeIndex));

        // Uso de ciclos para presentar el arreglo
        System.out.print("[");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // --- Métodos de Menú (Implementación estándar) ---

    public static void seleccionarIdioma(Scanner scanner) {
        // ... (Implementación omitida por ser estándar)
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
        // ... (Implementación omitida por ser estándar)
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
}