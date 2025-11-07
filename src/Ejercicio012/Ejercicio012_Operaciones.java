// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Metadatos: Dany Noguera | dany.noguera@unah.hn | 012 | 2025-11-04          ║
// ║ Resumen: Funciones matemáticas puras (sin System.out).                     ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 012 | 2025-11-04

package Ejercicio012;

import java.util.Arrays;

public class Ejercicio012_Operaciones {

    public static int[] ordenarNumeros(int[] lista) {
        int[] copia = Arrays.copyOf(lista, lista.length);
        Arrays.sort(copia);
        return copia;
    }

    public static int contarPares(int[] lista) {
        int contador = 0;
        for (int n : lista) {
            if (n % 2 == 0) contador++;
        }
        return contador;
    }

    public static int contarImpares(int[] lista) {
        int contador = 0;
        for (int n : lista) {
            if (n % 2 != 0) contador++;
        }
        return contador;
    }

    // Convierte arreglo a texto para mostrarlo centrado
    public static String convertirAString(int[] lista) {
        return Arrays.toString(lista);
    }
}
