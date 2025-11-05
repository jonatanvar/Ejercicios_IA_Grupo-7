package Ejercicio91;

import java.util.Scanner;

public class Ejercicio91_Funciones {

    public static int[] leerListaSinRepetidos(Scanner sc, int n) {
        int[] lista = new int[n];
        for (int i = 0; i < n; i++) {
            int num;
            do {
                num = Ejercicio91_Utilidades.leerEntero(sc,
                        Ejercicio91_Utilidades.obtenerTexto(21) + (i + 1) + ": ");
                if (contiene(lista, i, num)) {
                    System.out.println(Ejercicio91_Utilidades.obtenerTexto(22) + num + ".");
                }
            } while (contiene(lista, i, num));
            lista[i] = num;
        }
        return lista;
    }

    private static boolean contiene(int[] arr, int hasta, int valor) {
        for (int i = 0; i < hasta; i++) {
            if (arr[i] == valor) return true;
        }
        return false;
    }

    public static int[] leerCincoNumeros(Scanner sc, int limite, int[] lista) {
        int[] seleccion = new int[5];
        for (int i = 0; i < 5; i++) {
            int num;
            do {
                num = Ejercicio91_Utilidades.leerEnteroRango(sc,
                        Ejercicio91_Utilidades.obtenerTexto(23) + (i + 1) + ": ", 0, limite);
                if (!estaEnLista(num, lista)) {
                    System.out.println(Ejercicio91_Utilidades.obtenerTexto(24) + num + ".");
                }
            } while (!estaEnLista(num, lista));
            seleccion[i] = num;
        }
        return seleccion;
    }

    private static boolean estaEnLista(int num, int[] lista) {
        for (int valor : lista) {
            if (valor == num) return true;
        }
        return false;
    }
}