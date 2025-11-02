package Ejercicio115;

import java.util.Scanner;

public class Menús {
    private static final int ANCHO = 70;

    public static void mostrarMenuPrincipal() {
        System.out.println("\n┌" + "═".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("SISTEMA DE SALUD DE LATVERIA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ 1. Consultar libres por especialidad" + " ".repeat(ANCHO - 39) + "│");
        System.out.println("│ 2. Consultar por piso" + " ".repeat(ANCHO - 24) + "│");
        System.out.println("│ 3. Asignar habitación" + " ".repeat(ANCHO - 24) + "│");
        System.out.println("│ 4. Liberar habitación" + " ".repeat(ANCHO - 24) + "│");
        System.out.println("│ 5. Tabla de ocupadas" + " ".repeat(ANCHO - 23) + "│");
        System.out.println("│ 0. Salir" + " ".repeat(ANCHO - 11) + "│");
        System.out.println("└" + "═".repeat(ANCHO - 2) + "┘");
        System.out.print("Opción: ");
    }

    public static String seleccionarIdioma(Scanner sc) {
        int op;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + Utilidades.centrar("SELECCIÓN DE IDIOMA", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            System.out.println("│ 1. Español" + " ".repeat(ANCHO - 13) + "│");
            System.out.println("│ 2. English" + " ".repeat(ANCHO - 13) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione: ");
            if (sc.hasNextInt()) {
                op = sc.nextInt(); sc.nextLine();
                if (op == 1 || op == 2) return op == 1 ? "ES" : "EN";
            } else sc.nextLine();
            Utilidades.mostrarError("Opción inválida.");
        } while (true);
    }
}