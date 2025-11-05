package Ejercicio108;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 108 | 2025-10-21
 */
public class Ejercicio108_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";
    private static final int ANCHO_CELDA = 6;

    // Diccionario de textos (Abreviado)
    private static String[][] textos = {
            {"es", "en"}, // 0
            {"*** BIENVENIDO ***", "*** WELCOME ***"}, // 1
            {"Seleccione el idioma:", "Select language:"}, // 2
            {"[1] Español", "[1] Spanish"}, // 3
            {"[2] Inglés", "[2] English"}, // 4
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."}, // 5
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"}, // 6
            {"[1] Llenar Matriz Interactivamente", "[1] Fill Matrix Interactively"}, // 7
            {"[2] Finalizar Programa", "[2] End Program"}, // 8
            {"El programa finalizará.", "The program will end."}, // 9

            // Mensajes del Programa
            {"Llenado Interactivo de Matriz 5x5", "Interactive Filling of 5x5 Matrix"}, // 10
            {"Ingrese un valor entero para la posición [%d][%d] (Matriz visible): ", "Enter an integer value for position [%d][%d] (Visible Matrix): "}, // 11
            {"ERROR: Entrada no válida. Debe ser un número entero.", "ERROR: Invalid input. Must be an integer number."}, // 12
            {"¡Matriz 5x5 Completada!", "5x5 Matrix Completed!"}, // 13
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 14
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    // --- Métodos de Menú/Sello (Implementación estándar omitida) ---
    // ... (seleccionarIdioma, mostrarMenuEjecucion, mostrarSelloCorto, mostrarEncabezado) ...

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
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 108 | 2025-10-21";
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
     * Imprime la matriz en formato tabular.
     * b. Una función imprimirá la matriz.
     */
    public static void imprimirMatriz(int[][] matriz) {
        int tamano = UtilidadesMatriz.TAMANO;
        System.out.println("\n  " + "=".repeat(tamano * ANCHO_CELDA));

        // Imprimir encabezado de columnas (j)
        System.out.print("  |");
        for (int j = 0; j < tamano; j++) {
            System.out.printf("%-" + ANCHO_CELDA + "s", "[" + j + "]");
        }
        System.out.println();
        System.out.println("  " + "─".repeat(tamano * ANCHO_CELDA));

        // Imprimir cuerpo (i)
        for (int i = 0; i < tamano; i++) {
            System.out.printf("[%d]|", i); // Encabezado de fila
            for (int j = 0; j < tamano; j++) {
                // Si es cero, usar "-" para diferenciar visualmente los no llenados.
                String valor = (matriz[i][j] == 0) ? "-" : String.valueOf(matriz[i][j]);
                System.out.printf("%-" + ANCHO_CELDA + "s", valor);
            }
            System.out.println();
        }
        System.out.println("  " + "=".repeat(tamano * ANCHO_CELDA));
    }

    /**
     * Solicita y valida el valor entero del usuario.
     */
    public static int leerValor(Scanner scanner, int i, int j) {
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.printf(obtenerTexto(11), i, j);
            try {
                if (scanner.hasNextInt()) {
                    valor = scanner.nextInt();
                    entradaValida = true;
                } else {
                    System.out.println(obtenerTexto(12));
                    scanner.next(); // Limpiar buffer
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(12));
                scanner.next(); // Limpiar buffer
            }
        }
        return valor;
    }
}