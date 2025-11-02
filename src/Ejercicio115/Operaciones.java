package Ejercicio115;

import java.util.Scanner;

public class Operaciones {
    private static final String[] ESPECIALIDADES = {
            "Cirugía general", "Ginecología y obstetricia", "Medicina interna", "Nefrología"
    };
    private static final int[][] PISOS = {{2,3,4}, {5,6,7}, {8,9,10}, {11,12,13}};
    private static final int ANCHO = 70;

    // === OPCIÓN 1 ===
    public static void consultarLibresPorEspecialidad(Scanner sc) {
        int e = seleccionarEspecialidad(sc);
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("LIBRES - " + ESPECIALIDADES[e], ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int p = 0; p < 3; p++) {
            int piso = PISOS[e][p];
            StringBuilder sb = new StringBuilder("│ Piso " + piso + ": ");
            int libres = 0;
            for (int h = 0; h < 10; h++) {
                if (MiLibrería.getHospital()[e][p][h] == 0) {
                    sb.append(h + 1).append(" ");
                    libres++;
                }
            }
            if (libres == 0) sb.append("Todas ocupadas");
            System.out.println(sb + " ".repeat(ANCHO - sb.length() - 1) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // === OPCIÓN 2 ===
    public static void consultarPorPiso(Scanner sc) {
        int e = seleccionarEspecialidad(sc);
        int p = seleccionarPiso(sc, e);
        int piso = PISOS[e][p];
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("PISO " + piso + " - " + ESPECIALIDADES[e], ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int h = 0; h < 10; h++) {
            int exp = MiLibrería.getHospital()[e][p][h];
            String estado = exp == 0 ? "Libre" : String.format("%03d", exp);
            System.out.println("│ Hab. " + (h + 1) + " → " + estado + " ".repeat(ANCHO - 20 - estado.length()) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // === OPCIÓN 3 ===
    public static void asignarHabitacion(Scanner sc) {
        int e = seleccionarEspecialidad(sc);
        int p = seleccionarPiso(sc, e);
        int h = seleccionarHabitacion(sc);
        if (MiLibrería.getHospital()[e][p][h - 1] != 0) {
            Utilidades.mostrarError("Habitación ocupada.");
            return;
        }
        int exp = pedirExpediente(sc);
        MiLibrería.setHabitacion(e, p, h - 1, exp);
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("ASIGNACIÓN EXITOSA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Paciente " + String.format("%03d", exp) + " → " + ESPECIALIDADES[e] + " ".repeat(10) + "│");
        System.out.println("│ Piso " + PISOS[e][p] + ", Habitación " + h + " ".repeat(ANCHO - 30) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // === OPCIÓN 4 ===
    public static void liberarHabitacion(Scanner sc) {
        int e = seleccionarEspecialidad(sc);
        int p = seleccionarPiso(sc, e);
        int h = seleccionarHabitacion(sc);
        if (MiLibrería.getHospital()[e][p][h - 1] == 0) {
            Utilidades.mostrarError("Habitación ya libre.");
            return;
        }
        MiLibrería.setHabitacion(e, p, h - 1, 0);
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("HABITACIÓN LIBERADA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Piso " + PISOS[e][p] + ", Habitación " + h + " ".repeat(ANCHO - 30) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // === OPCIÓN 5 ===
    public static void mostrarTablaOcupadas() {
        System.out.println("\n┌" + "═".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("HABITACIONES OCUPADAS", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Especialidad            | Piso | Hab. | Paciente │");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        boolean hay = false;
        for (int e = 0; e < 4; e++) {
            for (int p = 0; p < 3; p++) {
                for (int h = 0; h < 10; h++) {
                    int exp = MiLibrería.getHospital()[e][p][h];
                    if (exp != 0) {
                        hay = true;
                        String linea = String.format("│ %-23s | %4d | %4d | %8s │",
                                ESPECIALIDADES[e].substring(0, Math.min(23, ESPECIALIDADES[e].length())),
                                PISOS[e][p], h + 1, String.format("%03d", exp));
                        System.out.println(linea);
                    }
                }
            }
        }
        if (!hay) System.out.println("│" + Utilidades.centrar("No hay habitaciones ocupadas", ANCHO - 2) + "│");
        System.out.println("└" + "═".repeat(ANCHO - 2) + "┘");
    }

    // === UTILIDADES DE ENTRADA ===
    public static int seleccionarEspecialidad(Scanner sc) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("SELECCIONE ESPECIALIDAD", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 4; i++) {
            System.out.println("│ " + (i + 1) + ". " + ESPECIALIDADES[i] + " ".repeat(ANCHO - 5 - ESPECIALIDADES[i].length() - 3) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
        return leerOpcion(sc, 1, 4) - 1;
    }

    public static int seleccionarPiso(Scanner sc, int e) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrar("PISOS DE " + ESPECIALIDADES[e].toUpperCase(), ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 3; i++) {
            System.out.println("│ " + (i + 1) + ". Piso " + PISOS[e][i] + " ".repeat(ANCHO - 12) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
        return leerOpcion(sc, 1, 3) - 1;
    }

    public static int seleccionarHabitacion(Scanner sc) {
        System.out.print("Ingrese número de habitación (1-10): ");
        return leerOpcion(sc, 1, 10);
    }

    public static int pedirExpediente(Scanner sc) {
        System.out.print("Ingrese expediente del paciente (1-999): ");
        return leerOpcion(sc, 1, 999);
    }

    public static int leerOpcion(Scanner sc, int min, int max) {
        int op;
        while (true) {
            if (sc.hasNextInt()) {
                op = sc.nextInt(); sc.nextLine();
                if (op >= min && op <= max) return op;
            } else sc.nextLine();
            Utilidades.mostrarError("Opción inválida. Intente de nuevo.");
        }
    }
}