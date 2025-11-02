/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 056 | 2025-10-15               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio056;

import java.util.Scanner;

public class Main {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(scanner);

        do {
            ejecutarEjercicio(scanner, idiomaActual);
            continuar = Menús.preguntarContinuar(scanner, idiomaActual);
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(Scanner scanner, String idioma) {
        String[] nombresCompletos = new String[5];
        for (int i = 0; i < 5; i++) {
            String nombre = Operaciones.leerYValidarNombre(scanner, idioma, i + 1);
            String apellido = Operaciones.leerYValidarApellido(scanner, idioma, i + 1);
            nombresCompletos[i] = nombre + " " + apellido;
        }
        Utilidades.mostrarNombres(nombresCompletos, idioma);
    }
}