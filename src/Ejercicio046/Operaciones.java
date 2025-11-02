/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 046 | 2025-10-14               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio046;

import java.util.Scanner;

public class Operaciones {
    public static double leerYValidarNumero(Scanner scanner, String idioma) {
        double numero = 0.0;
        boolean valido = false;
        do {
            System.out.print(obtenerTexto("INGRESE_NUMERO", idioma));
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                valido = true;
            } else {
                scanner.next();
                mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return numero;
    }

    public static double calcularValorAbsoluto(double numero) {
        if (numero < 0) {
            return -numero;
        }
        return numero;
    }

    private static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + "═".repeat(68) + "┐");
        System.out.println("│" + centrarTexto(obtenerTexto("ERROR_ENTRADA_NUMERO", idioma), 68) + "│");
        System.out.println("└" + "═".repeat(68) + "┘");
    }

    private static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "INGRESE_NUMERO": return "Ingrese un número: ";
                case "ERROR_ENTRADA_NUMERO": return "ERROR: Ingrese un número válido, no letras ni caracteres";
                default: return "";
            }
        } else {
            switch (clave) {
                case "INGRESE_NUMERO": return "Enter a number: ";
                case "ERROR_ENTRADA_NUMERO": return "ERROR: Enter a valid number, not letters or characters";
                default: return "";
            }
        }
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}