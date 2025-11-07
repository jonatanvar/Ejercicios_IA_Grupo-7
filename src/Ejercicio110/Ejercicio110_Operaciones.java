// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #110                                     ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio110 | 2025-11-06

package Ejercicio110;

import java.util.Scanner;
import java.util.Random;

public class Ejercicio110_Operaciones {

    public static void matrizCuadradaOperacion() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio110_Menus.obtenerIdioma();

        Ejercicio110_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "MATRIZ CUADRADA Y SU TRANSPUESTA" : "SQUARE MATRIX AND ITS TRANSPOSE"
        );

        int n;

        // Solicitar tamaño de matriz válido
        do {
            System.out.print(idioma.equals("ES") ?
                    "Ingrese un número mayor a 2 y menor a 15: " :
                    "Enter a number greater than 2 and less than 15: ");
            n = sc.nextInt();
        } while (n <= 2 || n >= 15);

        int[][] matriz = new int[n][n];

        // Llenar la matriz con números positivos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = generarNumeroPositivo();
            }
        }

        // Mostrar la matriz original
        System.out.println(idioma.equals("ES") ? "\nMatriz original:" : "\nOriginal matrix:");
        Ejercicio110_Utilidades.imprimirMatriz(matriz);

        // Mostrar la matriz transpuesta
        System.out.println(idioma.equals("ES") ? "Matriz transpuesta:" : "Transpose matrix:");
        int[][] transpuesta = obtenerTranspuesta(matriz);
        Ejercicio110_Utilidades.imprimirMatriz(transpuesta);

        Ejercicio110_Utilidades.mostrarSelloCorto();
        Ejercicio110_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    // ===== FUNCIONES =====
    public static int generarNumeroPositivo() {
        Random rand = new Random();
        return rand.nextInt(100) + 1; // número positivo entre 1 y 100
    }

    public static int[][] obtenerTranspuesta(int[][] matriz) {
        int n = matriz.length;
        int[][] transpuesta = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        return transpuesta;
    }
}