/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 041 | 2025-10-13               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio041;

import java.util.Scanner;

public class Operaciones {
    public static int leerYValidarNumero(Scanner scanner, String idioma) {
        int numero = 0;
        boolean valido = false;
        do {
            System.out.print(Utilidades.obtenerTexto("INGRESE_NUMERO", idioma));
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero >= 1 && numero <= 15) {
                    valido = true;
                } else {
                    Utilidades.mostrarErrorLimites(idioma);
                }
            } else {
                scanner.next();
                Utilidades.mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return numero;
    }

    public static int[][] generarTablaCalculos(int n) {
        int[][] tabla = new int[n][5]; // 5 columnas: #, N, N², N³, 2N-1
        for (int i = 0; i < n; i++) {
            tabla[i][0] = i + 1;           // #
            tabla[i][1] = i + 1;           // N
            tabla[i][2] = (i + 1) * (i + 1); // N²
            tabla[i][3] = (i + 1) * (i + 1) * (i + 1); // N³
            tabla[i][4] = 2 * (i + 1) - 1; // 2N-1
        }
        return tabla;
    }

    public static int[] calcularTotales(int[][] tabla) {
        int[] totales = new int[4];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 1; j < 5; j++) {
                totales[j - 1] += tabla[i][j];
            }
        }
        return totales;
    }

    public static int[] calcularPromedios(int[][] tabla) {
        int[] totales = calcularTotales(tabla);
        int[] promedios = new int[4];
        for (int i = 0; i < 4; i++) {
            promedios[i] = totales[i] / tabla.length;
        }
        return promedios;
    }
}