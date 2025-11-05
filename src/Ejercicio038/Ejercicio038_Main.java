package Ejercicio038;

/*
 * Cristina Cruz | Lis❤  | cristinacruz@unah.hn | 038 | 2025-10-10
 */

import java.util.Scanner;

public class Ejercicio038_Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int idioma;
        do {
            idioma = Ejercicio038_Utilidades.seleccionarIdioma();
            if (idioma == 3) break;

            boolean seguir = true;
            while (seguir) {
                int opcion = Ejercicio038_Utilidades.mostrarMenuEjecucion(idioma);
                switch (opcion) {
                    case 1 -> Ejercicio038_Operaciones.imprimirRombo(idioma);
                    case 2 -> seguir = false;           // Volver al menú de idioma
                    case 3 -> {                         // Salir del programa
                        idioma = 3;
                        seguir = false;
                    }
                }
            }
        } while (idioma != 3);

        Ejercicio038_Utilidades.mostrarDespedida(idioma);
        scanner.close();
    }
}