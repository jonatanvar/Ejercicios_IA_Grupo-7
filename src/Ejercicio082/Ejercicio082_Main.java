package Ejercicio082;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 082 | 2025-11-04
 */

import java.util.Scanner;

public class Ejercicio082_Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int idioma;
        do {
            idioma = Ejercicio082_Utilidades.seleccionarIdioma();
            if (idioma == 3) break;

            boolean continuar = true;
            while (continuar) {
                int opcion = Ejercicio082_Utilidades.mostrarMenuPrincipal(idioma);
                switch (opcion) {
                    case 1 -> {
                        int lado = Ejercicio082_Utilidades.leerLado(idioma);
                        char caracter = Ejercicio082_Utilidades.leerCaracter(idioma);
                        Ejercicio082_Operaciones.dibujarCuadradoConLibreria(lado, caracter, idioma);
                        continuar = Ejercicio082_Utilidades.preguntarContinuar(idioma);
                    }
                    case 2 -> continuar = false;
                    case 3 -> {
                        idioma = 3;
                        continuar = false;
                    }
                }
            }
        } while (idioma != 3);

        Ejercicio082_Utilidades.mostrarDespedida(idioma);
        scanner.close();
    }
}
