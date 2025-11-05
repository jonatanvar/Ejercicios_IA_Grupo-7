package Ejercicio116;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 116 | 2025-10-22
 */
public class Ejercicio116_Funciones {

    private static final int VACIA = 0;

    /**
     * Asigna un paciente a una cama específica.
     * @param hospital Matriz 4D.
     * @param esp Especialidad (0-3).
     * @param piso Piso (0-2).
     * @param hab Habitación (0-9).
     * @param cama Cama (0-1).
     * @param expediente Número de expediente del paciente (> 0).
     * @return true si la asignación fue exitosa (cama estaba vacía), false si ya estaba ocupada.
     */
    public static boolean asignarCama(int[][][][] hospital, int esp, int piso, int hab, int cama, int expediente) {
        // c. Obviamente solo pueden asignarse camas vacías.
        if (hospital[esp][piso][hab][cama] == VACIA) {
            hospital[esp][piso][hab][cama] = expediente;
            return true;
        }
        return false;
    }

    /**
     * Libera una cama específica, asignando 0 (VACIA).
     * @param hospital Matriz 4D.
     * @param esp Especialidad (0-3).
     * @param piso Piso (0-2).
     * @param hab Habitación (0-9).
     * @param cama Cama (0-1).
     * @return true si la cama se liberó (estaba ocupada), false si ya estaba vacía.
     */
    public static boolean liberarCama(int[][][][] hospital, int esp, int piso, int hab, int cama) {
        // d. Liberar cama
        if (hospital[esp][piso][hab][cama] != VACIA) {
            hospital[esp][piso][hab][cama] = VACIA;
            return true;
        }
        return false;
    }

    /**
     * Imprime un reporte detallado de todas las camas libres por una especialidad elegida.
     * @param hospital Matriz 4D.
     * @param esp Especialidad (0-3).
     */
    public static void consultarCamasPorEspecialidad(int[][][][] hospital, int esp) {
        // a. Consultar camas libres por especialidad
        System.out.println("\n--- ESPECIALIDAD: " + UtilidadesHospital.NOMBRES_ESPECIALIDADES[esp] + " ---");

        // Ciclos anidados para recorrer Pisos, Habitaciones y Camas
        for (int p = 0; p < UtilidadesHospital.NUM_PISOS; p++) {
            System.out.println("PISO " + UtilidadesHospital.obtenerNombreCardinal(p).toUpperCase() + ":");
            for (int h = 0; h < UtilidadesHospital.NUM_HABITACIONES; h++) {

                String estadoCama1 = (hospital[esp][p][h][0] == VACIA) ? "LIBRE" : "OCUPADA";
                String estadoCama2 = (hospital[esp][p][h][1] == VACIA) ? "LIBRE" : "OCUPADA";

                System.out.printf("  Habitación %02d: Cama 1 [%s], Cama 2 [%s]%n", (h + 1), estadoCama1, estadoCama2);
            }
        }
    }

    /**
     * Imprime una tabla con todas las camas actualmente ocupadas.
     * @param hospital Matriz 4D.
     */
    public static void mostrarTablaCamasOcupadas(int[][][][] hospital) {
        // e. Mostrar tabla de camas ocupadas
        System.out.println("\n--- REPORTE DE OCUPACIÓN HOSPITALARIA ---");

        final int ANCHO = 15;
        System.out.printf("%-" + ANCHO + "s|%-" + ANCHO + "s|%-" + ANCHO + "s|%-" + ANCHO + "s|%s%n",
                "Especialidad", "Piso", "Habitación", "Cama", "Paciente");
        System.out.println("─".repeat(ANCHO * 4 + 4 + 10));

        // Ciclos anidados para recorrer las 4 dimensiones
        for (int e = 0; e < UtilidadesHospital.NUM_ESPECIALIDADES; e++) {
            for (int p = 0; p < UtilidadesHospital.NUM_PISOS; p++) {
                for (int h = 0; h < UtilidadesHospital.NUM_HABITACIONES; h++) {
                    for (int c = 0; c < UtilidadesHospital.NUM_CAMAS; c++) {

                        int paciente = hospital[e][p][h][c];
                        if (paciente != VACIA) {
                            // Imprimir solo camas ocupadas
                            System.out.printf("%-" + ANCHO + "s|%-" + ANCHO + "s|%-" + ANCHO + "d|%-" + ANCHO + "d|%d%n",
                                    UtilidadesHospital.NOMBRES_ESPECIALIDADES[e],
                                    UtilidadesHospital.obtenerNombreCardinal(p),
                                    (h + 1), // Habitación 1 a 10
                                    (c + 1), // Cama 1 o 2
                                    paciente);
                        }
                    }
                }
            }
        }
    }
}