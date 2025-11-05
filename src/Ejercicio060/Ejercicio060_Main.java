package Ejercicio060;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 060 | 2025-11-04
 */

import java.util.Scanner;

public class Ejercicio060_Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int idioma;
        do {
            idioma = Ejercicio060_Utilidades.seleccionarIdioma();
            if (idioma == 3) break;

            boolean continuar = true;
            while (continuar) {
                int opcion = Ejercicio060_Utilidades.mostrarMenuPrincipal(idioma);
                switch (opcion) {
                    case 1 -> {
                        int lado = Ejercicio060_Utilidades.leerLado(idioma);
                        char caracter = Ejercicio060_Utilidades.leerCaracter(idioma);
                        Ejercicio060_Operaciones.dibujarCuadrado(lado, caracter, idioma);
                        continuar = Ejercicio060_Utilidades.preguntarContinuar(idioma);
                    }
                    case 2 -> continuar = false;
                    case 3 -> {
                        idioma = 3;
                        continuar = false;
                    }
                }
            }
        } while (idioma != 3);

        Ejercicio060_Utilidades.mostrarDespedida(idioma);
        scanner.close();
    }
}