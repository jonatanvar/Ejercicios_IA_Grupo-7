/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 046 | 2025-10-14               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Haga un programa que calcule el valor absoluto de un número,
 * valida las entradas y si ingresa el usuario una letra o un carácter
 *  muestra un mensaje de que está haciendo mal, un punto importante es el siguiente
 * (sin usar la librería math.h). Con esa información presenta nuestra modularidad de 4 archivos.
 */

package Ejercicio046;

import java.util.Scanner;

public class Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(scanner);

        do {
            int opcion = Menús.mostrarMenuPrincipal(scanner, idiomaActual);
            if (opcion == 1) {
                double numero = Operaciones.leerYValidarNumero(scanner, idiomaActual);
                double valorAbsoluto = Operaciones.calcularValorAbsoluto(numero);
                Utilidades.mostrarResultado(valorAbsoluto, idiomaActual);
                continuar = Menús.preguntarContinuar(scanner, idiomaActual);
            } else {
                Menús.mostrarDespedida(idiomaActual);
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }
}