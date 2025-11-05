package Ejercicio116;

import java.util.Random;

public class UtilidadesHospital {

    public static final int NUM_ESPECIALIDADES = 4;
    public static final int NUM_PISOS = 3;
    public static final int NUM_HABITACIONES = 10;
    public static final int NUM_CAMAS = 2;

    public static final String[] NOMBRES_ESPECIALIDADES = {
            "Cardiología", "Neurología", "Pediatría", "Oncología"
    };

    public static String obtenerNombreCardinal(int piso) {
        switch (piso) {
            case 0: return "Primer";
            case 1: return "Segundo";
            case 2: return "Tercer";
            default: return "Desconocido";
        }
    }

    public static void limpiarPantalla() {
        // Reducido a 10 líneas para dejar menos espacio en blanco.
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public static int[][][][] inicializarHospital() {
        return new int[NUM_ESPECIALIDADES][NUM_PISOS][NUM_HABITACIONES][NUM_CAMAS];
    }
}