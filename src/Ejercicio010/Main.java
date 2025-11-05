/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 010 | 2025-10-22
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que lee el lado de un cuadrado e imprime su área y perímetro, incluyendo las fórmulas de cálculo.
 */

package Ejercicio_010;

import java.util.Scanner;

/**
 * Clase principal que gestiona la entrada de datos (lado del cuadrado)
 * y utiliza las clases Operaciones y Utilidades para mostrar resultados.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mensaje de bienvenida desde Utilidades
        System.out.println(Utilidades.getMensajeBienvenida());

        // Lectura del lado del cuadrado
        System.out.print("Escriba la longitud del lado del cuadrado (valor en coma flotante): ");
        double lado = scanner.nextDouble();

        // Instanciación de la clase Operaciones
        Operaciones operaciones = new Operaciones();

        // Cálculos
        double area = operaciones.calcularArea(lado);
        double perimetro = operaciones.calcularPerimetro(lado);

        // Impresión de resultados utilizando Utilidades
        Utilidades.mostrarResultado("Área", "Área = lado * lado", lado, area);
        Utilidades.mostrarResultado("Perímetro", "Perímetro = 4 * lado", lado, perimetro);

        scanner.close();
    }
}
