package Ejercicio028;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 028 | 2025-10-10
 */

import java.util.Scanner;

public class Ejercicio028_Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int idioma;
        do {
            idioma = Ejercicio028_Utilidades.seleccionarIdioma();
            if (idioma == 3) break;

            boolean seguir = true;
            while (seguir) {
                int opcion = Ejercicio028_Utilidades.mostrarMenuPrincipal(idioma);
                switch (opcion) {
                    case 1 -> {
                        int numero = Ejercicio028_Utilidades.leerNumero4Digitos(idioma, "cifrar");
                        String cifrado = Ejercicio028_Operaciones.cifrar(numero);
                        Ejercicio028_Utilidades.mostrarResultado(idioma, "cifrado", numero, cifrado);
                    }
                    case 2 -> {
                        int numero = Ejercicio028_Utilidades.leerNumero4Digitos(idioma, "descifrar");
                        String descifrado = Ejercicio028_Operaciones.descifrar(numero);
                        Ejercicio028_Utilidades.mostrarResultado(idioma, "descifrado", numero, descifrado);
                    }
                    case 3 -> seguir = false;
                    case 4 -> {
                        idioma = 3;
                        seguir = false;
                    }
                }
            }
        } while (idioma != 3);

        Ejercicio028_Utilidades.mostrarDespedida(idioma);
        scanner.close();
    }
}