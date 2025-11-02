/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 119 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio119;

import java.util.Scanner;

public class Operaciones {

    // === VALIDAR ENTERO POSITIVO ===
    public static int validarEnteroPositivo(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int valor = sc.nextInt(); sc.nextLine();
                if (valor > 0) return valor;
            } else {
                sc.next();
            }
            Utilidades.mostrarError(Utilidades.obtenerTexto("ENTERO_INVALIDO", MiLibrería.getIdioma()), MiLibrería.getIdioma());
        }
    }

    // === VALIDAR MONTO ===
    public static double validarMonto(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double monto = sc.nextDouble(); sc.nextLine();
                if (monto > 0) return monto;
            } else {
                sc.next();
            }
            Utilidades.mostrarError(Utilidades.obtenerTexto("MONTO_INVALIDO", MiLibrería.getIdioma()), MiLibrería.getIdioma());
        }
    }

    // === VALIDAR OPCIÓN DE MENÚ ===
    public static int validarOpcionMenu(Scanner sc, int min, int max) {
        while (true) {
            if (sc.hasNextInt()) {
                int opcion = sc.nextInt(); sc.nextLine();
                if (opcion >= min && opcion <= max) return opcion;
            } else {
                sc.next();
            }
            Utilidades.mostrarError("Opción inválida.", MiLibrería.getIdioma());
        }
    }

    // === VALIDAR FECHA (NUEVA FUNCIÓN) ===
    public static boolean validarFecha(int dia, int mes, int año) {
        if (año < 2020 || año > 2030) return false;
        if (mes < 1 || mes > 12) return false;

        int diasEnMes = switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0) ? 29 : 28;
            default -> 31;
        };

        return dia >= 1 && dia <= diasEnMes;
    }
}