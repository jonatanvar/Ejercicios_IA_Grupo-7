package Ejercicio049;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 049 | 2025-11-04
 */

import java.util.Scanner;

public class Ejercicio049_Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int idioma;
        do {
            idioma = Ejercicio049_Utilidades.seleccionarIdioma();
            if (idioma == 3) break;

            boolean seguir = true;
            while (seguir) {
                int opcion = Ejercicio049_Utilidades.mostrarMenuPrincipal(idioma);
                switch (opcion) {
                    case 1 -> {
                        int numero = Ejercicio049_Utilidades.leerNumero4Digitos(idioma, "cifrar");
                        String cifrado = Ejercicio049_Operaciones.cifrar(numero);
                        Ejercicio049_Utilidades.mostrarResultado(idioma, "cifrado", numero, cifrado);
                    }
                    case 2 -> {
                        int numero = Ejercicio049_Utilidades.leerNumero4Digitos(idioma, "descifrar");
                        String descifrado = Ejercicio049_Operaciones.descifrar(numero);
                        Ejercicio049_Utilidades.mostrarResultado(idioma, "descifrado", numero, descifrado);
                    }
                    case 3 -> seguir = false;
                    case 4 -> {
                        idioma = 3;
                        seguir = false;
                    }
                }
            }
        } while (idioma != 3);

        Ejercicio049_Utilidades.mostrarDespedida(idioma);
        scanner.close();
    }
}