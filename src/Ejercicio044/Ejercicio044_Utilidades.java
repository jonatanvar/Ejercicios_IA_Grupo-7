package Ejercicio044;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 044 | 2025-10-16
 */
public class Ejercicio044_Utilidades {

    private static final int ANCHO_SELLO = 70;

    // --- Sello ---
    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 044 | 2025-10-16";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    // --- Menú de Ejecución (Simplificado sin idioma) ---
    public static boolean mostrarMenuEjecucion(Scanner scanner) {
        int opcion = 0;
        while (opcion != 1 && opcion != 2) {
            System.out.println("\n--- MENÚ DE EJECUCIÓN ---");
            System.out.println("[1] Iniciar Sistema de Menús");
            System.out.println("[2] Finalizar Programa");
            System.out.print(">");
            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 2) {
                        System.out.println("El programa finalizará.");
                        return false;
                    } else if (opcion != 1) {
                        System.out.println("Opción no válida. Intente de nuevo.");
                    }
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Intente de nuevo.");
                scanner.next();
            }
        }
        return true;
    }
}