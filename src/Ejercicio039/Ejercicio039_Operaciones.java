package Ejercicio039;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 039 | 2025-10-10
 */

public class Ejercicio039_Operaciones {

    public static void imprimirRombo(int filas, int idioma) {
        String msg = (idioma == 2) ? "PRINTING DIAMOND..." : "IMPRIMIENDO ROMBO...";
        System.out.println("\n" + msg + "\n");

        int n = filas / 2;  // Mitad superior (sin contar centro)

        // Parte superior (incluye línea central)
        for (int i = 0; i <= n; i++) {
            Ejercicio039_Utilidades.imprimirEspacios(n - i);
            System.out.print("*");
            if (i > 0) {
                Ejercicio039_Utilidades.imprimirEspacios(2 * i - 1);
                System.out.print("*");
            }
            System.out.println();
        }

        // Parte inferior
        for (int i = n - 1; i >= 0; i--) {
            Ejercicio039_Utilidades.imprimirEspacios(n - i);
            System.out.print("*");
            if (i > 0) {
                Ejercicio039_Utilidades.imprimirEspacios(2 * i - 1);
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}