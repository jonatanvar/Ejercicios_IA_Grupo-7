package Ejercicio91;

import java.util.Scanner;

public class Ejercicio91_Main {

    private static final int MSG_OPCION = 4;
    private static final int MSG_TAMANIO = 20;
    private static final int MSG_FINALIZACION = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio91_Utilidades.mostrarSelloCorto();
        Ejercicio91_Utilidades.seleccionarIdioma(sc);

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio91_Utilidades.mostrarMenuEjecucion(sc)) {
                ejecutar = false;
                continue;
            }
            Ejercicio91_Utilidades.mostrarEncabezado();

            int n = Ejercicio91_Utilidades.leerEnteroRango(sc,
                    Ejercicio91_Utilidades.obtenerTexto(MSG_TAMANIO), 11, 99);

            int[] lista = Ejercicio91_Funciones.leerListaSinRepetidos(sc, n);
            Ejercicio91_Utilidades.mostrarLista(lista);

            int[] seleccion = Ejercicio91_Funciones.leerCincoNumeros(sc, n, lista);
            Ejercicio91_Utilidades.mostrarTabla(seleccion, lista);

            System.out.println();
        }

        sc.close();
        System.out.println(Ejercicio91_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}