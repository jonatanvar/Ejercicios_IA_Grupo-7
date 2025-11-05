package Ejercicio116;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio116_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";
    private static final int VACIA = 0;

    private static String[][] textos = {
            {"es", "en"},
            {"*** BIENVENIDO ***", "*** WELCOME ***"},
            {"Seleccione el idioma:", "Select language:"},
            {"[1] Español", "[1] Spanish"},
            {"[2] Inglés", "[2] English"},
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."},
            {"--- MENÚ PRINCIPAL ---", "--- MAIN MENU ---"},
            {"[1] Consultar Camas Libres por Especialidad", "[1] Consult Free Beds by Specialty"},
            {"[2] Consultar Camas por Piso/Especialidad", "[2] Consult Beds by Floor/Specialty"},
            {"[3] Asignar Paciente (Ocupar Cama)", "[3] Assign Patient (Occupy Bed)"},
            {"[4] Liberar Cama", "[4] Free Bed"},
            {"[5] Mostrar Tabla de Camas Ocupadas", "[5] Show Occupied Beds Table"},
            {"[6] Finalizar Programa", "[6] End Program"},
            {"El programa finalizará.", "The program will end."},

            {"Sistema de Gestión Hospitalaria (Hospital Latveria)", "Hospital Management System (Latveria Hospital)"},
            {"Ingrese el número de la Especialidad (1-" + UtilidadesHospital.NUM_ESPECIALIDADES + "): ", "Enter the Specialty number (1-" + UtilidadesHospital.NUM_ESPECIALIDADES + "): "},
            {"ERROR: Especialidad fuera de rango (1-" + UtilidadesHospital.NUM_ESPECIALIDADES + ").", "ERROR: Specialty out of range (1-" + UtilidadesHospital.NUM_ESPECIALIDADES + ")."},
            {"Ingrese el número del Piso (1-" + UtilidadesHospital.NUM_PISOS + "): ", "Enter the Floor number (1-" + UtilidadesHospital.NUM_PISOS + "): "},
            {"ERROR: Piso fuera de rango (1-" + UtilidadesHospital.NUM_PISOS + ").", "ERROR: Floor out of range (1-" + UtilidadesHospital.NUM_PISOS + ")."},
            {"Ingrese el número de Habitación (1-" + UtilidadesHospital.NUM_HABITACIONES + "): ", "Enter the Room number (1-" + UtilidadesHospital.NUM_HABITACIONES + "): "},
            {"ERROR: Habitación fuera de rango (1-" + UtilidadesHospital.NUM_HABITACIONES + ").", "ERROR: Room out of range (1-" + UtilidadesHospital.NUM_HABITACIONES + ")."},
            {"Ingrese el número de Cama (1 o 2): ", "Enter the Bed number (1 or 2): "},
            {"ERROR: Cama fuera de rango (1 o 2).", "ERROR: Bed out of range (1 or 2)."},
            {"Ingrese el número de Expediente (máx. 3 cifras): ", "Enter the Patient Record number (max. 3 digits): "},
            {"ERROR: Expediente no válido. Máximo 999.", "ERROR: Invalid Record. Maximum 999."},
            {"ASIGNACIÓN FALLIDA: La cama ya está OCUPADA por el paciente %d.", "ASSIGNMENT FAILED: Bed is already OCCUPIED by patient %d."},
            {"ASIGNACIÓN EXITOSA: Paciente %d asignado a %s, Piso %s, Habitación %d, Cama %d.", "ASSIGNMENT SUCCESSFUL: Patient %d assigned to %s, %s Floor, Room %d, Bed %d."},
            {"LIBERACIÓN FALLIDA: La cama ya está VACÍA.", "FREEING FAILED: Bed is already EMPTY."},
            {"LIBERACIÓN EXITOSA: Cama liberada en %s, Piso %s, Habitación %d, Cama %d.", "FREEING SUCCESSFUL: Bed freed in %s, %s Floor, Room %d, Bed %d."},
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."},
            {"Especialidades Disponibles:", "Available Specialties:"},
            {"%d: %s%n", "%d: %s%n"},
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    public static void mostrarEspecialidades() {
        System.out.println(obtenerTexto(30));
        String[] nombres = UtilidadesHospital.NOMBRES_ESPECIALIDADES;
        for (int i = 0; i < UtilidadesHospital.NUM_ESPECIALIDADES; i++) {
            System.out.printf(obtenerTexto(31), i + 1, nombres[i]);
        }
    }

    public static int leerEntero(Scanner scanner, int min, int max, int msgIndex, int errIndex) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print(obtenerTexto(msgIndex));
            try {
                if (scanner.hasNextInt()) {
                    valor = scanner.nextInt();
                    if (valor >= min && valor <= max) {
                        valido = true;
                    } else {
                        System.out.println(obtenerTexto(errIndex));
                    }
                } else {
                    System.out.println(obtenerTexto(errIndex));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(errIndex));
                scanner.next();
            }
        }
        scanner.nextLine();
        return valor;
    }

    public static int leerEspecialidad(Scanner scanner) {
        mostrarEspecialidades();
        return leerEntero(scanner, 1, UtilidadesHospital.NUM_ESPECIALIDADES, 15, 16);
    }

    public static int leerPiso(Scanner scanner) {
        return leerEntero(scanner, 1, UtilidadesHospital.NUM_PISOS, 17, 18);
    }
    public static int leerHabitacion(Scanner scanner) {
        return leerEntero(scanner, 1, UtilidadesHospital.NUM_HABITACIONES, 19, 20);
    }
    public static int leerCama(Scanner scanner) {
        return leerEntero(scanner, 1, UtilidadesHospital.NUM_CAMAS, 21, 22);
    }
    public static int leerExpediente(Scanner scanner) {
        return leerEntero(scanner, 1, 999, 23, 24);
    }

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
        scanner.nextLine();
    }

    public static int mostrarMenuEjecucion(Scanner scanner) {
        int opcion = -1;
        while (opcion < 1 || opcion > 6) {
            // Se elimina el \n inicial para reducir el espacio en blanco.
            System.out.println(obtenerTexto(6));
            System.out.println(obtenerTexto(7));
            System.out.println(obtenerTexto(8));
            System.out.println(obtenerTexto(9));
            System.out.println(obtenerTexto(10));
            System.out.println(obtenerTexto(11));
            System.out.println(obtenerTexto(12));
            System.out.print(">");
            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion < 1 || opcion > 6) {
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
        scanner.nextLine();
        return opcion;
    }

    public static void mostrarSelloCorto() {
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 116 | 2025-10-22";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    public static void mostrarEncabezado() {
        // Se elimina el \n inicial
        System.out.println("--- " + obtenerTexto(14) + " ---");
    }

    public static void mostrarMatrizPiso(int[][][][] hospital, int esp, int piso) {
        int habitaciones = UtilidadesHospital.NUM_HABITACIONES;
        int camas = UtilidadesHospital.NUM_CAMAS;

        System.out.printf("\n--- Ocupación: %s | Piso %s ---%n",
                UtilidadesHospital.NOMBRES_ESPECIALIDADES[esp],
                UtilidadesHospital.obtenerNombreCardinal(piso));

        System.out.print("Cama |");
        for (int h = 0; h < habitaciones; h++) {
            System.out.printf(" Hab %02d |", h + 1);
        }
        System.out.println();
        System.out.println("─".repeat(habitaciones * 9 + 5));

        for (int c = 0; c < camas; c++) {
            System.out.printf("  %d  |", c + 1);
            for (int h = 0; h < habitaciones; h++) {
                int paciente = hospital[esp][piso][h][c];
                String valor = (paciente == 0) ? "LIBRE" : String.valueOf(paciente);
                System.out.printf(" %5s |", valor);
            }
            System.out.println();
        }
        System.out.println("─".repeat(habitaciones * 9 + 5));
    }
}