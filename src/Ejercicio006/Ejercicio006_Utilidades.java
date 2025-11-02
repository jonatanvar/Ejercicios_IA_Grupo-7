/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 006 | 2025-10-09               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio006;

import java.util.Scanner;

public class Ejercicio006_Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSaludo() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("¡BIENVENIDA AL SISTEMA DE GESTIÓN DE CÓDIGO!", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("EJERCICIO 006: ARITMÉTICA TRUQUEADA", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarIngresoNumeros(Scanner scanner, double[] numeros) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("INGRESO DE LOS DOS NÚMEROS", ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");

        // Primer número
        System.out.print("Ingrese el primer número: ");
        numeros[0] = scanner.nextDouble();
        imprimirLineaConDato("Ingrese el primer número: " + numeros[0]);

        // Segundo número
        System.out.print("Ingrese el segundo número: ");
        numeros[1] = scanner.nextDouble();
        imprimirLineaConDato("Ingrese el segundo número: " + numeros[1]);

        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    // Método auxiliar para mantener el diseño alineado
    private static void imprimirLineaConDato(String texto) {
        int espaciosRestantes = ANCHO - texto.length() - 2;
        if (espaciosRestantes < 0) espaciosRestantes = 0;
        System.out.println(BORDE_IZQ + texto + " ".repeat(espaciosRestantes) + BORDE_DER);
    }


    public static void mostrarResultado(double mayor, double menor, double suma, double resta, double division, boolean divisionPosible) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("NÚMEROS ORDENADOS (MAYOR A MENOR)", ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + centrarTexto("Mayor: " + mayor + " | Menor: " + menor, ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");

        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("RESULTADOS DE LAS OPERACIONES", ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + centrarTexto("Suma: " + suma, ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Diferencia: " + resta, ANCHO - 2) + BORDE_DER);
        if (divisionPosible) {
            System.out.println(BORDE_IZQ + centrarTexto("División: " + division, ANCHO - 2) + BORDE_DER);
        } else {
            System.out.println(BORDE_IZQ + centrarTexto("No se puede dividir entre 0", ANCHO - 2) + BORDE_DER);
        }
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 006 | 2025-10-09", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}