// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #62                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio062 | 2025-11-06

package Ejercicio062;

import java.util.Scanner;

public class Ejercicio062_Operaciones {

    public static void disminuyendo() {

        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio062_Menus.obtenerIdioma();

        Ejercicio062_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "DISMINUYENDO" : "DECREASING"
        );

        double n1 = leerNumero(idioma, 1);
        double n2 = leerNumero(idioma, 2);
        double n3 = leerNumero(idioma, 3);

        double menor = obtenerMenor(n1, n2, n3);

        System.out.println(
                idioma.equals("ES") ?
                        "\nEl número menor es: " + menor :
                        "\nThe smallest number is: " + menor
        );

        Ejercicio062_Utilidades.mostrarSelloCorto();
        Ejercicio062_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    // ===== FUNCIÓN PARA VALIDAR ENTRADAS POSITIVAS =====
    private static double leerNumero(String idioma, int index) {

        Scanner sc = new Scanner(System.in);
        double numero;

        do {
            System.out.print(
                    idioma.equals("ES") ?
                            "Ingrese el número " + index + ": " :
                            "Enter number " + index + ": "
            );

            while (!sc.hasNextDouble()) {
                System.out.print(idioma.equals("ES") ?
                        "Entrada inválida. Ingrese un número: " :
                        "Invalid input. Enter a number: ");
                sc.next();
            }

            numero = sc.nextDouble();

        } while (numero < 0);  // No permitir negativos

        return numero;
    }

    // ===== FUNCIÓN PARA OBTENER EL MENOR =====
    private static double obtenerMenor(double a, double b, double c) {
        double menor = a;
        if (b < menor) menor = b;
        if (c < menor) menor = c;
        return menor;
    }
}