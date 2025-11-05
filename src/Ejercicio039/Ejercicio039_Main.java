package Ejercicio039;

/*
 * Cristina Cruz | Lis❤  | cristinacruz@unah.hn | 039 | 2025-10-10
 */

import java.util.Scanner;

public class Ejercicio039_Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int idioma;
        do {
            idioma = Ejercicio039_Utilidades.seleccionarIdioma();
            if (idioma == 3) break;

            boolean seguir = true;
            while (seguir) {
                int opcion = Ejercicio039_Utilidades.mostrarMenuEjecucion(idioma);
                switch (opcion) {
                    case 1 -> {
                        int filas = Ejercicio039_Utilidades.leerNumeroImpar(idioma, 1, 19);
                        Ejercicio039_Operaciones.imprimirRombo(filas, idioma);
                    }
                    case 2 -> seguir = false;
                    case 3 -> {
                        idioma = 3;
                        seguir = false;
                    }
                }
            }
        } while (idioma != 3);

        Ejercicio039_Utilidades.mostrarDespedida(idioma);
        scanner.close();
    }
}