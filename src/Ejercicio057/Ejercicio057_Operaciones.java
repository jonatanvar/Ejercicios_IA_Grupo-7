// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #57                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio057 | 2025-11-06

package Ejercicio057;

import java.util.Scanner;

public class Ejercicio057_Operaciones {

    public static void calcularHipotenusaTriangulo() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio057_Menus.obtenerIdioma();

        Ejercicio057_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "CÁLCULO DE HIPOTENUSA" : "CALCULATE HYPOTENUSE"
        );

        double ladoA, ladoB;

        do {
            System.out.print(idioma.equals("ES") ? "Ingrese la longitud del lado A: " : "Enter length of side A: ");
            ladoA = sc.nextDouble();
        } while (ladoA <= 0);

        do {
            System.out.print(idioma.equals("ES") ? "Ingrese la longitud del lado B: " : "Enter length of side B: ");
            ladoB = sc.nextDouble();
        } while (ladoB <= 0);

        double hipotenusa = Math.sqrt(elevarCuadrado(ladoA) + elevarCuadrado(ladoB));

        System.out.println("\nResultado:");
        System.out.printf(idioma.equals("ES") ? "La hipotenusa es: %.2f\n" : "The hypotenuse is: %.2f\n", hipotenusa);

        Ejercicio057_Utilidades.mostrarSelloCorto();
        Ejercicio057_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    public static double elevarCuadrado(double n) {
        return n * n;
    }

    public static double calcularHipotenusa(double a, double b) {
        return Math.sqrt(elevarCuadrado(a) + elevarCuadrado(b));
    }
}