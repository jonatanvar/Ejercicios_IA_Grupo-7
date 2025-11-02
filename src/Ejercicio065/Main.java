/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                    │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 065                               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente el ejercicio #65 se nos presenta:
 * Un estacionamiento cobra una cuota mínima de $2.00 por estacionarse hasta
 * tres horas. El estacionamiento cobra $0.50 adicionales por cada hora o fracción que se pase de tres horas. El cargo máximo para cualquier periodo dado de 24 horas es de $10.00. Suponga que ningún auto se estaciona durante más de 24 horas a la vez. Escriba un programa que calcule y muestre los cargos por estacionamiento para cada uno de tres clientes que estacionaron su auto ayer en este estacionamiento. Debe introducir las horas de estacionamiento para cada cliente. El programa debe imprimir los resultados en un formato tabular ordenado, debe calcular e imprimir el total de los recibos de ayer. El programa debe utilizar la función calcularCargos para determinar el cargo para cada cliente.
 * *El ejercicio debe llevar todos los requerimientos de los ejercicios anteriores
 * *Por el texto genera el calculo de los datos que ahí están, no es necesario que el usuario ingrese nada, genera la respuesta en un cuadro atractivo, y muestra los cálculos que realizaste al usuario, junto con la opción de ejecutar el programa varias veces si el usuario lo quiere.
 */

package Ejercicio065;

import java.util.Scanner;

public class Main {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(scanner);

        do {
            ejecutarEjercicio(scanner, idiomaActual);
            continuar = Menús.preguntarContinuar(scanner, idiomaActual);
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(Scanner scanner, String idioma) {
        double[] horas = {5.5, 8.0, 2.5}; // Datos predefinidos para 3 clientes
        double[] cargos = new double[3];
        double total = 0.0;

        for (int i = 0; i < 3; i++) {
            cargos[i] = Operaciones.calcularCargos(horas[i]);
            total += cargos[i];
        }

        Utilidades.mostrarResultados(horas, cargos, total, idioma);
        Utilidades.mostrarCalculos(horas, idioma);
    }
}