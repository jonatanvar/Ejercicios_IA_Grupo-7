/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 115 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio115;

import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static int[][][] hospital = new int[4][3][10]; // [especialidad][piso][habitación]
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // === INICIALIZACIÓN ===
    public static void inicializarHospital() {
        for (int e = 0; e < 4; e++)
            for (int p = 0; p < 3; p++)
                for (int h = 0; h < 10; h++)
                    hospital[e][p][h] = 0; // 0 = libre
    }

    // === PROCESO PRINCIPAL ===
    public static void iniciarPrograma(Scanner sc) {
        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(sc);
        inicializarHospital();

        do {
            Menús.mostrarMenuPrincipal();
            int opcion = Operaciones.leerOpcion(sc, 0, 5);
            switch (opcion) {
                case 1 -> Operaciones.consultarLibresPorEspecialidad(sc);
                case 2 -> Operaciones.consultarPorPiso(sc);
                case 3 -> Operaciones.asignarHabitacion(sc);
                case 4 -> Operaciones.liberarHabitacion(sc);
                case 5 -> Operaciones.mostrarTablaOcupadas();
                case 0 -> continuar = false;
            }
        } while (continuar);
    }

    // === GETTERS ===
    public static int[][][] getHospital() { return hospital; }
    public static void setHabitacion(int e, int p, int h, int exp) { hospital[e][p][h] = exp; }
    public static String getIdioma() { return idiomaActual; }
}