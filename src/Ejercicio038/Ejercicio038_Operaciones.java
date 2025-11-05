package Ejercicio038;

/*
 * Cristina Cruz | Lis❤  | cristinacruz@unah.hn | 038 | 2025-10-10
 */

public class Ejercicio038_Operaciones {

    /** Dibuja el rombo hueco usando ciclos anidados */
    public static void imprimirRombo(int idioma) {
        String msg = (idioma == 2) ? "PRINTING DIAMOND..." : "IMPRIMIENDO ROMBO...";
        System.out.println("\n" + msg + "\n");

        final int n = 4;

        // Parte superior (incluye línea central)
        for (int i = 1; i <= n; i++) {
            Ejercicio038_Utilidades.imprimirEspacios(n - i);
            System.out.print("*");
            if (i > 1) {
                Ejercicio038_Utilidades.imprimirEspacios(2 * (i - 1) - 1);
                System.out.print("*");
            }
            System.out.println();
        }

        // Parte inferior
        for (int i = n - 1; i >= 1; i--) {
            Ejercicio038_Utilidades.imprimirEspacios(n - i);
            System.out.print("*");
            if (i > 1) {
                Ejercicio038_Utilidades.imprimirEspacios(2 * (i - 1) - 1);
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}