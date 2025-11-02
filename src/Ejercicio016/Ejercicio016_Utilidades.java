/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 016 | 2025-10-10               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio016;

import java.util.Scanner;

public class Ejercicio016_Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSaludo() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("¡BIENVENIDA AL SISTEMA DE GESTIÓN DE CÓDIGO!", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("EJERCICIO 016: SEPARAR DÍGITOS", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static boolean mostrarIngresoNumero(Scanner scanner, int[] digitos) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("INGRESO DE UN NÚMERO DE 5 DÍGITOS", ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + centrarTexto("Ejemplo: 42339 o -42339", ANCHO - 2) + BORDE_DER);
        System.out.print("Ingrese el número: ");

        if (scanner.hasNextInt()) {
            int numero = scanner.nextInt();
            String numStr = String.valueOf(Math.abs(numero));
            if (numStr.length() == 5) {
                Ejercicio016_Operaciones.separarDigitos(numero, digitos);
                imprimirLineaConDato("Número ingresado: " + numero);
                System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
                return true;
            }
        } else {
            scanner.next(); // Limpiar entrada inválida
        }
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
        return false;
    }

    public static void mostrarErrorEntrada() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("ERROR: Ingrese solo un número entero de 5 dígitos", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarResultado(int[] digitos) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("DÍGITOS SEPARADOS", ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        String resultado = digitos[0] + "   " + digitos[1] + "   " + digitos[2] + "   " + digitos[3] + "   " + digitos[4];
        System.out.println(BORDE_IZQ + centrarTexto(resultado, ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 016 | 2025-10-10", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }

    private static void imprimirLineaConDato(String texto) {
        int espaciosRestantes = ANCHO - texto.length() - 2;
        if (espaciosRestantes < 0) espaciosRestantes = 0;
        System.out.println(BORDE_IZQ + texto + " ".repeat(espaciosRestantes) + BORDE_DER);
    }
}