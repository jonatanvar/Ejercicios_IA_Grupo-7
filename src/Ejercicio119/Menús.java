/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 119 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio119;

import java.util.Scanner;

public class Menús {

    private static final int ANCHO = 70;

    public static void mostrarMenuPrincipal() {
        System.out.println("\n╔" + "═".repeat(ANCHO - 2) + "╗");
        System.out.println("║" + Utilidades.centrarTexto("CLÍNICA DE NUTRICIÓN - MENÚ PRINCIPAL", ANCHO - 2) + "║");
        System.out.println("╠" + "═".repeat(ANCHO - 2) + "╣");
        System.out.println("║  1. Gestión de Pacientes" + " ".repeat(ANCHO - 27) + "║");
        System.out.println("║  2. Realizar Consulta" + " ".repeat(ANCHO - 24) + "║");
        System.out.println("║  3. Registrar Pago" + " ".repeat(ANCHO - 21) + "║");
        System.out.println("║  4. Estadísticas" + " ".repeat(ANCHO - 19) + "║");
        System.out.println("║  0. Salir" + " ".repeat(ANCHO - 12) + "║");
        System.out.println("╚" + "═".repeat(ANCHO - 2) + "╝");
        System.out.print("Seleccione una opción: ");
    }

    public static void gestionPacientes(Scanner sc) {
        boolean volver = false;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + Utilidades.centrarTexto("GESTIÓN DE PACIENTES", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            System.out.println("│ a) Agregar nuevo paciente" + " ".repeat(ANCHO - 28) + "│");
            System.out.println("│ b) Buscar paciente por expediente" + " ".repeat(ANCHO - 36) + "│");
            System.out.println("│ c) Modificar datos de paciente" + " ".repeat(ANCHO - 33) + "│");
            System.out.println("│ d) Listar todos los pacientes" + " ".repeat(ANCHO - 32) + "│");
            System.out.println("│ e) Volver al menú principal" + " ".repeat(ANCHO - 30) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione una opción (a-e): ");
            String opcion = sc.nextLine().toLowerCase();

            switch (opcion) {
                case "a" -> MiLibrería.crearPaciente(sc);
                case "b" -> MiLibrería.buscarPaciente(sc);
                case "c" -> MiLibrería.modificarPaciente(sc);
                case "d" -> MiLibrería.listarPacientes();
                case "e" -> volver = true;
                default -> Utilidades.mostrarError("Opción inválida.", MiLibrería.getIdioma());
            }
        } while (!volver);
    }

    public static void estadisticas(Scanner sc) {
        boolean volver = false;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + Utilidades.centrarTexto("ESTADÍSTICAS", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            System.out.println("│ a) Estadísticas por sexo" + " ".repeat(ANCHO - 27) + "│");
            System.out.println("│ b) Estadísticas por diagnóstico" + " ".repeat(ANCHO - 34) + "│");
            System.out.println("│ c) Listado de deudores" + " ".repeat(ANCHO - 25) + "│");
            System.out.println("│ d) Volver al menú principal" + " ".repeat(ANCHO - 30) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione una opción (a-d): ");
            String opcion = sc.nextLine().toLowerCase();

            switch (opcion) {
                case "a" -> MiLibrería.estadisticasPorSexo();
                case "b" -> MiLibrería.estadisticasPorDiagnostico();
                case "c" -> MiLibrería.mostrarDeudores();
                case "d" -> volver = true;
                default -> Utilidades.mostrarError("Opción inválida.", MiLibrería.getIdioma());
            }
        } while (!volver);
    }

    public static String seleccionarIdioma(Scanner sc) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + Utilidades.centrarTexto("SELECCIONE IDIOMA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ 1. Español" + " ".repeat(ANCHO - 14) + "│");
        System.out.println("│ 2. English" + " ".repeat(ANCHO - 14) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
        int op = Operaciones.validarOpcionMenu(sc, 1, 2);
        return op == 1 ? "ES" : "EN";
    }
}