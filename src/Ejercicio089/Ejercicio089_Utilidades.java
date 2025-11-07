// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Utilidades gráficas y estética visual                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio089 | 2025-11-12

package Ejercicio089;

import java.util.Scanner;

public class Ejercicio089_Utilidades {

    public static void mostrarEncabezado(String titulo) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-60s ║\n", titulo);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarPie(String msg) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-60s ║\n", msg);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n[Dany Noguera | Ejercicio089]\n");
    }

    public static int leerEntero(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int valor;
        do {
            System.out.print(msg);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }
}