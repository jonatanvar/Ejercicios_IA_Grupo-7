// ╔═══════════════════════════════════════════════════════════════════════════╗
// ║ Utilidades visuales (estética del programa)                               ║
// ╚═══════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio106 | 2025-11-06

package Ejercicio106;

public class Ejercicio106_Utilidades {

    public static void mostrarEncabezado(String titulo) {
        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.printf ("║ %-67s ║\n", titulo);
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarPie(String msg) {
        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.printf ("║ %-67s ║\n", msg);
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n[Dany Noguera | Ejercicio106]\n");
    }

    public static void imprimirMatriz(double[][] matriz, String[] encabezadosFilas, String[] encabezadosColumnas) {

        System.out.printf("%-12s", " "); // esquina vacía

        for (String encabezado : encabezadosColumnas) {
            System.out.printf("%12s", encabezado);
        }
        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%-12s", encabezadosFilas[i]);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%12.2f", matriz[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }
}