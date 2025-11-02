/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 056 | 2025-10-15 00:10 CST    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio056;

import java.util.Scanner;

public class Operaciones {
    public static String leerYValidarNombre(Scanner scanner, String idioma, int numero) {
        String nombre;
        boolean valido;
        do {
            System.out.print(Utilidades.obtenerTexto("INGRESE_NOMBRE", idioma) + numero + ": ");
            nombre = scanner.nextLine().trim();
            valido = !nombre.isEmpty() && validarSoloLetras(nombre);
            if (!valido) {
                Utilidades.mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return nombre;
    }

    public static String leerYValidarApellido(Scanner scanner, String idioma, int numero) {
        String apellido;
        boolean valido;
        do {
            System.out.print(Utilidades.obtenerTexto("INGRESE_APELLIDO", idioma) + numero + ": ");
            apellido = scanner.nextLine().trim();
            valido = !apellido.isEmpty() && validarSoloLetras(apellido);
            if (!valido) {
                Utilidades.mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return apellido;
    }

    private static boolean validarSoloLetras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
}