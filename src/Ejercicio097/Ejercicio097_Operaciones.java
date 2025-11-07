// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #97                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio097 | 2025-11-06

package Ejercicio097;

import java.util.Scanner;
import java.util.Random;

public class Ejercicio097_Operaciones {

    public static void matrizOperacion() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio097_Menus.obtenerIdioma();

        Ejercicio097_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "OPERACIÓN CON MATRIZ" : "MATRIX OPERATION"
        );

        int M, N;

        // Solicitar y validar dimensiones
        do {
            System.out.print(idioma.equals("ES") ?
                    "Ingrese el número de filas (2-5): " :
                    "Enter number of rows (2-5): ");
            M = sc.nextInt();
        } while (M < 2 || M > 5);

        do {
            System.out.print(idioma.equals("ES") ?
                    "Ingrese el número de columnas (2-5): " :
                    "Enter number of columns (2-5): ");
            N = sc.nextInt();
        } while (N < 2 || N > 5);

        int[][] matriz = new int[M][N];

        // Inicializar matriz en cero
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = 0;
            }
        }

        System.out.println("\n" + (idioma.equals("ES") ? "Matriz inicial:" : "Initial matrix:"));
        Ejercicio097_Utilidades.imprimirMatriz(matriz);

        // Sustituir filas impares
        rellenarFilasImpares(matriz);
        System.out.println(idioma.equals("ES") ? "Matriz con filas impares reemplazadas:" : "Matrix with odd rows replaced:");
        Ejercicio097_Utilidades.imprimirMatriz(matriz);

        // Sustituir columnas pares
        rellenarColumnasPares(matriz);
        System.out.println(idioma.equals("ES") ? "Matriz final con columnas pares reemplazadas:" : "Final matrix with even columns replaced:");
        Ejercicio097_Utilidades.imprimirMatriz(matriz);

        Ejercicio097_Utilidades.mostrarSelloCorto();
        Ejercicio097_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    public static void rellenarFilasImpares(int[][] matriz) {
        Random rand = new Random();
        for (int i = 0; i < matriz.length; i++) {
            if (i % 2 == 1) { // filas impares
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = generarAleatorio();
                }
            }
        }
    }

    public static void rellenarColumnasPares(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            if (j % 2 == 0) { // columnas pares (0-based)
                for (int i = 0; i < matriz.length; i++) {
                    matriz[i][j] = generarAleatorio();
                }
            }
        }
    }

    public static int generarAleatorio() {
        Random rand = new Random();
        return rand.nextInt(80); // número aleatorio menor que 80
    }
}