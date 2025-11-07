// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #93                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio093 | 2025-11-06

package Ejercicio093;

import java.util.Scanner;

public class Ejercicio093_Operaciones {

    public static void teLeoNivelHumano() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio093_Menus.obtenerIdioma();

        Ejercicio093_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "TE LEO, TE PONGO ATENCION Y TE SUPERÓ" : "I READ YOU, I PAY ATTENTION AND SURPASS YOU"
        );

        int[] numeros = new int[5];
        int[] TOTALES = new int[5]; // 0: suma, 1: suma cuadrado, 2: suma cubo, 3: pares, 4: impares
        char simbolo = '*';

        // Ingreso de 5 números sin repetir
        for (int i = 0; i < 5; i++) {
            int num;
            do {
                System.out.print(idioma.equals("ES") ?
                        "Ingrese número " + (i + 1) + ": " :
                        "Enter number " + (i + 1) + ": ");
                num = sc.nextInt();
            } while (num < 0 || contiene(numeros, i, num));
            numeros[i] = num;
        }

        // Calculo cuadrados, cubos y conteo pares/impares
        TOTALES[0] = 0; // suma valores
        TOTALES[1] = 0; // suma cuadrados
        TOTALES[2] = 0; // suma cubos
        TOTALES[3] = 0; // pares
        TOTALES[4] = 0; // impares

        System.out.println("\nNúmero\tCuadrado\tCubo");
        System.out.println("-----------------------------");

        for (int i = 0; i < 5; i++) {
            int cuadrado = elevarAlCuadrado(numeros[i]);
            int cubo = elevarAlCubo(numeros[i]);
            System.out.printf("%d\t%d\t\t%d\n", numeros[i], cuadrado, cubo);

            TOTALES[0] += numeros[i];
            TOTALES[1] += cuadrado;
            TOTALES[2] += cubo;
            if (esPar(numeros[i])) TOTALES[3]++;
            else TOTALES[4]++;
        }

        System.out.println("\n───────── BARRAS DE TOTALES ─────────");
        System.out.print("Suma de valores   : "); Ejercicio093_Utilidades.imprimirBarra(TOTALES[0], simbolo);
        System.out.print("Suma de cuadrados : "); Ejercicio093_Utilidades.imprimirBarra(TOTALES[1], simbolo);
        System.out.print("Suma de cubos     : "); Ejercicio093_Utilidades.imprimirBarra(TOTALES[2], simbolo);
        System.out.print("Total pares       : "); Ejercicio093_Utilidades.imprimirBarra(TOTALES[3], simbolo);
        System.out.print("Total impares     : "); Ejercicio093_Utilidades.imprimirBarra(TOTALES[4], simbolo);

        Ejercicio093_Utilidades.mostrarSelloCorto();
        Ejercicio093_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    // ===== FUNCIONES =====
    public static boolean contiene(int[] arr, int hasta, int valor) {
        for (int i = 0; i < hasta; i++) {
            if (arr[i] == valor) return true;
        }
        return false;
    }

    public static int elevarAlCuadrado(int n) {
        return n * n;
    }

    public static int elevarAlCubo(int n) {
        return n * n * n;
    }

    public static boolean esPar(int n) {
        return n % 2 == 0;
    }
}