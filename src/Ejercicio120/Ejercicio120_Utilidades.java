package Ejercicio120;

import java.util.Scanner;

public class Ejercicio120_Utilidades {
    private static final String LINEA_SUP = "---------------------------------------------------------------------";
    private static final String LINEA_SEP = "|                                                                   |";
    private static final String LINEA_INF = "---------------------------------------------------------------------";
    private static final int ANCHO = 68;
    private static int idioma = 1;

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotales = ancho - texto.length();
        int izq = espaciosTotales / 2;
        int der = espaciosTotales - izq;
        return "|" + " ".repeat(izq) + texto + " ".repeat(der) + "|";
    }

    public static void mostrarSelloCorto() {
        System.out.println(LINEA_SUP);
        System.out.println(centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO));
        System.out.println(LINEA_SEP);
        String sello = "Cristina Cruz | Lis | cristinacruz@unah.hn | 120 | 2025-10-23";
        System.out.println(centrarTexto(sello, ANCHO));
        System.out.println(LINEA_INF);
        System.out.println();
    }

    public static void seleccionarIdioma(Scanner sc) {
        System.out.println("Seleccione el idioma / Select language:");
        System.out.println("1. Español");
        System.out.println("2. English");
        int op = leerEntero(sc, "Opción / Option: ");
        idioma = (op == 1 || op == 2) ? op : 1;
    }

    public static boolean mostrarMenuEjecucion(Scanner sc) {
        System.out.println(obtenerTexto(1));
        System.out.println(obtenerTexto(2));
        System.out.println(obtenerTexto(3));
        int op = leerEntero(sc, obtenerTexto(4));
        return op == 1;
    }

    public static int leerEntero(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println(obtenerTexto(5));
                sc.nextLine();
            }
        }
    }

    public static double leerDouble(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.println(obtenerTexto(5));
                sc.nextLine();
            }
        }
    }

    public static int leerEnteroRango(Scanner sc, String msg, int min, int max) {
        int v;
        while (true) {
            v = leerEntero(sc, msg);
            if (v >= min && v <= max) return v;
            System.out.printf(obtenerTexto(6), min, max);
        }
    }

    public static double leerDoublePositivo(Scanner sc, String msg) {
        double v;
        while (true) {
            v = leerDouble(sc, msg);
            if (v >= 0) return v;
            System.out.println(obtenerTexto(7));
        }
    }

    public static void mostrarEncabezado() {
        System.out.println(obtenerTexto(10));
    }

    public static void mostrarMenuPrincipal() {
        System.out.println(obtenerTexto(11));
        System.out.println(obtenerTexto(12));
        System.out.println(obtenerTexto(13));
        System.out.println(obtenerTexto(14));
    }

    public static void mostrarEstadisticas(Paciente[] pacientes, int numPac,
                                           ExpedientePago[] expPag, int numExp) {
        System.out.println(obtenerTexto(15));
        System.out.println("-".repeat(70));
        System.out.printf("%-12s%-20s%-6s%-30s%n", "Expediente", "Nombre", "Sexo", "Diagnóstico");
        for (int i = 0; i < numPac; i++) {
            Paciente p = pacientes[i];
            System.out.printf("%-12d%-20s%-6c%-30s%n", p.expediente, p.nombre, p.sexo, p.diagnostico);
        }
        System.out.println();

        System.out.println(obtenerTexto(16));
        System.out.println("-".repeat(80));
        System.out.printf("%-12s%-20s%-12s%-12s%n", "Expediente", "Nombre", "Pagado", "Pendiente");
        Ejercicio120_Funciones.ordenarDeudores(expPag, numExp);
        for (int i = 0; i < numExp; i++) {
            ExpedientePago ep = expPag[i];
            if (ep.pendiente > 0) {
                int idxPac = Ejercicio120_Funciones.buscarPaciente(pacientes, ep.expediente, numPac);
                String nombre = idxPac >= 0 ? pacientes[idxPac].nombre : "???";
                System.out.printf("%-12d%-20s%-12.2f%-12.2f%n",
                        ep.expediente, nombre, ep.pagado, ep.pendiente);
            }
        }
    }

    public static String obtenerTexto(int id) {
        return switch (id) {
            case 1  -> idioma == 1 ? "Menú de ejecución:\n" : "Execution menu:\n";
            case 2  -> idioma == 1 ? "1. Ejecutar\n" : "1. Run\n";
            case 3  -> idioma == 1 ? "2. Finalizar\n" : "2. Exit\n";
            case 4  -> idioma == 1 ? "Opción: " : "Option: ";
            case 5  -> idioma == 1 ? "Error: Ingrese un número válido.\n" : "Error: Enter a valid number.\n";
            case 6  -> idioma == 1 ? "Error: Debe estar entre %d y %d.\n" : "Error: Must be between %d and %d.\n";
            case 7  -> idioma == 1 ? "Error: Valor no negativo.\n" : "Error: Non-negative value.\n";
            case 10 -> idioma == 1 ? "Sistema de gestión de consultas\n" : "Consultation management system\n";
            case 11 -> idioma == 1 ? "1. Registrar consulta\n" : "1. Register consultation\n";
            case 12 -> idioma == 1 ? "2. Abonar a deuda\n" : "2. Pay debt\n";
            case 13 -> idioma == 1 ? "3. Mostrar estadísticas\n" : "3. Show statistics\n";
            case 14 -> idioma == 1 ? "4. Salir\n" : "4. Exit\n";
            case 15 -> idioma == 1 ? "Listado de pacientes:\n" : "Patient list:\n";
            case 16 -> idioma == 1 ? "Deudores (mayor a menor deuda):\n" : "Debtors (largest to smallest debt):\n";
            case 20 -> idioma == 1 ? "Expediente del paciente: " : "Patient ID: ";
            case 21 -> idioma == 1 ? "Año de la consulta: " : "Consultation year: ";
            case 22 -> idioma == 1 ? "Mes (1-12): " : "Month (1-12): ";
            case 23 -> idioma == 1 ? "Día (1-31): " : "Day (1-31): ";
            case 24 -> idioma == 1 ? "Valor de la consulta: " : "Consultation fee: ";
            case 25 -> idioma == 1 ? "Monto pagado en esta consulta (0 si nada): " : "Amount paid in this consultation (0 if none): ";
            case 26 -> idioma == 1 ? "Monto a abonar: " : "Amount to pay: ";
            case 30 -> idioma == 1 ? "Programa finalizado. Gracias.\n" : "Program terminated. Thank you.\n";
            default -> "";
        };
    }
}