/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 036 | 2025-10-13               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio036;

import java.util.Arrays;
import java.util.Scanner;

public class Operaciones {
    public static int[] leerYValidarNumeros(Scanner scanner, String idioma) {
        int[] numeros = new int[5];
        for (int i = 0; i < 5; i++) {
            boolean valido = false;
            while (!valido) {
                System.out.print(Utilidades.obtenerTexto("INGRESE_NUMERO", idioma) + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numeros[i] = scanner.nextInt();
                    if (numeros[i] >= 1 && numeros[i] <= 12) {
                        valido = true;
                    } else {
                        Utilidades.mostrarErrorLimites(idioma);
                    }
                } else {
                    scanner.next();
                    Utilidades.mostrarErrorEntrada(idioma);
                }
            }
        }
        return numeros;
    }

    public static int[] ordenarNumeros(int[] numeros) {
        int[] ordenados = numeros.clone();
        Arrays.sort(ordenados);
        return ordenados;
    }
}