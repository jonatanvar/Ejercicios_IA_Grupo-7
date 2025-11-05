package Ejercicio113;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 113 | 2025-10-21
 */
public class Ejercicio113_Main {

    private static final int MSG_FINALIZACION = 16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio113_Utilidades.mostrarSelloCorto();
        Ejercicio113_Utilidades.seleccionarIdioma(scanner);

        boolean ejecutar = true;

        int[][] distancias = UtilidadesGrafo.inicializarMatrizDistancias();

        while (ejecutar) {
            if (!Ejercicio113_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            Ejercicio113_Utilidades.mostrarEncabezado();

            Ejercicio113_Utilidades.imprimirMatriz(distancias);

            int[] trayecto = Ejercicio113_Utilidades.leerTrayecto(scanner);

            if (trayecto != null) {
                int distanciaTotal = Ejercicio113_Funciones.calcularDistanciaTrayecto(distancias, trayecto);

                if (distanciaTotal > 0) {
                    System.out.printf(Ejercicio113_Utilidades.obtenerTexto(13), distanciaTotal);
                } else if (distanciaTotal == -2) {
                    System.out.println(Ejercicio113_Utilidades.obtenerTexto(14));
                } else {
                    System.out.println(Ejercicio113_Utilidades.obtenerTexto(15));
                }
            }

            System.out.println();
        }

        scanner.close();
        System.out.println(Ejercicio113_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}